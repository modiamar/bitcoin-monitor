package com.monitor.stats.bitcoinmonitor.webscrape;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.monitor.stats.bitcoinmonitor.domain.CoinStatistics;
import com.monitor.stats.bitcoinmonitor.repositories.CoinStatisticsRepository;

@Component
@Primary
public class CoinStatisticsGetterImpl implements CoinStatisticsGetter {
	
	private final CoinStatisticsRepository coinStatisticsRepository;

	public CoinStatisticsGetterImpl(CoinStatisticsRepository coinStatisticsRepository) {
		super();
		this.coinStatisticsRepository = coinStatisticsRepository;
	}

	@Override
	public ArrayList<CoinStatistics> getCoinStatisticFromApi() throws JsonParseException, JsonMappingException, JSONException, IOException {

		ArrayList<CoinStatistics> coinStatisticsList = new ArrayList<CoinStatistics>();
		RestTemplate restTemplate = new RestTemplate();
		String output = restTemplate.getForObject("https://bittrex.com/Api/v2.0/pub/market/GetTicks?marketName=BTC-WAVES&tickInterval=thirtyMin&_=1499127220008", String.class);
        Iterable<CoinStatistics> coinStatisticsIter = this.parseJsonString(output.toLowerCase());
        coinStatisticsIter.iterator().forEachRemaining(eachCoinStat -> coinStatisticsList.add(eachCoinStat));
        return coinStatisticsList;
	}
	
	private Iterable<CoinStatistics> parseJsonString(String coinJsonString) throws JsonParseException, JsonMappingException, JSONException, IOException {
		JSONObject jsonStatResults = new JSONObject(coinJsonString);
		JSONArray statsArray = jsonStatResults.getJSONArray("result");
		
		for (int i = 0; i < statsArray.length(); i++) {
			statsArray.getJSONObject(i);
			ObjectMapper objectMapper = new ObjectMapper();
			CoinStatistics coinStatistics = objectMapper.readValue(statsArray.getJSONObject(i).toString(), CoinStatistics.class);
			coinStatisticsRepository.save(coinStatistics);
		}

		return coinStatisticsRepository.findAll();	
	}

}
