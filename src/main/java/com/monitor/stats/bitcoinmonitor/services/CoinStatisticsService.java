package com.monitor.stats.bitcoinmonitor.services;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.monitor.stats.bitcoinmonitor.domain.CoinStatistics;

public interface CoinStatisticsService {

	public ArrayList<CoinStatistics> callStatistics() throws JsonParseException, JsonMappingException, JSONException, IOException;
	public void analyzeData();
}
