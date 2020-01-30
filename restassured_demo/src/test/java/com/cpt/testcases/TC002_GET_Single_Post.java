package com.cpt.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cpt.base.BaseClass;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import junit.framework.Assert;

public class TC002_GET_Single_Post extends BaseClass {
	String id = "14";
	
	@BeforeClass
	void getSinglePost() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
		httpRequest = RestAssured.given();
		
		response = httpRequest.request(Method.GET, "/14");
	}
	
	@Test
	void checkResponseCode() {
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test
	void idIsSame() {
		Assert.assertEquals(response.body().asString().contains(id), true);
	}
	
	@Test
	void checkResponseTime() {
		System.out.println("Response Time : "+response.getTime());
		Assert.assertEquals(response.getTime()<5000, true);
	}
	
}
