// done entirely by mike leger
package com.example.medicaldatabase;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

@SuppressWarnings("unused")
public class MedicalDatabase extends Activity
{

	DBAdapter medicalDatabase;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.medical_database);
		
		OpenDB();
	}
	
	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		
		CloseDB();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.medical_database, menu);
		return true;
	}

	private void OpenDB()
	{
		medicalDatabase = new DBAdapter(this);
		medicalDatabase.open();
	}

	private void CloseDB()
	{
		medicalDatabase.close();
	}
	
	private void DisplayText(String message)
	{
		TextView textView = (TextView)findViewById(R.id.lbl_Display);
		textView.setText(message);
	}
	
	private void DisplayRecordSet(Cursor cursor)
	{
		String message = "";
		User user = new User();
		
		if (cursor.moveToFirst())
		{
			do
			{
			user.setUserId(cursor.getInt(DBAdapter.USER_COL_USERID));
			user.setUserName(cursor.getString(DBAdapter.USER_COL_USERNAME));
			user.setPassword(cursor.getString(DBAdapter.USER_COL_PASSWORD));
			user.setUserType(cursor.getInt(DBAdapter.USER_COL_USERTYPE));
			user.setNameFirst(cursor.getString(DBAdapter.USER_COL_NAMEFIRST));
			user.setNameLast(cursor.getString(DBAdapter.USER_COL_NAMELAST));
			user.setNameMiddle(cursor.getString(DBAdapter.USER_COL_NAMEMIDDLE));
			user.setBirthDate(cursor.getInt(DBAdapter.USER_COL_BIRTHDATE));
			user.setHealthCard(cursor.getString(DBAdapter.USER_COL_HEALTHCARD));
			user.setWeight(cursor.getDouble(DBAdapter.USER_COL_WEIGHT));
			user.setHeight(cursor.getDouble(DBAdapter.USER_COL_HEIGHT));
			
			message += "0=" + user.getUserId()
					+ ", 1=" + user.getUserName()
					+ ", 2=" + user.getPassword()
					+ ", 3=" + user.getUserType()
					+ ", 4=" + user.getNameFirst()
					+ ", 5=" + user.getNameLast()
					+ ", 6=" + user.getNameMiddle()
					+ ", 7=" + user.getBirthDate()
					+ ", 8=" + user.getHealthCard()
					+ ", 9=" + user.getWeight()
					+ ", 10=" + user.getHeight()
					+ "\n";
			} while(cursor.moveToNext());
			
		}
		
		cursor.close();
		
		DisplayText(message);
	}
	
	public void OnClick_SaveName(View v)
	{
		//how to check for username/password match to database
		/*
		String username = "hockeymi";
		String password = "soccerr";
		String result = String.valueOf(medicalDatabase.AuthenticateLogin(username, password));
		
		DisplayText(result);
		*/
		
		//code to delete all
		/*
		medicalDatabase.UserTableDeleteAll();
		*/
		
		//code to delete one row
		/*
		long deleteId = 7;
		boolean wasDeleted = false;
		wasDeleted = medicalDatabase.UserTableDeleteRow(deleteId);
		
		DisplayText(String.valueOf(wasDeleted));
		*/
		
		//code to get one row
		/*
		long getRowId = 9;
		Cursor cursor;
		
		User user = new User();
		
		cursor = medicalDatabase.UserTableGetRow(getRowId);
		
		user.setUserId(cursor.getInt(DBAdapter.USER_COL_USERID));
		user.setUserName(cursor.getString(DBAdapter.USER_COL_USERNAME));
		user.setPassword(cursor.getString(DBAdapter.USER_COL_PASSWORD));
		user.setUserType(cursor.getInt(DBAdapter.USER_COL_USERTYPE));
		user.setNameFirst(cursor.getString(DBAdapter.USER_COL_NAMEFIRST));
		user.setNameLast(cursor.getString(DBAdapter.USER_COL_NAMELAST));
		user.setNameMiddle(cursor.getString(DBAdapter.USER_COL_NAMEMIDDLE));
		user.setBirthDate(cursor.getInt(DBAdapter.USER_COL_BIRTHDATE));
		user.setHealthCard(cursor.getString(DBAdapter.USER_COL_HEALTHCARD));
		user.setWeight(cursor.getDouble(DBAdapter.USER_COL_WEIGHT));
		user.setHeight(cursor.getDouble(DBAdapter.USER_COL_HEIGHT));
		
		*/
		
		//code to add a new row
		/*
		long newId = medicalDatabase.UserTableAddRow("mikey",
				"cake",
				1,
				"mike",
				"leger",
				"Regan",
				194551300,
				"91352345236566545",
				178.1,
				5.11);
		*/
		
		//code to update a row
		/*
		medicalDatabase.UserTableUpdateRow(8,
				"owen",
				"pie",
				1,
				"owen",
				"huyn",
				"x",
				194551300,
				"91352345236566545",
				190.1,
				5.11);
				*/
				
	}
	
	public void OnClick_Display(View v)
	{
		
		Cursor cursor = medicalDatabase.UserTableGetAll();
		DisplayRecordSet(cursor);
		
	}

}
