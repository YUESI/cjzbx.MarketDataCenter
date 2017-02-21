package org.yuesi.cjzbx.datacenter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yuesi.cjzbx.datacenter.domain.MarketTradeDaily;
import org.yuesi.cjzbx.datacenter.domain.mapper.MarketTradeDailySqlProvider;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

//@Api(value="日行情相关的接口")
//@RestController
//@RequestMapping("/marketTradedaily")
public class MarketTradeDailyController {
	@Autowired
	private MarketTradeDailySqlProvider server;

	@RequestMapping("/add")
	@ApiOperation(notes = "添加用户", value = "添加一个用户", httpMethod = "POST")
	@ApiImplicitParam(name = "marketTradedaily", value = "用户详细实体marketTradedaily", required = true, dataType = "MarketTradedaily")
	public String add(@RequestBody MarketTradeDaily marketTradedaily) {
		return "hello " + server.insertSelective(marketTradedaily);
	}
}
