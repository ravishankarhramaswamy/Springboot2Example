package com.springbootstarterch0202externalizeproperties.demo.bean.service;

public interface Operation {

	boolean handles(char op);

	int apply(int lhs, int rhs);

}
