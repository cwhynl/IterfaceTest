package com.Interface.InterfaceTest;

import net.sf.json.JSONObject;

import org.apache.http.ParseException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest{

	
	@BeforeSuite
	public void suite1(){
		System.out.println("这是BeforeSuite");
	}
	@AfterSuite
	public void suite2(){
		System.out.println("这是AfterSuite");
	}

  @Test
  public void case1() {
	  System.out.println("这是testcase");
  }
  @BeforeTest
  public void suite3(){
		System.out.println("这是BeforeTest1");
	}
  @AfterTest
	public void suite4(){
		System.out.println("这是AfterTest1");
	}
  @BeforeClass
  public void suite5(){
		System.out.println("这是BeforeClass1");
	}
  @AfterClass
  public void suite6(){
		System.out.println("这是AfterClass1");
	}
  

	}
  
  
  
  /**
   * 根据正确的图片验证码请求短信验证码
   */
//  @Test
//  public void case2() throws Exception {
//	  String param1="{\"mobile\":\"13700000000\",\"sms\":\"\",\"verifyCode\":\"tyct\",\"login_type\":2,\"from\":2}";
//	  JSONObject ob=JSONObject.fromObject(param1);
//	  ob.put("verifyCode", code);
//	  System.out.println("---"+ob.toString());
//	  send_post("http://demo2016.thetiger.com.cn//zikeserver/wap/sms",ob,"");
//  }
//    /**
//     * 登录
//     */
//  @Test
//  public void case3(){
//	  String param="{\"mobile\":\"13700000000\",\"sms\":\"1111\",\"verifyCode\":"+code+",\"login_type\":2,\"from\":2}";
//	  send_post("http://demo2016.thetiger.com.cn/zikeserver/wap/login",JSONObject.fromObject(param),"");
//  }
  
  
  

