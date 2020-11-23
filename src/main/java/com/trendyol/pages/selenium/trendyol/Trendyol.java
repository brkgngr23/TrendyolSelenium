package com.trendyol.pages.selenium.trendyol;

import com.trendyol.base.SeleniumAbstractTest;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class Trendyol extends SeleniumAbstractTest {
	String chrome="chrome";
	String firefox="firefox";
	protected ThreadLocal <PageTrendyolLogin> lgn =new ThreadLocal<PageTrendyolLogin>();

	@BeforeMethod
	public void Before (Method method) {
	DOMConfigurator.configureAndWatch("log.xml");	
	WebDriver  driver;
	driver =super.setUpBrowser(chrome);
	lgn.set(new PageTrendyolLogin(driver));
	
}
	
	protected PageTrendyolLogin startTest() {
		
		return lgn.get();
	}
}