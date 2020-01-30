package com.cpt.base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	public RequestSpecification httpRequest;
	public Response response;
	public static Logger logger = Logger.getLogger(BaseClass.class);
	 
	@BeforeClass
	void setup() {
		
		PropertyConfigurator.configure("log4j.properties");
//		logger.setLevel(Level.DEBUG);
//		System.out.println("Logger : "+logger);
//		logger.info("Inside setup()");
	}
	
}
