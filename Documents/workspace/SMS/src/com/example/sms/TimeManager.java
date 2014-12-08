package com.example.sms;

import java.text.SimpleDateFormat;

// import android.text.format.DateFormat;

public class TimeManager {
	
		static long unixTime;
	
	public static long dateConverter(String time) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(time);
		// Timezone?
		
		try {
			unixTime = dateFormat.parse(time).getTime();
			unixTime = unixTime / 1000;
		}
		catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return unixTime;
	}

}
