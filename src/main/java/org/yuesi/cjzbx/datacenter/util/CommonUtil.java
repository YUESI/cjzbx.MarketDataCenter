/**
 * 
 */
package org.yuesi.cjzbx.datacenter.util;

import java.math.BigDecimal;

/**
 * @author qiuwenhu
 * @date 2017年5月24日下午9:24:29
 */
public class CommonUtil {

	public static String normCodeid(String sixNo) {
		String result;
		String firstNo = "0";
		
		if(sixNo.length() == 6) 
			firstNo = sixNo.substring(0, 1);
		
		switch (firstNo) {
			case "0":
			case "3":
				result = sixNo + ".SZ";
				break;
			case "6":
			case "9":
				result = sixNo + ".SH";
				break;
			default:
				result =sixNo + ".SH";
		}
		return result;
	}
	
	public static BigDecimal strToBigDecimal(String str) {
		BigDecimal bd=new BigDecimal(str); 
		bd=bd.setScale(2, BigDecimal.ROUND_HALF_UP); 
		return bd;
	}
}
