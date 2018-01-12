package com.Interface.InterfaceTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

public class UrlRequest {
	
	/**
	 * get请求(JDK自带的URLconnection)
	 * @param args
	 * @throws Exception 
	 */
	public static void send_get(String url,String param) throws Exception{
		String Url=null;
		if(param==""){
			Url=url;
		}else {
			Url=url+"?"+param;
		}
		HttpURLConnection con=null;
		URL realurl=new URL(Url);
		con=(HttpURLConnection) realurl.openConnection();
		con.setRequestProperty("accept", "*/*");
		con.connect();
		Map<String,List<String>> map=con.getHeaderFields();
		for(String s:map.keySet()){
			System.out.println(s+":"+map.get(s));
		}
		BufferedReader in=new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
		String line=null;
		while((line=in.readLine())!=null){
			System.out.println(line+"\n");
		}
	}
	/**
	 * 发送post请求（JDK自带的URLconnection）
	 * @param args
	 */
	public  static void send_post() throws Exception{
		String url="http://demo2016.thetiger.com.cn//zikeserver/wap/sms";
		String param="{\"mobile\":\"13700000000\",\"sms\":\"1111\",\"verifyCode\":\"ye4h\",\"login_type\":2,\"from\":2}";
		//建立连接
		HttpURLConnection conn=null;
		URL realurl=new URL(url);
		conn=(HttpURLConnection) realurl.openConnection();
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("connection", "KeepAlive");
		conn.setRequestProperty("Accept", "GBK");
		conn.connect();
		OutputStreamWriter ow=new OutputStreamWriter(conn.getOutputStream(),"GBK");
		ow.append(param);
		ow.flush();
		
		//获取响应内容
		BufferedReader in=new BufferedReader(new InputStreamReader(conn.getInputStream(),"GBK"));
		String r=in.readLine();
		JSONObject ob=JSONObject.fromObject(r);
		System.out.println(ob.toString());
		String line=null;
		while((line=in.readLine())!=null){
			System.out.println(line.toString()+"\n");
		}
	}
	
    public static void main( String[] args ) throws Exception {	
 			send_get("http://demo2016.thetiger.com.cn/zikeserver/wap/captchas?t=1512727455","");
//    		 send_get("https://www.baidu.com",""); 
    		 send_post();
    }
}
