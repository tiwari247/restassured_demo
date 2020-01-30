package com.cpt.testcases;

import java.net.http.HttpRequest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cpt.base.BaseClass;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import junit.framework.Assert;

public class TC001_Getting_All_Posts extends BaseClass {
	
	@BeforeClass
	void getAllPosts()throws InterruptedException {
		System.out.println("Logger : "+logger);
		logger.debug("getAllPosts() Started");
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
		httpRequest = RestAssured.given();
		
		response = httpRequest.request(Method.GET, "/");
		
		logger.info("Request : https://jsonplaceholder.typicode.com/posts");
		logger.info("Response : "+response.body().asString());
		
		logger.debug("getAllPosts() Ended");
		
//		Thread.sleep(5000);
	}
	
	@Test
	void checkResponseCode() {
		logger.info("Response Code : "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
