package com.pooagr.sendSms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

public class SendSms {
	public static void send(String msg, String number) 
	{
		String apiKey = " YOur Authorization key";
		String sendId = "FSTSMS";
		try {
			msg = URLEncoder.encode(msg, "UTF-8");
			String language = "english";
			String route = "p";
			String myUrl = "https://www.fast2sms.com/dev/bulk?authorization="+apiKey+"&sender_id="+sendId+"&message="+msg+"&language="+language+"&route="+route+"&numbers="+number;
			System.out.println(myUrl);
	
			
//			Sending URL
			URL url = new URL(myUrl);
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			con.setRequestProperty("cache-control", "no-cache");
			
			int code = con.getResponseCode();
			System.out.println("response code = "+ code);
			
			StringBuffer response = new StringBuffer();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			while(true)
			{
				String line = br.readLine();
				if(line==null) {
					break;
				}
				response.append(line);
			}
			System.out.println("response = "+ response);
		} catch (Exception e) {
			e.printStackTrace();
			
			
		}
		
	}
	
	public static void main(String args[])
	{
		System.out.println("starting........");
		Date date = new Date();
		String dateString = date.toLocaleString();
		send("This is a testing sms from Java program Send SMS. Date:" + dateString , "9988776655");
	}

}
