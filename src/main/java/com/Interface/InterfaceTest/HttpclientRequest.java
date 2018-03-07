package com.Interface.InterfaceTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;

@SuppressWarnings("deprecation")
public class HttpclientRequest {
	
	
	public static String Time() {
		SimpleDateFormat formattime1 = new SimpleDateFormat(
				"ssSSS");
		long ctime = System.currentTimeMillis();
		String currenttime = formattime1.format(new Date(ctime));
		return currenttime;
	}
public static Map<String,CookieStore> cookies=new HashMap<String, CookieStore>();
public static int d=0;
   public static void listcookie(String phonenum){
	   CookieStore cookieStore=null;
	   for(String str:cookies.keySet()){
			if(str==phonenum){
				cookieStore=cookies.get(phonenum);
			}
		}
	   if( cookieStore!=null){
	
	   System.out.println("当前的cookies是："+cookieStore.toString());
	   }	   
}
	/**
	 * 发送get请求返回文件流
	 * @param args
	 * @throws Exception 
	 * @throws ParseException 
	 * @throws Exception 
	 * @throws ClientProtocolException 
	 */
	public static File send_get_file(String url,String phonenum) throws Exception{ 
		CloseableHttpClient ch=null;
		HttpGet get=new HttpGet(url);
		get.setHeader("accept", "*/*");
		CloseableHttpResponse response=null;
		CookieStore cookieStore=null;
		for(String str:cookies.keySet()){
			if(str==phonenum){
				cookieStore=cookies.get(phonenum);	
			}
		}
		try {
			if(cookieStore!=null){
			ch=HttpClients.custom()
			        .setDefaultCookieStore(cookieStore).build();}else{
			        	ch=HttpClientBuilder.create().build();
			        }
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
//		for(int t=0;t<response.getAllHeaders().length;t++){
//			System.out.println(response.getAllHeaders()[t].toString());
//		}
//		System.out.println(response.getFirstHeader("set-cookie"));
//		String result=null;
//		GetMethod getMethod = new GetMethod(url);

//		if(entity!=null){
//			result=EntityUtils.toString(entity, "utf-8");
//			EntityUtils.consume(entity);
//			response.close();
//			System.out.println(result);
//		}
		return imgcode;
	}
	/**
	 * 通用的get请求
	 * @throws IOException 
	 * @throws UnsupportedOperationException 
	 */
	public static void pub_get(String url,Integer inter) throws UnsupportedOperationException, IOException{
		CloseableHttpClient ch=null;
		HttpGet get=new HttpGet(url);
		get.setHeader("accept", "*/*");
		CloseableHttpResponse response=null;

			ch=HttpClientBuilder.create().build();
			long from = Long.parseLong(Time()); 
			response=ch.execute(get);
			int statecode=response.getStatusLine().getStatusCode();
			System.out.println("请求状态码"+statecode);
		
		HttpEntity entity=response.getEntity();
		InputStream is=entity.getContent();
		long to=0;
		if(response.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
			to =Long.parseLong(Time());
			int sec = (int) ((to - from));
			d=sec;
			System.out.println("用户"+inter+"请求状态码是"+response.getStatusLine().getStatusCode()+";"+"请求时间是："+sec);
		}
	}
	/**
	 * 设置cookie的方法
	 */
	public static void setCookieStore(CloseableHttpResponse httpResponse,String phonenum){
		CookieStore cookieStore = new BasicCookieStore();
		BasicClientCookie cookie =null;
		for(int t=0;t<httpResponse.getAllHeaders().length;t++){
			Header s=httpResponse.getAllHeaders()[t];
			if(s.toString().contains("Set-Cookie")){
				String setCookie=s.getValue().toString();
				if(setCookie.contains("PHPSESSID")){
					String PHPSESSID = setCookie.substring("PHPSESSID=".length(),
					        setCookie.indexOf(";"));
				cookie=	new BasicClientCookie("PHPSESSID",PHPSESSID);
				cookie.setDomain("demo2016.thetiger.com.cn");
				cookieStore.addCookie(cookie);
				}
//				if(setCookie.contains("laravel_session")){
//					String laravel_session = setCookie.substring("laravel_session=".length(),
//					        setCookie.indexOf(";"));
//				cookie=	new BasicClientCookie("laravel_session",laravel_session);
//				cookie.setDomain("demo2016.thetiger.com.cn");
//				cookieStore.addCookie(cookie);
//				}if(setCookie.contains("zike_token")){
//					String zike_token = setCookie.substring("zike_token=".length(),
//					        setCookie.indexOf(";"));
//				cookie=	new BasicClientCookie("zike_token",zike_token);
//				cookie.setDomain("demo2016.thetiger.com.cn");
//				cookieStore.addCookie(cookie);
//				}

				cookies.put(phonenum,cookieStore);
			}	
//			System.out.println("cookie是" +httpResponse.getAllHeaders()[t]);
		}
	}
	/**
	 * 发送post请求-通用请求
	 * @param url请求地址
	 * @param json 请求参数
	 * @param phonenum 请求手机号码
	 * @param inter    是否带cookie，0的时候带上cookie
	 * @return
	 */
	public static JSONObject send_post(String url,JSONObject json,String phonenum,Integer inter){
		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		CloseableHttpClient ch=null;
		HttpPost post=new HttpPost(url);
		JSONObject response=null;
		CloseableHttpResponse res=null;
		CookieStore cookieStore=null;;
		for(String str:cookies.keySet()){
			if(str==phonenum){
				cookieStore=cookies.get(phonenum);	
		}}
		try {
			if(cookieStore!=null){
            ch = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
            }else{
            	ch=HttpClientBuilder.create().build();
            }
			
			StringEntity s=new StringEntity(json.toString());
//			s.setContentEncoding("UTF-8");
			s.setContentType("application/json");
			post.setEntity(s);
			post.setHeader("Connection","keep-alive");
			post.setHeader("user-agent", "Chrome");
			long from = Long.parseLong(Time()); 
			res=ch.execute(post);
//			listcookie(phonenum);
			long to=0;
			System.out.println("用户"+inter+"请求状态码是"+res.getStatusLine().getStatusCode());
			if(res.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
				to =Long.parseLong(Time());   
				String result=EntityUtils.toString(res.getEntity());
				response = JSONObject.fromObject(result);	
//				System.out.println(response.toString());
			if(inter==0){
						 setCookieStore(res,phonenum);
			}
			}else{
				System.out.println("请求不正确："+res.getStatusLine().getStatusCode());
			}
			int sec = (int) ((to - from));
			d=sec;
			System.out.println("用户"+inter+"请求状态码是"+res.getStatusLine().getStatusCode()+";"+"请求时间是："+sec);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				res.close();
			} catch (Exception e) {
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
	public static String uploadimg(String fileurl,String phonenum,File f){
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
	/**
	 * 实现登录
	 * @param args
	 * @throws Exception
	 */
	public static void login(String phonenum){
		String param1="{\"mobile\":\"13700000006\",\"sms\":\"1111\","
				+ "\"verifyCode\":\"\",\"login_type\":2,\"from\":2}";
		String sms="http://demo2016.thetiger.com.cn//zikeserver/wap/sms";
		String loginurl="http://demo2016.thetiger.com.cn/zikeserver/wap/login";
		JSONObject ob=JSONObject.fromObject(param1);
		ob.put("mobile",phonenum);
		System.out.println("请求的参数是"+ob.toString());
		String s=send_post(sms,ob,phonenum,0).getJSONObject("data").getString("imgcode_url").toString();
		System.out.println(s);
		File f=null;
		try {
			 f=send_get_file(s,phonenum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String dd=uploadimg(s,phonenum,f).toString();
//		System.out.println(dd);
		ob.put("verifyCode", dd);
		send_post(sms,ob,phonenum,1);
		ob.put("mobile",phonenum);
		ob.put("sms", "1111");
		System.out.println("请求的参数是"+ob.toString());
		send_post(loginurl,ob,phonenum,1);
	}
	
	
	
	
	
	public static void main(String[] args) throws Exception {
		String param1="{\"page\":1,\"page_count\":20}";
        String param2="{\"user_name\":\"cwh688577\",\"user_pw\":\"zhi@zun#3d\"}";
        JSONObject ob0=JSONObject.fromObject(param1);
		JSONObject ob1=JSONObject.fromObject(param2);
		send_post("http://v1-http-api.jsdama.com/api.php?mod=php&act=point",ob1,"",2);//查询剩余的请求次数
        login("13700000003");
		send_post("http://demo2016.thetiger.com.cn/zikeserver/wap/user/purchaseCourseList"
				,ob0,"13700000003",2);
	}

}
