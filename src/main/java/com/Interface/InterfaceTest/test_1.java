package com.Interface.InterfaceTest;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JSONObject;

public class test_1 {
	/**
	 * 获取系统时间
	 * @return
	 */
	public static String Time() {
		SimpleDateFormat formattime1 = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss:SSS");
		long ctime = System.currentTimeMillis();
		String currenttime = formattime1.format(new Date(ctime));
		return currenttime;
	}
	
	public static void severval_thread(){
		final String[] unionId1={"oEnhTwb6AfGHdV3l_TOh3p1oSpMc","oEnhTwSQkvwRRr176l5Sd6JUyt0Y","oEnhTwczPaP-H0rSXiGPg1IeOU0E","oEnhTwdP6kU8qxmoED-5_Ob76Y5g","oEnhTwRlmAwAU-gYahCbc7gPQkN0","oEnhTwa-R5DhPIeH8bWHrRHlAkPk","oEnhTwcVY8NFzPt9-Ve_J6coQ46M","oEnhTwaeB2gQdAFbQCRoBC2kkokw","oEnhTwf4IYL-ukQp-K-gkqOcdfgE",
		"oEnhTwf5YgRbIpUE_N6Wx5zeL3ss","oEnhTwQeYP-UgG7bp18er5GpoIQY","oEnhTwXAV1LS1wUGmBIVjwm4vGuk","oEnhTwakavJ8ZlqIL7G6qQNbCkS4","oEnhTwXoZmIyCa9D0FidsKeX8as8","oEnhTweZlMJzOnVxvcoOdRHgpxpQ","oEnhTwZIXEia5EF5b1MTlgHTQtKA",
		"oEnhTwe4091C9wVF-upvPdkCP-Y4","oEnhTwRNPjdXRAgLMRMUu8n7jpeY","oEnhTwSlG-9GzBjdDpfmBpVlQ8ic","oEnhTwepfyn3o_RHou6jjkaHpBcA","oEnhTwbgv9RqSJ1CetXdvER0mu0o"};
		final String[] unionId2={"oEnhTwbK8BH9hC4Y7U9s9u-DC38g","oEnhTwR7yHOqfLMtUFXyQrefhULs","oEnhTwUV9r1f1JG_1JOGWGnR1H00","oEnhTwdIBaodRrpgESRtVQLjhr4E","oEnhTwZUsLUzBHRVwsphzh624NVU","oEnhTwePjPFbSr05BDRlwCAGVQA0","oEnhTwcZqheDWBAp5C5T1F2efceg",
				"oEnhTwWZTrSr6fmihKYADZRl_8Nc","oEnhTwa1qUMg4icp05u9cQVapl3Q","oEnhTwc3j-Ak5DG270kFYTVp_iRI","oEnhTwbESukFzWAQbO9q5QMVRZKw","oEnhTwb38AwtNr3uYw1YwlUazYoQ","oEnhTwcaeReM4K42daWwkpNpTIJo","oEnhTwVblO8swfcIYXeyZK8DvyQI",
				"oEnhTwXkQD7KdnsS2TfQtxS_KTWU","oEnhTwYQn9y_zKVQgn2YGUBzU2Fw","oEnhTwdpEIfhJtHRltqBmDIt7n4I","oEnhTwSA9llKgWuCwGXbZDcgvGqE","oEnhTwVs1NBMtJZ2oG2CCfpZxaCo","oEnhTwfvxCI-tCpSW_hZTwlsQLNs"};
		final String[] unionid3={"oEnhTwb6AfGHdV3l_TOh3p1oSpMc","oEnhTwSQkvwRRr176l5Sd6JUyt0Y","oEnhTwczPaP-H0rSXiGPg1IeOU0E","oEnhTwdP6kU8qxmoED-5_Ob76Y5g","oEnhTwRlmAwAU-gYahCbc7gPQkN0","oEnhTwa-R5DhPIeH8bWHrRHlAkPk","oEnhTwcVY8NFzPt9-Ve_J6coQ46M","oEnhTwaeB2gQdAFbQCRoBC2kkokw","oEnhTwf4IYL-ukQp-K-gkqOcdfgE",
				"oEnhTwf5YgRbIpUE_N6Wx5zeL3ss","oEnhTwQeYP-UgG7bp18er5GpoIQY","oEnhTwXAV1LS1wUGmBIVjwm4vGuk","oEnhTwakavJ8ZlqIL7G6qQNbCkS4","oEnhTwXoZmIyCa9D0FidsKeX8as8","oEnhTweZlMJzOnVxvcoOdRHgpxpQ","oEnhTwZIXEia5EF5b1MTlgHTQtKA",
				"oEnhTwe4091C9wVF-upvPdkCP-Y4","oEnhTwRNPjdXRAgLMRMUu8n7jpeY","oEnhTwSlG-9GzBjdDpfmBpVlQ8ic","oEnhTwepfyn3o_RHou6jjkaHpBcA","oEnhTwbgv9RqSJ1CetXdvER0mu0o","oEnhTwbK8BH9hC4Y7U9s9u-DC38g","oEnhTwR7yHOqfLMtUFXyQrefhULs","oEnhTwUV9r1f1JG_1JOGWGnR1H00","oEnhTwdIBaodRrpgESRtVQLjhr4E","oEnhTwZUsLUzBHRVwsphzh624NVU","oEnhTwePjPFbSr05BDRlwCAGVQA0","oEnhTwcZqheDWBAp5C5T1F2efceg",
				"oEnhTwWZTrSr6fmihKYADZRl_8Nc","oEnhTwa1qUMg4icp05u9cQVapl3Q","oEnhTwc3j-Ak5DG270kFYTVp_iRI","oEnhTwbESukFzWAQbO9q5QMVRZKw","oEnhTwb38AwtNr3uYw1YwlUazYoQ","oEnhTwcaeReM4K42daWwkpNpTIJo","oEnhTwVblO8swfcIYXeyZK8DvyQI",
				"oEnhTwXkQD7KdnsS2TfQtxS_KTWU","oEnhTwYQn9y_zKVQgn2YGUBzU2Fw","oEnhTwdpEIfhJtHRltqBmDIt7n4I","oEnhTwSA9llKgWuCwGXbZDcgvGqE","oEnhTwVs1NBMtJZ2oG2CCfpZxaCo","oEnhTwfvxCI-tCpSW_hZTwlsQLNs"}; //合并1和2
		
		
		
		//e0beac091262d1c4a0ce9346c0eaa8d7 用户id1  8fba9cfcacca6b8c4180e9c60ed374b5 用户id2          社区id:6d46636c66046f8764589c538efe5fd9
		int[] user_id =new int[100] ;//100个 用户的uid数组
		for(int t=0;t<user_id.length;t++){
			user_id[t]=t+40000;
		}
		
		/**
		 * 用户1,20个用户帮忙打call
		 */
//		for(int i=0;i<20;i++){
//		   final int index = i;
//			new Thread(){
//				public void run(){
//					String param1="{\"communityId\":\"6d46636c66046f8764589c538efe5fd9\",\"uid\":\"e0beac091262d1c4a0ce9346c0eaa8d7\",\"unionid\":\"oEnhTwbMXZdemUQwITCy6CMaRBEk\"}";
//					JSONObject ob1=JSONObject.fromObject(param1);
//					ob1.put("unionid", unionId1[index]);
//					HttpclientRequest.send_post("https://light.house.api.ziwork.com/wx/call/getClickTest",ob1,"集call用户1");
//				};
//			}.start();
//		}	
//		/**
//		 * 用户2,20个用户帮忙打call
//		 */
//		for(int i=0;i<20;i++){
//		   final int index = i;
//			new Thread(){
//				public void run(){
//					String param1="{\"communityId\":\"80e4d561e5e79fa70aa290eb85f13644\",\"uid\":\"8fba9cfcacca6b8c4180e9c60ed374b5\",\"unionid\":\"oEnhTwbMXZdemUQwITCy6CMaRBEk\"}";
//					JSONObject ob1=JSONObject.fromObject(param1);
//					ob1.put("unionid", unionId2[index]);
//					HttpclientRequest.send_post("https://light.house.api.ziwork.com/wx/call/getClickTest",ob1,"集call用户2");
//				};
//			}.start();
//		}
		
		/**
		 * 2个用户帮忙打call
//		 */
//		new Thread(){
//			public void run(){
//				String param1="{\"communityId\":\"80e4d561e5e79fa70aa290eb85f13644\",\"uid\":\"e0beac091262d1c4a0ce9346c0eaa8d7\",\"unionid\":\"oEnhTwbMXZdemUQwITCy6CMaRBEk\"}";
//				JSONObject ob1=JSONObject.fromObject(param1);
//				ob1.put("unionid","oEnhTwb6AfGHdV3l_TOh3p1oSpMc");
//				HttpclientRequest.send_post("https://light.house.api.ziwork.com/wx/call/getClickTest",ob1,"集call用户1");
//			};
//		}.start();
//		new Thread(){
//			public void run(){
//				String param1="{\"communityId\":\"80e4d561e5e79fa70aa290eb85f13644\",\"uid\":\"8fba9cfcacca6b8c4180e9c60ed374b5\",\"unionid\":\"oEnhTwbMXZdemUQwITCy6CMaRBEk\"}";
//				JSONObject ob1=JSONObject.fromObject(param1);
//				ob1.put("unionid", "oEnhTwSQkvwRRr176l5Sd6JUyt0Y");
//				HttpclientRequest.send_post("https://light.house.api.ziwork.com/wx/call/getClickTest",ob1,"集call用户2");
//			};
//		}.start();
		//40个人帮忙打call
//		for(int i=0;i<40;i++){
//			   final int index = i;
//				new Thread(){
//					public void run(){
//						String param1="{\"communityId\":\"d49f13efa5189efdf2d2902968393e3c\",\"uid\":\"e0beac091262d1c4a0ce9346c0eaa8d7\",\"unionid\":\"oEnhTwbMXZdemUQwITCy6CMaRBEk\"}";
//						JSONObject ob1=JSONObject.fromObject(param1);
//						ob1.put("unionid", unionid3[index]);
//						HttpclientRequest.send_post("https://light.house.api.ziwork.com/wx/call/getClickTest",ob1,"集call用户2",2);
//					};
//				}.start();
//			}
		int s=1;
		int time=0;
		for(int i=1;i<=s;i++){
			   final int index = i;
			   final int tt = time;
				new Thread(){
					public void run(){
						String param1="{\"course_id\":\"bd8371fddcd070dcc1cfd934f1dafed1\",\"type\":1}";
						JSONObject ob1=JSONObject.fromObject(param1);
//						ob1.put("unionid", unionid3[index]);
						HttpclientRequest.send_post("http://stg.ziwork.com/zikeserver/wap/course/info",ob1,"13700000000",index);
					};
				}.start();
			}		
	
	//http://stg.ziwork.com/zikeserver/wap/voicebook/info
	for(int i=1+s;i<=s+s;i++){
		   final int index = i;
			new Thread(){
				public void run(){
					String param1="{\"voicebook_id\":\"51dd46e572ee7475da9a3af67b643bf4\", \"type\": 1}";
					JSONObject ob1=JSONObject.fromObject(param1);
//					ob1.put("unionid", unionid3[index]);
					HttpclientRequest.send_post("http://stg.ziwork.com/zikeserver/wap/voicebook/info",ob1,"13700000000",index);
				};
			}.start();
		}	
	System.out.println("平均响应时长为："+HttpclientRequest.d/(s*2));
}

	public static void main(String[] args) {
		severval_thread();
	}

}
