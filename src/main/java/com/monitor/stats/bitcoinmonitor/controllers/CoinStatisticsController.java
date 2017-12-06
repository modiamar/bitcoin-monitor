package com.monitor.stats.bitcoinmonitor.controllers;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.monitor.stats.bitcoinmonitor.domain.CoinStatistics;
import com.monitor.stats.bitcoinmonitor.services.CoinStatisticsService;

@RestController
public class CoinStatisticsController {
	
	private CoinStatisticsService coinStatisticsService;
	
	public CoinStatisticsController(CoinStatisticsService coinStatisticsService) {
		super();
		this.coinStatisticsService = coinStatisticsService;
	}

	@GetMapping("/request-stats")
	public ArrayList<CoinStatistics> requestCoinStats() throws JsonParseException, JsonMappingException, JSONException, IOException{
		return this.coinStatisticsService.callStatistics();
		
	}

}
