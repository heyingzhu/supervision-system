package xmu.sspo.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

import xmu.sspo.model.Topic;

@Component
public class Cluster {
	//对近30天的新闻进行聚类，一天一次，每天6点进行
	@Scheduled(cron="0 0 6 * * ?")
	public void month_Cluster() {
		System.out.println("month_cluster");
		String[] args1 = new String[] { "python", "D:\\莹\\大创\\舆情监督\\中文分词\\new_kmeans.py", String.valueOf(30)}; 

        try {
//            proc = Runtime.getRuntime().exec("python " + python_root_path + "new_kmeans.py");//运行python程序
        	Process proc=Runtime.getRuntime().exec(args1);
          //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 

	}
	
	//对近7天的新闻进行聚类，一天一次，每天6点进行
	@Scheduled(cron="0 0 6 * * ?")
	public void week_Cluster() {
		System.out.println("week_cluster");
		String[] args1 = new String[] { "python", "D:\\莹\\大创\\舆情监督\\中文分词\\new_kmeans.py", String.valueOf(7)}; 

        try {
//            proc = Runtime.getRuntime().exec("python " + python_root_path + "new_kmeans.py");//运行python程序
        	Process proc=Runtime.getRuntime().exec(args1);
          //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 

	}
	
	//对近3天的新闻进行聚类，一天一次，每天6点进行
	@Scheduled(cron="0 0 6 * * ?")
	public void threedays_Cluster() {
		System.out.println("threedays_cluster");
		String[] args1 = new String[] { "python", "D:\\莹\\大创\\舆情监督\\中文分词\\new_kmeans.py", String.valueOf(3)}; 

        try {
//            proc = Runtime.getRuntime().exec("python " + python_root_path + "new_kmeans.py");//运行python程序
        	Process proc=Runtime.getRuntime().exec(args1);
          //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 

	}
	
	//对当天的新闻进行聚类，2分钟一次
	@Scheduled(cron="0/120 * * * * ?")
	public void today_Cluster() {
		System.out.println("today_cluster");
		String[] args1 = new String[] { "python", "D:\\莹\\大创\\舆情监督\\中文分词\\new_kmeans.py", String.valueOf(1)}; 

        try {
//            proc = Runtime.getRuntime().exec("python " + python_root_path + "new_kmeans.py");//运行python程序
        	Process proc=Runtime.getRuntime().exec(args1);
          //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 

	}
	
	
	//测试
//	@Scheduled(cron="0/5 * * * * ?")
//	public void test_task() {
//		System.out.println("test!");
//		String path = this.getClass().getClassLoader().getResource(".").getPath();
//		System.out.println(path);
//		Process proc;
//		String[] args1 = new String[] { "python", "test_1.py", String.valueOf(1)}; 
//		
//		        try {
//		            proc = Runtime.getRuntime().exec("python " + path + "test_1.py");//运行python程序
////		        	 proc=Runtime.getRuntime().exec(args1);
//		          //用输入输出流来截取结果
//		            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
//		            String line = null;
//		            while ((line = in.readLine()) != null) {
//		                System.out.println(line);
//		            }
//		            in.close();
//		            proc.waitFor();
//		        } catch (IOException e) {
//		            e.printStackTrace();
//		        } catch (InterruptedException e) {
//		            e.printStackTrace();
//		        } 
//	}
	
	
}
