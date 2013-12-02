// Java file and XML Done entirely by Owen Huyn
package com.example.login;

import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.widget.LinearLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AdminPatientList extends Activity {
	
	public void onBackPressed() {
		
	}
	
	String patientList[];
	String userType;		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin_patient_list);
		
		Intent i = getIntent();
		userType = i.getStringExtra("type");
		Button valueB;
		LinearLayout myLayout;
		
		myLayout =(LinearLayout) findViewById(R.id.linearLayout);
		
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		myLayout.setOrientation(LinearLayout.VERTICAL);
		
		/* replace with accessing database user IDs or names and input into array with for loop*/
		patientList = new String[]{"John","Bob","Paul","Tyler","Albraa","Owen"};
		for (int j = 0; j < patientList.length; j++){
			valueB = new Button(this);
            valueB.setText(patientList[j]);
            valueB.setId(j);
            valueB.setOnClickListener(clickListener);
            myLayout.addView(valueB);
		}

		
		final Dialog dialog = new Dialog(this);
		dialog.setContentView(R.layout.popup1);
		dialog.setTitle("Add Patient");
		Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
		dialogButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog.dismiss();
    			Intent restart = new Intent(AdminPatientList.this, AdminPatientList.class);
    			restart.putExtra("type", userType);
    			startActivity(restart);
			}
			//put write methods here into database to save patient
			
		});
		
		
		final Dialog dialog2 = new Dialog(this);
		dialog2.setContentView(R.layout.popup2);
		dialog2.setTitle("Remove Patient");
		Button dialog2Button = (Button) dialog2.findViewById(R.id.dialogButtonOK);
		dialog2Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog2.dismiss();
    			Intent restart = new Intent(AdminPatientList.this, AdminPatientList.class);
    			restart.putExtra("type", userType);
    			startActivity(restart);
			}
			//put write methods here into database to remove patient
			
		});
		
		
		// if button is clicked, close the custom dialog
        Button addPatientButton = (Button)findViewById(R.id.addPatient);
		addPatientButton.setOnClickListener(new View.OnClickListener(){
	        public void onClick(View v) {
				dialog.show();
	        }

		});
     
		
        Button removePatientButton = (Button)findViewById(R.id.removePatient);
		removePatientButton.setOnClickListener(new View.OnClickListener(){
	        public void onClick(View v) {
				dialog2.show();
	        }

		});
	

	}
    public OnClickListener clickListener = new OnClickListener() {
        public void onClick(View v) {
           
             Intent patientProfile = new Intent(getApplicationContext(), MainMenu.class);
              // change this to a reader once the database is completed
             patientProfile.putExtra("user", patientList[v.getId()]);
             patientProfile.putExtra("type", userType);
             startActivity(patientProfile);      
        }
    };
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.patient_list, menu);
		return true;
	}
	
	


}
