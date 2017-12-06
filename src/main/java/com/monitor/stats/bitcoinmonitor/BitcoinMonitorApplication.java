package com.monitor.stats.bitcoinmonitor;

import java.io.IOException;

import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.monitor.stats.bitcoinmonitor.webscrape.CoinStatisticsGetter;

@SpringBootApplication
public class BitcoinMonitorApplication {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, JSONException, IOException {
		ApplicationContext applicationContext = SpringApplication.run(BitcoinMonitorApplication.class, args);
		//CoinStatisticsGetter coinStatisticsGetter = applicationContext.getBean(CoinStatisticsGetter.class);
		//coinStatisticsGetter.getCoinStatisticFromApi();
	}
	
	
}
