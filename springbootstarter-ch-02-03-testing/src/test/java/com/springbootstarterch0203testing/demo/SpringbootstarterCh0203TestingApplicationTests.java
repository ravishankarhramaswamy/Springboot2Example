package com.springbootstarterch0203testing.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import com.springbootstarterch0203testing.demo.bean.Calculator;

@ExtendWith(OutputCaptureExtension.class)
@SpringBootTest(classes = SpringbootstarterCh0203TestingApplication.class)
class SpringbootstarterCh0203TestingApplicationTests {
	
	@Autowired
	private Calculator calculator;

	@Test
	public void doingDivisionShouldFail() {
		assertThrows(ArithmeticException.class, () -> {
			calculator.calculate(12, 0, '/');
		});
	}
	
	@Test
	public void doingMultiplicationShouldSucceed(CapturedOutput output) {
		calculator.calculate(12, 13, '*');
		assertThat(output.getOut()).contains("12 * 13 = 156");
	}

}
