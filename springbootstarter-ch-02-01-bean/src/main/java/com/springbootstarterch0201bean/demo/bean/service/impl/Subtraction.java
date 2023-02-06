package com.springbootstarterch0201bean.demo.bean.service.impl;

import com.springbootstarterch0201bean.demo.bean.service.Operation;

public class Subtraction implements Operation {

	@Override
	public boolean handles(char op) {
		return '-' == op;
	}

	@Override
	public int apply(int lhs, int rhs) {
		return lhs-rhs;
	}

	
}
