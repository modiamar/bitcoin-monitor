package com.monitor.stats.bitcoinmonitor.webscrape;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.monitor.stats.bitcoinmonitor.domain.CoinStatistics;

public interface CoinStatisticsGetter {
	
	public ArrayList<CoinStatistics> getCoinStatisticFromApi() throws JsonParseException, JsonMappingException, JSONException, IOException;

}
