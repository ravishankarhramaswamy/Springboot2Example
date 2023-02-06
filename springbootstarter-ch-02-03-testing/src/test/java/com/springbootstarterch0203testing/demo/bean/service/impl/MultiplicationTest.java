package com.springbootstarterch0203testing.demo.bean.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MultiplicationTest {

	private final Multiplication multiplication = new Multiplication();
	
	@Test
	public void shouldMatchOperation() {
		assertThat(multiplication.handles('*')).isTrue();
		assertThat(multiplication.handles('/')).isFalse();
	}
	
	@Test
	public void shouldCorrectlyApplyFormula() {
		assertThat(multiplication.apply(2, 2)).isEqualTo(4);
		assertThat(multiplication.apply(12, 10)).isEqualTo(120);
	}
}
