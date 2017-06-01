package org.yuesi.cjzbx.datacenter.dealer;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class DataYesTest {
	static DataYes tc;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		tc = DataYes.getInstance();
	}

	@Test
	public void testGetTradeCal() {
		assertTrue(tc.getTradeCal().contains("\"retMsg\":\"Success\""));
	}

	@Test
	public void testGetTradeCal2() {
		String beginDate = "19910101";
		String endDate = "19911231";
		assertTrue(tc.getTradeCal(beginDate, endDate).contains("\"retMsg\":\"Success\""));
	}

	@Test
	public void testGetSecTips() {
		assertTrue(tc.getSecTips().contains("\"retMsg\":\"Success\""));
	}

}
