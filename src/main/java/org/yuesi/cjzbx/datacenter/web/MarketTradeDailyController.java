package org.yuesi.cjzbx.datacenter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yuesi.cjzbx.datacenter.model.MarketTradeDaily;
import org.yuesi.cjzbx.datacenter.server.TradeDailyServer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "日行情相关的接口")
@RestController
@RequestMapping("/marketTradeDaily")
public class MarketTradeDailyController {
	@Autowired
	private TradeDailyServer server;

	@RequestMapping("/test")
	@ApiOperation(value = "测试操作", notes = "无参数的测试操作，仅用来确认api是否可以访问", httpMethod = "POST")
	public String test() {
		return "test abc";
	}

	@RequestMapping("/find")
	@ApiOperation(value = "获取行情数据", notes = "某个某股的高开低收等数据", httpMethod = "POST")
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "date", value = "交易日", defaultValue = "1990-12-19", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "codeid", value = "证券代码带后缀", defaultValue = "600601.SH", required = true, paramType = "query", dataType = "String") })
	public MarketTradeDaily select(@RequestParam String date, @RequestParam String codeid) {
		return server.find(date, codeid);
	}

	@RequestMapping("/add")
	@ApiOperation(value = "添加某一天的全部行情数据", notes = "从日行情文件中逐行读入所有个股的行情数据，并添加入数据库", httpMethod = "POST")
	@ApiImplicitParam(name = "date", value = "交易日", defaultValue = "2016-10-20", required = true, paramType = "query", dataType = "String")
	public String add(@RequestParam String date) {
		server.importMarketData(date);
		return date;
	}
	
	@RequestMapping("/del")
	@ApiOperation(value = "删除某一天的全部行情数据", notes = "从数据库中删除某日所有个股的行情数据", httpMethod = "POST")
	@ApiImplicitParam(name = "date", value = "交易日", defaultValue = "2016-10-20", required = true, paramType = "query", dataType = "String")
	public String del(String date) {
		server.deleteMarketData(date);
		return date;
	}
	
}
