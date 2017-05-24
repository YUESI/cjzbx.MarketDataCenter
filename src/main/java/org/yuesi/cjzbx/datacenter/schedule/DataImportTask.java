package org.yuesi.cjzbx.datacenter.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.yuesi.cjzbx.datacenter.server.TradeDailyServer;

@Component
public class DataImportTask {
	
	@Autowired
	private TradeDailyServer server;

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() {
		System.out.println(server.testStr());
		System.out.println("The time is now " + dateFormat.format(new Date()));
	}

	// TODO 增加每年的交易日
}
