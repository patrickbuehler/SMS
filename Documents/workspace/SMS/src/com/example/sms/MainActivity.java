package com.example.sms;

import java.util.ArrayList;
import java.util.TreeMap;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {
		//remember to change Manifest to accommodate only newer than 19
      
//      static TreeMap<Long, String> numberTreemap = new TreeMap();
//      static TreeMap<Integer, String> messageTreemap = new TreeMap();
      static TreeMap<Long, String[][]> treemap = new TreeMap();

      AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
      
      
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final EditText phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        final EditText textMessage = (EditText) findViewById(R.id.textMessage);
        final EditText date = (EditText) findViewById(R.id.date);
        final EditText time = (EditText) findViewById(R.id.time);
        // Bad to make these final?
        Button go = (Button) findViewById(R.id.go);
       // getFilesDir();
      
        
//		Context.getSystemService(Context.ALARM_SERVICE);

        
        go.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				// Store on disk in case the phone is shut down
				// Android serialization will say about how to store stuff to disk.
				String number = textMessage.getText().toString();
				String message = phoneNumber.getText().toString();
				String[][] keyData = new String[2][];
				long time = 201412120918L;	// Use Alex's code + TimeManager.java
				
				if (treemap.containsKey(time)) {
					keyData = treemap.get(time);
					keyData[0][keyData[0].length + 1] = number;
					keyData[1][keyData[1].length + 1] = message;
				}
				else {
					keyData[0][0] = number;
					keyData[1][0] = message;
					treemap.put(time, keyData);
				}
								
				Intent alarmIntent = new Intent(MainActivity.this, AlarmReceiver.class);
				alarmIntent.putExtra("TIME", time);
				PendingIntent alarmPendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, alarmIntent, 0);
				alarmManager.setExact(AlarmManager.RTC_WAKEUP, time, alarmPendingIntent);
			
			}
		});
        
    }


    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
