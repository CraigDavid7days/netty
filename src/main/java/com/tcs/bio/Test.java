package com.tcs.bio;

import java.io.IOException;
import java.util.Scanner;

public class Test {

	
	
	public static void main(String[] args) throws InterruptedException  {
		
		//运行服务器
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Server.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.currentThread().sleep(1000);
        
		
        new Thread(new Runnable() {
            @Override
            public void run() {
            	Scanner scanner = new Scanner(System.in);	
            	try {
            		
            		while(true){
            			System.out.println("请输入要发送的消息");
            			String message = scanner.nextLine();
            			Client.send(message);
            			
            		}
				} catch (Exception e) {
					e.printStackTrace();
				} finally{
					scanner.close();
				}
            	
            }
        }).start();

        
		
		
		
		
		
		

	}

}
