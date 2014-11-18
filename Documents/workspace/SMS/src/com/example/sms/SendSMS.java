package com.example.sms;

import android.telephony.SmsManager;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;


public class SendSMS extends BroadcastReceiver {
	 static SmsManager sms = SmsManager.getDefault();
	 // Will this SmsManager work outside of sendIt?
	 // Why have this file structure?
	  static String phoneNum = new String();
	  // private?
	  String phoneMessage = new String();
	 
	 public static void sendIt(String destination, String message){
	 	// TODO Auto-generated method stub
		try {
			sms.sendTextMessage(destination, null, message, null, null);
	 }
		catch (Exception e) { //from Prof Abadi's code incomingSMS. Is this sufficient?
			Log.e("SmsReceiver", "Exception smsReceiver" +e);
		}
	}
	
	public void onReceive(Context context, Intent intent)
	{
		
	}
}
