package com.example.sms;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {

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
        
//		Context.getSystemService(Context.ALARM_SERVICE);

        
        go.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				// Do I want to make different instances of the SendSMS class 
				// to allow for more than one "queued" request?
				// How else to accommodate this?
				
				
				String number = textMessage.getText().toString();
				String message = phoneNumber.getText().toString();
				SendSMS.sendIt(number, message);
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
