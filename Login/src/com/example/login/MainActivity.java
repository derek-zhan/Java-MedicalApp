// Java file and XML Done entirely by Owen Huyn

package com.example.login;
import android.app.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import static java.lang.System.out;

public class MainActivity extends Activity {

	public void onBackPressed() {
		
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        final EditText userID = (EditText)findViewById(R.id.userID);
        final EditText password = (EditText)findViewById(R.id.password);
        Button mButton = (Button)findViewById(R.id.submitButton);
        
        
     
        mButton.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View v){
        		String username = userID.getText().toString();
        		String pass = password.getText().toString();
        		
        		// change this password equality and put it into the database once the database
        		// is finished
        		if(username.equals("patient") && pass.equals ("patient")) {
        	        final String userType = "patient";
        			Intent mMenu = new Intent(MainActivity.this, com.example.login.MainMenu.class);
        			mMenu.putExtra("user", username);
        			mMenu.putExtra("type", userType);
        			startActivity(mMenu);
        			
        		}
            			
        		// change this password equality and put it into the database once the database
        		// is finished
        		else if(username.equals("d") && pass.equals ("d")) {
        			final String userType = "doctor";
    				Intent mMenu = new Intent(MainActivity.this, com.example.login.PatientList.class);
        			mMenu.putExtra("type", userType);
        			startActivity(mMenu);
            			
        		}
        		
        		// change this password equality and put it into the database once the database
        		// is finished
        		else if(username.equals("admin") && pass.equals ("admin")) {
        			final String userType = "admin";
    				Intent mMenu = new Intent(MainActivity.this, com.example.login.AdminPatientList.class);
        			mMenu.putExtra("type", userType);
        			startActivity(mMenu);
            			
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

    
}
