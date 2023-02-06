package com.springbootstarterch0308springmvcssl.demo.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class LocaleConfig implements WebMvcConfigurer {

	/*
	 * @Bean public LocaleResolver localeResolver1() { return new
	 * AcceptHeaderLocaleResolver(); }
	 * 
	 * @Bean public LocaleResolver localeResolver2() { SessionLocaleResolver
	 * localeResolver = new SessionLocaleResolver();
	 * localeResolver.setDefaultLocale(new Locale("en")); return localeResolver; }
	 * 
	 * @Bean public LocaleResolver localeResolver3() { return new
	 * CookieLocaleResolver(); }
	 * 
	 * @Bean public LocaleResolver localeResolver4() { CookieLocaleResolver
	 * cookieLocaleResolver = new CookieLocaleResolver();
	 * cookieLocaleResolver.setCookieName("language");
	 * cookieLocaleResolver.setCookieMaxAge(3600);
	 * cookieLocaleResolver.setDefaultLocale(new Locale("en")); return
	 * cookieLocaleResolver; }
	 * 
	 * @Bean public LocaleResolver localeResolver() { FixedLocaleResolver
	 * cookieLocaleResolver = new FixedLocaleResolver();
	 * cookieLocaleResolver.setDefaultLocale(new Locale("en")); return
	 * cookieLocaleResolver; }
	 */

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		return new LocaleChangeInterceptor();
	}

	@Bean
	public LocaleResolver localeResolver() {
		return new CookieLocaleResolver();
	}
}
