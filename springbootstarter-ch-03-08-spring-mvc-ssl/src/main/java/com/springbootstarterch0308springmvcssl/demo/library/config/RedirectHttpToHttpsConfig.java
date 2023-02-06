package com.springbootstarterch0308springmvcssl.demo.library.config;

import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedirectHttpToHttpsConfig {

	@Bean
	public TomcatServletWebServerFactory tomcatServletWebServerFactory() {
		var factory = new TomcatServletWebServerFactory();
		factory.addAdditionalTomcatConnectors(httpConnector());
		factory.addContextCustomizers(securityCustomizer());
		return factory;
	}

	private Connector httpConnector() {
		var connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
		connector.setScheme("http");
		connector.setPort(8080);
		connector.setSecure(false);
		connector.setRedirectPort(8443);
		return connector;
	}

	private TomcatContextCustomizer securityCustomizer() {
		return context -> {
			var securityConstraint = new SecurityConstraint();
			securityConstraint.setUserConstraint("CONFIDENTIAL");
			var collection = new SecurityCollection();
			collection.addPattern("/*");
			securityConstraint.addCollection(collection);
			context.addConstraint(securityConstraint);
		};
	}
}
