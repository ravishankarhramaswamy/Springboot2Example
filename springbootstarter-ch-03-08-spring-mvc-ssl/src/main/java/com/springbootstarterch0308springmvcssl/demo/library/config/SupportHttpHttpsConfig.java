package com.springbootstarterch0308springmvcssl.demo.library.config;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Disabled to consider redirection of http to https
//@Configuration
public class SupportHttpHttpsConfig {

	// Support both http and https
	@Bean
	public TomcatServletWebServerFactory tomcatServletWebServerFactory() {
		var factory = new TomcatServletWebServerFactory();
		factory.addAdditionalTomcatConnectors(httpConnector());
		return factory;
	}

	private Connector httpConnector() {
		var connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
		connector.setScheme("http");
		connector.setPort(8080);
		connector.setSecure(false);
		return connector;
	}

	// Alternative approach to support http and https
//		@Bean
//		public BeanPostProcessor addHttpConnectorProcessor() {
//			return new BeanPostProcessor() {
//				@Override
//				public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//					if (bean instanceof TomcatServletWebServerFactory) {
//						var factory = (TomcatServletWebServerFactory) bean;
//						factory.addAdditionalTomcatConnectors(httpConnector());
//					}
//					return bean;
//				}
//			};
//		}
}
