package com.springbootstarterch0202externalizeproperties.demo.bean.service.impl;

import org.springframework.stereotype.Component;

import com.springbootstarterch0202externalizeproperties.demo.bean.service.Operation;

@Component
public class Division implements Operation {

	@Override
	public boolean handles(char op) {
		return '/' == op;
	}

	@Override
	public int apply(int lhs, int rhs) {
		if(rhs != 0) {
			return lhs/rhs;
		}
		throw new ArithmeticException("Denominator Zero Error");
	}

	
}
