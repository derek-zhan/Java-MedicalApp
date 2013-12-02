package com.example.medapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class editapts extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
			setContentView(R.layout.editapts);
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
	            // Show the Up button in the action bar.
	            getActionBar().setDisplayHomeAsUpEnabled(true);
	        }
			final EditText et;
			et = (EditText) findViewById(R.id.editText1);
			
	    // Get the message from the intent
	    Intent intent = getIntent();
	    String apts = intent.getStringExtra(MainActivity.apts);
	    et.setText(apts);

	}
	public void save(View view){
		// Do something in response to button
				Intent intent = new Intent(view.getContext(),MainActivity.class);
				TimePicker dp = (TimePicker)findViewById(R.id.timePicker1);		
				int time = Integer.parseInt(String.valueOf(dp.getCurrentHour()) + String.valueOf(dp.getCurrentMinute()));
				
				//access DATABASE
				
				startActivity(intent);
				
	}
}
