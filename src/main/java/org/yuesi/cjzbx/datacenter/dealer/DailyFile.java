/**
 * 
 */
package org.yuesi.cjzbx.datacenter.dealer;

/**
 * @author qiuwenhu
 * @date 2017年3月6日下午11:21:24
 */
public class DailyFile {
	
	
	private DailyFile() {

	}
	
	private static final DailyFile single = new DailyFile();

	public static DailyFile getInstance() {
		return single;
	}
	
	private boolean existYearDir(String tradedate) {
		return false;
	}
	
	private boolean existDailyFile(String tradedate) {
		return false;
	}
	
	public void getDataFromDailyFile(String tradedate, String path) {
		System.out.println(path);
		if(existYearDir(tradedate) && existDailyFile(tradedate)) {
			
		} 
	}
}
