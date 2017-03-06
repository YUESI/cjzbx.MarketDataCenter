/**
 * 
 */
package org.yuesi.cjzbx.datacenter.config;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author qiuwenhu
 * @date 2017年3月6日下午11:00:03
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
public class DataCenterConfigTest {
	@Autowired
	private DataCenterConfig dataCenterConfig; 

	/**
	 * Test method for {@link org.yuesi.cjzbx.datacenter.config.DataCenterConfig#getPort()}.
	 */
	@Test
	public void testGetPort() {
		assertEquals(dataCenterConfig.getPort(), "-1");
	}

}
