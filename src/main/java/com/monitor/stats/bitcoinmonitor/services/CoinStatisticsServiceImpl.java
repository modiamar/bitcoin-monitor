package com.monitor.stats.bitcoinmonitor.services;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.monitor.stats.bitcoinmonitor.domain.CoinStatistics;
import com.monitor.stats.bitcoinmonitor.webscrape.CoinStatisticsGetter;

@Service
public class CoinStatisticsServiceImpl implements CoinStatisticsService {
	
	private CoinStatisticsGetter coinStatisticsGetter;
		
	public CoinStatisticsServiceImpl(CoinStatisticsGetter coinStatisticsGetter) {
		super();
		this.coinStatisticsGetter = coinStatisticsGetter;
	}

	@Override
	public ArrayList<CoinStatistics> callStatistics() throws JsonParseException, JsonMappingException, JSONException, IOException {	
		return this.coinStatisticsGetter.getCoinStatisticFromApi();
		
	}

	@Override
	public void analyzeData() {
		// TODO Auto-generated method stub
		
	}

}
