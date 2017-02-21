package org.yuesi.cjzbx.datacenter.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.yuesi.cjzbx.datacenter.dealer.DataYes;
import org.yuesi.cjzbx.datacenter.domain.MarketTradeCal;
import org.yuesi.cjzbx.datacenter.domain.mapper.MarketTradeCalMapper;
import org.yuesi.cjzbx.datacenter.util.JsonUtil;

import net.sf.json.JSONObject;

@Service
public class MarketTradeCalImporter {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	private MarketTradeCalMapper mapper;
	private DataYes dateYes;
	String tradeCalData = "";
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public MarketTradeCalImporter() {
		dateYes = DataYes.getInstance();
	}

	private List<MarketTradeCal> getTradeCalData(String begin, String end) {
		tradeCalData = dateYes.getTradeCal(begin, end);

		List<JSONObject> list = JsonUtil.getDataObjList(tradeCalData);
		List<MarketTradeCal> result = new ArrayList<MarketTradeCal>(list.size());
		for (JSONObject obj : list) {
			MarketTradeCal tradeCal = new MarketTradeCal();
			tradeCal.setExchangecd(obj.getString("exchangeCD"));
			String test = obj.getString("calendarDate");
			try {
				tradeCal.setCalendardate(sdf.parse(test));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			tradeCal.setIsopen(obj.getInt("isOpen") > 0);
			tradeCal.setIsweekend(obj.getInt("isWeekEnd") > 0);
			tradeCal.setIsmonthend(obj.getInt("isMonthEnd") > 0);
			tradeCal.setIsquarterend(obj.getInt("isQuarterEnd") > 0);
			tradeCal.setIsyearend(obj.getInt("isYearEnd") > 0);
			result.add(tradeCal);
		}
		return result;
	}

	public int insert(String begin, String end) {
		List<MarketTradeCal> list = getTradeCalData(begin, end);
		for (MarketTradeCal obj : list) {
			try {
				mapper.insert(obj);
			} catch (DuplicateKeyException e) {
				logger.warn("Duplicate Key" + e.getMessage());
			}
		}
		return list.size();
	}

	// TODO 增加下一年交易日
}
