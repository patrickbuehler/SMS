package com.example.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class AlarmReceiver extends BroadcastReceiver {

	public static void getStuff()
	{
		
	}
	
	@Override
	public void onReceive(Context context, Intent alarmIntent) {
		// TODO Auto-generated method stub
		
		try { 
			Bundle extras = alarmIntent.getExtras();
			long time = (Long) extras.get("TIME");
			String[][] sendingData = MainActivity.treemap.get(time);
			
			if (sendingData[0].length == 1 && sendingData[1].length == 0) { 
				SendSMS.sendIt(sendingData[0][0], sendingData[1][0], time);
			}
			else {
				for (int i = 0; i < sendingData[0].length; i++) {
					SendSMS.sendIt(sendingData[0][i], sendingData[1][i], time);
				}
			}
		}
		 	catch (IllegalArgumentException e) {
		 		System.out.println("Please enter a valid phone number and text message."); 
		 		// Make this a system dialogue with toast
		 		//Want to check this stuff earlier.
		 	}
		
	}

}
