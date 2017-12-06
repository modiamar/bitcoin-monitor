package com.monitor.stats.bitcoinmonitor.services;

import org.springframework.stereotype.Component;

@Component
public class HiByeServiceImpl implements HiByeService {
	// Using AOP we can intercept return values and arguments
	@Override
	public void sayHi(String name) {
		System.out.println("Hi " + name);
		
	}

	@Override
	public void sayBye() {
		System.out.println("Bye");
		
	}

	@Override
	public String returnSomething() {
		return "say bye";
		
	}

}
