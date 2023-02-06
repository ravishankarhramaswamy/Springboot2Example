package com.springbootstarterch0203testing.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Collection;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.test.util.ReflectionTestUtils;

import com.springbootstarterch0203testing.demo.bean.Calculator;
import com.springbootstarterch0203testing.demo.bean.service.Operation;
import com.springbootstarterch0203testing.demo.bean.service.impl.Addition;
import com.springbootstarterch0203testing.demo.bean.service.impl.Division;
import com.springbootstarterch0203testing.demo.bean.service.impl.Subtraction;

@ExtendWith(OutputCaptureExtension.class)
@SpringBootTest
class SpringbootstarterCh0203TestingSpringBootMocksApplicationTests {
	
	@MockBean(classes = Addition.class)
	private Operation mockAddOperation;
	
	@MockBean(classes = Division.class)
	private Operation mockDivisionOperation;
	
	@MockBean(classes = Subtraction.class)
	private Operation mockSubtractOperation;
	
	@Autowired
	private Calculator calculator;

	@Test
	public void calculatorShouldHave3Operations() {
		Object operations = ReflectionTestUtils.getField(calculator, "operations");
		System.out.println(operations);
		assertThat((Collection<Operation>) operations).hasSize(4);
	}
	
	@Test
	//@Disabled("Currently Disabled!")
	public void mockDivision(CapturedOutput output) {
		when(mockDivisionOperation.handles('/')).thenReturn(true);
		when(mockDivisionOperation.apply(14, 7)).thenReturn(2);
		
		calculator.calculate(14, 7, '/');
		assertThat(output.getOut()).contains("14 / 7 = 2");
	}
}
