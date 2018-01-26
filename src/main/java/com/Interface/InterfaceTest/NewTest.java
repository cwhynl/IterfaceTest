package com.Interface.InterfaceTest;

import net.sf.json.JSONObject;

import org.apache.http.ParseException;
import org.testng.annotations.Test;

public class NewTest extends HttpclientRequest{
	public static String imgcode_url="";
	public static String code="";
	/**
	 * 请求短信验证码获得图片验证码
	 * @throws Exception 
	 * @throws ParseException 
	 */
//  @Test
//  public void case1() throws Exception {
//	  String param1="{\"mobile\":\"13700000000\",\"sms\":\"\",\"verifyCode\":\"tttt\",\"login_type\":2,\"from\":2}";
//	  System.out.println("---"+JSONObject.fromObject(param1));
//	  JSONObject ob=send_post("http://demo2016.thetiger.com.cn//zikeserver/wap/sms",JSONObject.fromObject(param1),"");
//	  imgcode_url=ob.getJSONObject("data").getString("imgcode_url");
//	  send_get(imgcode_url);
//	  code=uploadimg();
//  }
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
  
  
  
}
