package com.monitor.stats.bitcoinmonitor.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoinStatistics {
	
	public CoinStatistics(BigDecimal o, BigDecimal h, BigDecimal l, BigDecimal c, Long v, String t, Long bv) {
		super();
		this.o = o;
		this.h = h;
		this.l = l;
		this.c = c;
		this.v = v;
		this.t = t;
		this.bv = bv;
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition="decimal(19,8)")
	private BigDecimal o;
	@Column(columnDefinition="decimal(19,8)")
	private BigDecimal h;
	@Column(columnDefinition="decimal(19,8)")
	private BigDecimal l;
	@Column(columnDefinition="decimal(19,8)")
	private BigDecimal c;
	private Long v;
	private String t;
	private Long bv;
}
