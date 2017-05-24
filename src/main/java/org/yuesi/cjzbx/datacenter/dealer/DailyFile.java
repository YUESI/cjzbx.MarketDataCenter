/**
 * 
 */
package org.yuesi.cjzbx.datacenter.dealer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

import org.yuesi.cjzbx.datacenter.model.MarketTradeDaily;
import org.yuesi.cjzbx.datacenter.model.mapper.MarketTradeDailyMapper;
import org.yuesi.cjzbx.datacenter.util.CommonUtil;
import org.yuesi.cjzbx.datacenter.util.DateUtil;

/**
 * @author qiuwenhu
 * @date 2017年3月6日下午11:21:24
 */
public class DailyFile {
	private String sepa = java.io.File.separator;

	private DailyFile() {

	}

	private static final DailyFile single = new DailyFile();

	public static DailyFile getInstance() {
		return single;
	}

	public void getDataFromDailyFile(String tradedate, String path, MarketTradeDailyMapper mapper) {
		
		String yearDir = tradedate.split("-")[0];
		String dailyFileName = tradedate.replaceAll("-", "");
		String dailyFilePath = path + sepa + yearDir + sepa + dailyFileName + ".csv";

		MarketTradeDaily record = new MarketTradeDaily();
		
		File f = new File(dailyFilePath);
		if (f.exists()) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f), "GBK"));
				String lineTxt = null;
				int lineNo = 0;
				while ((lineTxt = br.readLine()) != null) {
					lineNo ++;
					if (lineNo == 1) continue;
					String[] items = lineTxt.split(",");
					record.setTradedate(DateUtil.stringToDate(tradedate));
					record.setCodeid(CommonUtil.normCodeid(items[1]));
					record.setOpen(CommonUtil.strToBigDecimal(items[5]));
					if (record.getOpen() == BigDecimal.valueOf(0)) continue;
					record.setHigh(CommonUtil.strToBigDecimal(items[6]));
					record.setLow(CommonUtil.strToBigDecimal(items[7]));
					record.setClose(CommonUtil.strToBigDecimal(items[4]));
					record.setVolume(Long.parseLong(items[9]));
					record.setAmount(Long.parseLong(items[11]));
					mapper.insert(record);
				}
				br.close();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
