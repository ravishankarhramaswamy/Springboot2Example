package com.springbootstarterch0201bean.demo.bean.service.impl;

import com.springbootstarterch0201bean.demo.bean.service.Operation;

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
