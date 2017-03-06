/**
 * 
 */
package org.yuesi.cjzbx.datacenter.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author qiuwenhu
 * @date 2017年3月6日下午10:52:08
 */
@Component
public class DataCenterConfig {
	@Value("${server.port}")
	private String port;

	@Value("${my.datayespath}")
	private String dailyDataPath;

	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}

	/**
	 * @return the dailyDataPath
	 */
	public String getDailyDataPath() {
		return dailyDataPath;
	}

	/**
	 * @param dailyDataPath
	 *            the dailyDataPath to set
	 */
	public void setDailyDataPath(String dailyDataPath) {
		this.dailyDataPath = dailyDataPath;
	}

	/**
	 * @param port
	 *            the port to set
	 */
	public void setPort(String port) {
		this.port = port;
	}

}
