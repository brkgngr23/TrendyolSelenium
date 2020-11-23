package com.trendyol.base;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.lang.reflect.Method;

public class ServicesAbstractTest extends AbstractTest {
	@AfterMethod
	public void getResult(ITestResult result, Method method) {
		super.getResult(result,method);
	}
}