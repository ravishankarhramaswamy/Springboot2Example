package com.springbootstarterch0201beanapplicationrunner.demo.bean.service.impl;

import org.springframework.stereotype.Component;

import com.springbootstarterch0201beanapplicationrunner.demo.bean.service.Operation;

@Component
public class Addition implements Operation {

	@Override
	public boolean handles(char op) {
		return '+' == op;
	}

	@Override
	public int apply(int lhs, int rhs) {
		return lhs+rhs;
	}

	
}
