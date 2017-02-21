package org.yuesi.cjzbx.datacenter.dealer;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class DataYes {
	// 创建http client
	private static CloseableHttpClient httpClient = createHttpsClient();

	private DataYes() {
	}

	private static final DataYes single = new DataYes();

	// 静态工厂方法
	public static DataYes getInstance() {
		return single;
	}

	/***
	 * To obtain the current date, to determine whether the current date is a trading day
	 * @return Stringify json that contains trading date information 
	 */
	public String getTradeCal() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");// 设置日期格式
		String strDate = df.format(new Date());
		return getTradeCal(strDate, strDate);
	}
	
	/***
	 * To get a range of trading day information from a date segment
	 * @param beginDate 
	 * @param endDate Date format "yyyyMMdd"
	 * @return Stringify json that contains trading date information
	 */
	public String getTradeCal(String beginDate, String endDate) {
		String url = "https://api.wmcloud.com:443/data/v1/api/master/getTradeCal.json?field=&exchangeCD=XSHG,XSHE&beginDate="
				+ beginDate + "&endDate=" + endDate + "";
		return getData(url);
	}

	public String getSecTips() {
		String url = "https://api.wmcloud.com:443/data/v1/api/market/getSecTips.json?field=&tipsTypeCD=H,R";
		return getData(url);
	}

	@SuppressWarnings("finally")
	private String getData(String url) {
		String body = "";
		String ACCESS_TOKEN = "e35a2b2532d5dbf0f6b0cb5d59f51428a5753bc19bdc6d780ab0ad96cddf71ac";

		HttpGet httpGet = new HttpGet(url);
		// 在header里加入 Bearer {token}，添加认证的token，并执行get请求获取json数据
		httpGet.addHeader("Authorization", "Bearer " + ACCESS_TOKEN);
		CloseableHttpResponse response;
		try {
			response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			body = EntityUtils.toString(entity);
			System.out.println(body);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return body;
		}
	}

	// 创建http client
	@SuppressWarnings("deprecation")
	private static CloseableHttpClient createHttpsClient() {
		X509TrustManager x509mgr = new X509TrustManager() {
			public void checkClientTrusted(X509Certificate[] xcs, String string) {
			}

			public void checkServerTrusted(X509Certificate[] xcs, String string) {
			}

			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};
		// 因为java客户端要进行安全证书的认证，这里我们设置ALLOW_ALL_HOSTNAME_VERIFIER来跳过认证，否则将报错
		SSLConnectionSocketFactory sslsf = null;
		try {
			SSLContext sslContext = SSLContext.getInstance("TLS");
			sslContext.init(null, new TrustManager[] { x509mgr }, null);
			sslsf = new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return HttpClients.custom().setSSLSocketFactory(sslsf).build();
	}

}
