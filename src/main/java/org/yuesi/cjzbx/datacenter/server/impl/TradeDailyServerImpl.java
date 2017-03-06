package org.yuesi.cjzbx.datacenter.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.yuesi.cjzbx.datacenter.config.DataCenterConfig;
import org.yuesi.cjzbx.datacenter.dealer.DailyFile;
import org.yuesi.cjzbx.datacenter.model.MarketTradeDaily;
import org.yuesi.cjzbx.datacenter.model.mapper.MarketTradeDailyMapper;
import org.yuesi.cjzbx.datacenter.server.TradeDailyServer;
import org.yuesi.cjzbx.datacenter.util.DateUtil;

/**
 * 
 * @author qiuwenhu
 * @date 2017年3月6日上午12:37:26
 */
@Repository
public class TradeDailyServerImpl implements TradeDailyServer {
	@Autowired
	private MarketTradeDailyMapper mapper;

	@Autowired
	private DataCenterConfig config;

	/* (non-Javadoc)
	 * @see org.yuesi.cjzbx.datacenter.server.TradeDailyServer#find()
	 */
	public MarketTradeDaily find(String tradedate, String codeid) {
		return mapper.selectByPrimaryKey(DateUtil.stringToDate(tradedate), codeid);
	}

	/* (non-Javadoc)
	 * @see org.yuesi.cjzbx.datacenter.server.TradeDailyServer#importMarketData(java.util.Date)
	 */
	public void importMarketData(String tradedate) {
		DailyFile.getInstance().getDataFromDailyFile(tradedate, config.getDailyDataPath());
	}
	
}
