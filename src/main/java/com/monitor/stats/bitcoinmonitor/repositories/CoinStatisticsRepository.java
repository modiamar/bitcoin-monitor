package com.monitor.stats.bitcoinmonitor.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.monitor.stats.bitcoinmonitor.domain.CoinStatistics;

@Repository
public interface CoinStatisticsRepository extends CrudRepository<CoinStatistics, Long>{

}
