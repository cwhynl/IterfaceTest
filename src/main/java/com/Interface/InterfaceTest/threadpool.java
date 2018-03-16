package com.Interface.InterfaceTest;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import net.sf.json.JSONObject;


public class threadpool {
	
	static int count=0;
	int thread_num=0;
	int client_num=1000;
	float avg_time=0;
	float sum_time=0;
	long first_done_time=Long.MAX_VALUE;
	long  last_done_time=Long.MIN_VALUE;
	float total_time=0;
	String url="";
	JSONObject postData=null;
	String phonenum="";
	int code=0;
	//构造方法，传递一些参数
	public threadpool(int thread_num,int client_num,String url,JSONObject  postData,String phonenum,int code){
		this.thread_num=thread_num;
		this.client_num=client_num;
		this.url=url;
		this.postData=postData;
		this.phonenum=phonenum;
		this.code=code;
	}
	//
	public void run(){
		final threadpool tp=this;
		final Map<Integer,ThreadRecord> times=new HashMap<Integer,ThreadRecord>();
		ExecutorService exec=Executors.newFixedThreadPool(thread_num);//线程池
		final CountDownLatch cDL=new CountDownLatch(client_num);
		for(int i=0;i<=client_num;i++){
			//通过runnable创建线程
			Runnable runs=new Runnable(){         
				@Override
				public void run() {
					int index=getIndex();
                    long st=Long.parseLong(Time());
					HttpclientRequest.send_post(url, postData,phonenum, code);
					times.put(index,new ThreadRecord(st,Long.parseLong(Time())));
					cDL.countDown();
				}};
			exec.execute(runs);
		}
		try {
			cDL.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i:times.keySet()){
			ThreadRecord tr=times.get(i);
			sum_time+= (tr.et-tr.st);
			if(tr.st<first_done_time){
				first_done_time=tr.st;
			}
			if(tr.et>last_done_time){
				last_done_time=tr.et;
			}
		}
		System.out.println("first:"+first_done_time);
		System.out.println("last:"+last_done_time);
		this.avg_time=this.sum_time/times.size();
		this.total_time=this.last_done_time-this.first_done_time;
		NumberFormat nf=NumberFormat.getNumberInstance();  
        nf.setMaximumFractionDigits(4);  
        System.out.println("======================================================");  
        System.out.println("Thread Num: " + thread_num + ", Client Count: "+ client_num +".");  
        System.out.println("Avg Exec Time:   " + nf.format(this.avg_time) + " s");  
        System.out.println("Total Exec Time: " + nf.format(this.total_time) + " s");  
        System.out.println("Throughput:      " + nf.format(this.client_num /this.total_time)+ " /s");
		
		
	}
	public static String Time() {
		SimpleDateFormat formattime1 = new SimpleDateFormat(
				"ssSSS");
		long ctime = System.currentTimeMillis();
		String currenttime = formattime1.format(new Date(ctime));
		return currenttime;
	}
	
	public static int getIndex(){
		return ++count;
	}
	
	public static void main(String[] args) {
		
		String url="http://stg.ziwork.com/zikeserver/wap/article/lists";
		String data="{\"page\": 1, \"page_count\": 20}";
		JSONObject ob=JSONObject.fromObject(data);
		
		new threadpool(5, 10, url,ob,"13700000000", 1).run();
		
	}

}

class ThreadRecord {  
    long st;  
    long et;  
    public ThreadRecord(long st, long et){  
        this.st = st;  
        this.et = et;  
    }  
}  

