package com.springbootstarterch0203testing.demo.bean;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.stereotype.Component;

import com.springbootstarterch0203testing.demo.bean.service.Operation;

@Component
public class CalculatorTest {
	
	private Calculator calculator;
	private Operation mockOperation;

	@BeforeEach
	public void setUp() {
		mockOperation = Mockito.mock(Operation.class);
		calculator = new Calculator(Collections.singletonList(mockOperation));
	}
	
	@Test
	public void throwExceptionWhenNoSuitableOperationFound() {
		when(mockOperation.handles(anyChar())).thenReturn(false);
		assertThrows(IllegalArgumentException.class, () -> {
			calculator.calculate(2, 2, '*');
		});
	}
	
	@Test
	public void shouldCallApplyMethodWhenSuitableOperationFound() {
		when(mockOperation.handles(anyChar())).thenReturn(true);
		when(mockOperation.apply(2, 2)).thenReturn(4);
		calculator.calculate(2, 2, '*');
		verify(mockOperation, times(1)).apply(2, 2);
	}
}
