package com.Interface.InterfaceTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;





@SuppressWarnings("deprecation")
public class HttpclientRequest {
public static Map<String,String> cookie=null;
	/**
	 * 发送get请求
	 * @param args
	 * @throws Exception 
	 * @throws ParseException 
	 * @throws Exception 
	 * @throws ClientProtocolException 
	 */
	public static File f=null;
	public static void send_get(String url) throws ParseException, Exception{ 
		CloseableHttpClient ch=HttpClientBuilder.create().build();//
		HttpGet get=new HttpGet(url);
		get.setHeader("accept", "*/*");
		CloseableHttpResponse response=null;
		try {
			response=ch.execute(get);
			int statecode=response.getStatusLine().getStatusCode();
			System.out.println("请求状态码"+statecode);
		}  catch (Exception e) {
			e.printStackTrace();
		}
		HttpEntity entity=response.getEntity();
		InputStream is=entity.getContent();
		File imgcode=new File("123.png");
		FileUtils.copyToFile(is, imgcode);
//		f=imgcode;
//		System.out.println(response.getFirstHeader("set-cookie"));
//		String result=null;
//		GetMethod getMethod = new GetMethod(url);
		Header[] headers = response.getAllHeaders();
		for(int i=0;i<headers.length;i++) {
		    System.out.println(headers[i].getName() +"=="+ headers[i].getValue());
		   }
		f=imgcode;
//		if(entity!=null){
//			result=EntityUtils.toString(entity, "utf-8");
//			EntityUtils.consume(entity);
//			response.close();
//			System.out.println(result);
//		}
//		Ocr.setUp();
//		Ocr ocr = new Ocr();
//		 String s = ocr.recognize(new File[] {f},Ocr.RECOGNIZE_TYPE_TEXT, Ocr.OUTPUT_FORMAT_PLAINTEXT);
//		 System.out.println(s);
//		 ocr.stopEngine();
		
	}
	/**
	 * 发送post请求-通用请求
	 * @param url
	 * @param params
	 */
	public static JSONObject send_post(String url,JSONObject json,String user){
		CloseableHttpClient ch=HttpClientBuilder.create().build();
		HttpPost post=new HttpPost(url);
		JSONObject response=null;
		CloseableHttpResponse res=null;
		try {
			StringEntity s=new StringEntity(json.toString());
//			s.setContentEncoding("UTF-8");
			s.setContentType("application/json");
			post.setEntity(s);
			post.setHeader("Connection","keep-alive");
			post.setHeader("user-agent", "Chrome");
			res=ch.execute(post);
			System.out.println(res.getStatusLine().getStatusCode());
			if(res.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
				String result=EntityUtils.toString(res.getEntity());
				response = JSONObject.fromObject(result);
//				System.out.println("第一条cookies是" + res.getFirstHeader("set-cookie"));
//				System.out.println("最后一条cookies是" + res.getLastHeader("set-cookie"));
				System.out.println(user+":"+response.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				res.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return response;
		}
	
	/**
	 * post请求发送上传图片
	 * @param args
	 * @throws Exception
	 */
	public static String uploadimg(){
		String url="http://v1-http-api.jsdama.com/api.php?mod=php&act=upload"; 
		CloseableHttpClient ch=HttpClientBuilder.create().build();
		JSONObject response=null;
		String var="";
		CloseableHttpResponse res=null;
			try {
				if (f == null || !f.exists()) {
				    throw new FileNotFoundException();
				}
				FileBody imag = new FileBody(f);
				StringBody name1 = new StringBody("cwh688577",ContentType.TEXT_PLAIN);
				StringBody name2 = new StringBody("zhi@zun#3d",ContentType.TEXT_PLAIN);
				StringBody name3 = new StringBody("4",ContentType.TEXT_PLAIN);
				StringBody name4 = new StringBody("4",ContentType.TEXT_PLAIN);
				StringBody name5 = new StringBody("0",ContentType.TEXT_PLAIN);
				StringBody name6 = new StringBody("123",ContentType.TEXT_PLAIN);
				MultipartEntity reqEntity = new MultipartEntity();
				reqEntity.addPart("upload", imag);
				reqEntity.addPart("user_name",name1);
				reqEntity.addPart("user_pw",name2);
				reqEntity.addPart("yzm_minlen",name3);
				reqEntity.addPart("yzm_maxlen",name4);
				reqEntity.addPart("yzmtype_mark",name5);
				reqEntity.addPart("zztool_token",name6);
				HttpPost post=new HttpPost(url);
				post.setHeader("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;)");
				//这里一定不能添加 content-Type:multipart/form-data 属性 因为这里面有个boundary参数属性是不可控的。这个值是由浏览器生成的。如果强行指明和可能  
				//导致边界值不一致 就会请求失败
//				post.setEntity(s);
				post.setEntity(reqEntity);
				res=ch.execute(post);
				System.out.println(res.getStatusLine().getStatusCode());
				if(res.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
					String result=EntityUtils.toString(res.getEntity());
					response = JSONObject.fromObject(result);
					String s=response.getJSONObject("data").getString("val");
					System.out.println(response.toString());
					if(s!=null){
						var=s;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					res.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println(var);
			return var;
	}
	
	
	
	
	public static void main(String[] args) throws Exception {
		send_get("http://demo2016.thetiger.com.cn/zikeserver/wap/captchas?t=ff2d7fd0dfeb11e79d2281cbc2573690");
		String param1="{\"mobile\":\"13700000002\",\"sms\":\"\",\"verifyCode\":\"\",\"login_type\":2,\"from\":2}";
        String param2="{\"user_name\":\"cwh688577\",\"user_pw\":\"zhi@zun#3d\"}";
        String param3="{\"user_name\":\"cwh688577\",\"user_pw\":\"zhi@zun#3d\",\"yzm_minlen\":\"4\",\"yzm_maxlen\":\"4\",\"yzmtype_mark\":\"0\",\"zztool_token\":\"123\"}";
		JSONObject ob=JSONObject.fromObject(param1);
//		ob.put("verifyCode", "09i9");
		JSONObject ob1=JSONObject.fromObject(param2);
		JSONObject ob2=JSONObject.fromObject(param3);
//		System.out.println(ob.toString());
//		String s=send_post("http://demo2016.thetiger.com.cn//zikeserver/wap/sms",ob).getJSONObject("data").getString("imgcode_url");
//		System.out.println(s);
//		send_get(s);
//		ob.put("verifyCode", "09i9");
		send_post("http://demo2016.thetiger.com.cn//zikeserver/wap/sms",ob,"");
//		uploadimg();
//		send_post("http://v1-http-api.jsdama.com/api.php?mod=php&act=point",param2);//查询剩余的请求次数
//		send_post("http://demo2016.thetiger.com.cn/zikeserver/wap/login",ob);
	}

}
