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


public class SendSMS {
	 static SmsManager sms = SmsManager.getDefault();
	 String phoneNum = new String();
	 String phoneMessage = new String();
	 
	 public static void sendIt(String destination, String message, long identifier){
	 	// TODO Auto-generated method stub
		
			sms.sendTextMessage(destination, null, message, null, null); 
			MainActivity.treemap.remove(identifier);
			// delete relevant files
	 }
}
