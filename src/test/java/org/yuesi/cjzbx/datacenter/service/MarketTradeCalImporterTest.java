package org.yuesi.cjzbx.datacenter.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yuesi.cjzbx.datacenter.dealer.MarketTradeCalImporter;

@RunWith(SpringRunner.class) 
@SpringBootTest
public class MarketTradeCalImporterTest {
	@Autowired
	private MarketTradeCalImporter importer;
 
	@Test
	public void testInsert()  {
		int count;
		try {
			// TODO 修改参数
			count = importer.insert("19900101", "19901231");
			assertTrue(count > 1);
		} catch (Exception e) {
			//TODO 日志
			e.printStackTrace();
		}
	}

}
