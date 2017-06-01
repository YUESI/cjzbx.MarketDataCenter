package org.yuesi.cjzbx.datacenter.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.yuesi.cjzbx.datacenter.server.TradeDailyServer;
import org.yuesi.cjzbx.datacenter.util.DateUtil;

@Component
public class DataImportTask {
	
	@Autowired
	private TradeDailyServer server;

	//private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(cron = "0 15 16 * * 1-5")
	public void importDailyData() {
		//System.out.println(server.testStr());
		//System.out.println("The time is now " + dateFormat.format(new Date()));
		String date = DateUtil.getYYYY_MM_DD();
		server.importMarketData(date);
	}
	
	// TODO 增加每年的交易日
}
