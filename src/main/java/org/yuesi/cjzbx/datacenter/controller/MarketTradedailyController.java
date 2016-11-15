package org.yuesi.cjzbx.datacenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yuesi.cjzbx.datacenter.dao.MarketTradedailyServer;
import org.yuesi.cjzbx.datacenter.model.MarketTradedaily;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(value="日行情相关的接口")
@RestController
@RequestMapping("/marketTradedaily")
public class MarketTradedailyController {
	@Autowired
	private MarketTradedailyServer server;

	@RequestMapping("/add")
	@ApiOperation(notes = "添加用户", value = "添加一个用户", httpMethod = "POST")
	@ApiImplicitParam(name = "marketTradedaily", value = "用户详细实体marketTradedaily", required = true, dataType = "MarketTradedaily")
	public String add(@RequestBody MarketTradedaily marketTradedaily) {
		return "hello " + server.add(marketTradedaily);
	}
}
