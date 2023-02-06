package com.springbootstarterch0203testing.demo.bean.service;

public interface Operation {

	boolean handles(char op);

	int apply(int lhs, int rhs);

}
