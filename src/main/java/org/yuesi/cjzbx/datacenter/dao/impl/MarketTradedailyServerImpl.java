package org.yuesi.cjzbx.datacenter.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.yuesi.cjzbx.datacenter.dao.MarketTradedailyServer;
import org.yuesi.cjzbx.datacenter.model.MarketTradedaily;
import org.yuesi.cjzbx.datacenter.model.mapper.MarketTradedailyMapper;

@Repository
public class MarketTradedailyServerImpl implements MarketTradedailyServer {

	@Autowired
	private MarketTradedailyMapper mapper;
	
	public boolean add(MarketTradedaily marketTradedaily) {
        return mapper.insert(marketTradedaily) > 0;
	}
	
    public List<MarketTradedaily> findAll() {
        return mapper.selectByExample(null);
    }

}
