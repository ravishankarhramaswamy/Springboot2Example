package com.springbootstarterch0307springmvcselectchangeembeddedserver.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.springbootstarterch0307springmvcselectchangeembeddedserver.demo.library.Book;
import com.springbootstarterch0307springmvcselectchangeembeddedserver.demo.library.CustomizedErrorAttributes;
import com.springbootstarterch0307springmvcselectchangeembeddedserver.demo.library.service.BookService;

@SpringBootApplication
public class SpringbootstarterCh0307SpringMvcSelectChangeEmbeddedServerApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootstarterCh0307SpringMvcSelectChangeEmbeddedServerApplication.class, args);
	}

	@Bean
	public ApplicationRunner booksInitializer(BookService bookService) {
		return args -> {
			bookService.create(new Book("9780061120084", "To Kill a Mockingbird", "Harper Lee"));
			bookService.create(new Book("9780451524935", "1984", "George Orwell"));
			bookService.create(new Book("9780618260300", "The Hobbit", "J.R.R. Tolkien"));
		};
	}

	@Bean
	public CustomizedErrorAttributes errorAttributes() {
		return new CustomizedErrorAttributes();
	}

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
