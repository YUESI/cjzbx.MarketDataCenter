package org.yuesi.cjzbx.datacenter.server;

import org.yuesi.cjzbx.datacenter.model.MarketTradeDaily;

/**
 * 数据导入业务
 * @author qiuwenhu
 * @date 2016年11月2日上午1:58:44
 */
public interface TradeDailyServer {
	
	public MarketTradeDaily find(String tradedate, String codeid);

	public void importMarketData(String tradedate);
}
