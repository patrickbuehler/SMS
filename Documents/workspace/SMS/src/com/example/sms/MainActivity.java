package com.example.sms;

import java.util.TreeMap;

import android.app.Activity;
import android.app.AlarmManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {
	
	  String number = new String();
      String message = new String();
      int identifier = 0;
      
      TreeMap<Integer, String> numberTreemap = new TreeMap();
      TreeMap<Integer, String> messageTreemap = new TreeMap();
      Context.getSystemService(Context.ALARM_SERVICE)
      
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final EditText phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        final EditText textMessage = (EditText) findViewById(R.id.textMessage);
        final EditText date = (EditText) findViewById(R.id.date);
        final EditText time = (EditText) findViewById(R.id.time);
        // Bad to make these final?
        // Why cast to EditText
        Button go = (Button) findViewById(R.id.go);
       // getFilesDir();
      
        
//		Context.getSystemService(Context.ALARM_SERVICE);

        
        go.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				// Do I want to make different instances of the SendSMS class 
				// to allow for more than one "queued" request?
				// How else to accommodate this?
				
				// Store on disk in case the phone is shut down
				// Use a treemap. Keys are when to send, and values are what you're sending
				// Android serialization will say about how to store stuff to disk.
				
				number = textMessage.getText().toString();
				message = phoneNumber.getText().toString();
				numberTreemap.put(identifier, number);
				messageTreemap.put(identifier, message);
				identifier++;
				// Tree map won't matter because you can't have more than one to each person

				//in alarm
				try { 
					SendSMS.sendIt(number, message);
				}
				 	catch (IllegalArgumentException e) {
				 		System.out.println("Please enter a valid phone number and text message."); 
				 		// Make this a system dialogue
				 	}
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
