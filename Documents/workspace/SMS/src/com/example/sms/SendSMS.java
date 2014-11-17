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
	
	final SmsManager sms = SmsManager.getDefault();

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String destination = new String(); 
		String message = new String();
		sms.sendTextMessage(destination, null, message, null, null);
	}

}
