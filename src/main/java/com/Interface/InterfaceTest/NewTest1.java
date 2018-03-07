package com.Interface.InterfaceTest;

import net.sf.json.JSONObject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTest1 extends test_1{
	@BeforeClass
	  public void suite5(){
			System.out.println("这是BeforeClass2");
		}
	  @AfterClass
	  public void suite7(){
			System.out.println("这是AfterClass2");
		}
	  @Test
	  public void case1() {
		 
		  String url="http://stg.ziwork.com/zikeserver/wap/article/lists";
		  String param1="{\"page\": 1, \"page_count\": 20}";
			JSONObject ob1=JSONObject.fromObject(param1);
		  HttpclientRequest.send_post(url,ob1,"13700000000",1);
		  Long id = Thread.currentThread().getId();
	        System.out.println("Test method executing on thread with id: " + id);
	  }
}

