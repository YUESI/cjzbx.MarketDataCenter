package org.yuesi.cjzbx.datacenter.util;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DateUtilTest {

	@Test
	public void testStringToDate() {
		assertEquals(DateUtil.stringToDate(DateUtil.getYYYY_MM_DD()).getDate(),
				(new Date()).getDate());
	}

}
