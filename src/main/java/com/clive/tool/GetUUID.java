package com.clive.tool;

import java.util.Random;
import java.util.UUID;

/**
 * 用于自动生成id
 */
public class GetUUID {
	public static String getUUID(){
		String uuid="";
	uuid=	UUID.randomUUID().toString().replaceAll("-","");
		return uuid;
	}
	
	
	public static int yanzma(){
		int x;
		Random xs= new Random();
		x = xs.nextInt(9999-1000+1)+100000;
		return x;
		
	}
	

}
