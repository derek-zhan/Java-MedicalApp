// done entirely by mike leger
package com.example.medicaldatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter
{

	//--------------------------------------------------------------------------------------------------------------
	// Constants and Data
	//--------------------------------------------------------------------------------------------------------------
	// For logging:
	
	private static final String TAG = "DBAdapter";
	
	public static final String DATABASE_NAME = "MedicalDb";
	public static final int DATABASE_VERSION = 3;
	
	//--------------------------------------------------------------------------------------------------------------
	// User Table
	//--------------------------------------------------------------------------------------------------------------

	// name table
	public static final String DATABASE_USER_TABLE = "user_table";
	
	// set column names for user table
	public static final String USER_KEY_USERID = "user_id";
	public static final String USER_KEY_USERNAME = "user_name";
	public static final String USER_KEY_PASSWORD = "password";
	public static final String USER_KEY_USERTYPE = "userType";
	public static final String USER_KEY_NAMEFIRST = "name_first";
	public static final String USER_KEY_NAMELAST = "name_last";
	public static final String USER_KEY_NAMEMIDDLE = "name_middle";
	public static final String USER_KEY_BIRTHDATE = "birthdate";
	public static final String USER_KEY_HEALTHCARD = "healthcard";
	public static final String USER_KEY_WEIGHT = "weight";
	public static final String USER_KEY_HEIGHT = "height";
	
	// set column index numbers for user table
	public static final int USER_COL_USERID = 0;
	public static final int USER_COL_USERNAME = 1;
	public static final int USER_COL_PASSWORD = 2;
	public static final int USER_COL_USERTYPE = 3;
	public static final int USER_COL_NAMEFIRST = 4;
	public static final int USER_COL_NAMELAST = 5;
	public static final int USER_COL_NAMEMIDDLE = 6;
	public static final int USER_COL_BIRTHDATE = 7;
	public static final int USER_COL_HEALTHCARD = 8;
	public static final int USER_COL_WEIGHT = 9;
	public static final int USER_COL_HEIGHT = 10;
	
	// save all column names
	public static final String[] ALL_USER_KEYS = new String[]
			{
				USER_KEY_USERID,
				USER_KEY_USERNAME,
				USER_KEY_PASSWORD,
				USER_KEY_USERTYPE,
				USER_KEY_NAMEFIRST,
				USER_KEY_NAMELAST,
				USER_KEY_NAMEMIDDLE,
				USER_KEY_BIRTHDATE,
				USER_KEY_HEALTHCARD,
				USER_KEY_WEIGHT,
				USER_KEY_HEIGHT
			};
	
	// create sql database creation string
	private static final String DATABASE_CREATE_USER_TABLE = 
			"create table " + DATABASE_USER_TABLE + " (" +
			USER_KEY_USERID + " integer primary key autoincrement, " +
			USER_KEY_USERNAME + " text not null, " +
			USER_KEY_PASSWORD + " text not null, " +
			USER_KEY_USERTYPE + " integer not null, " +
			USER_KEY_NAMEFIRST + " text not null, " +
			USER_KEY_NAMELAST + " text not null, " +
			USER_KEY_NAMEMIDDLE + " text not null, " +
			USER_KEY_BIRTHDATE + " integer not null, " +
			USER_KEY_HEALTHCARD + " text not null, " +
			USER_KEY_WEIGHT + " blob not null, " +
			USER_KEY_HEIGHT + " blob not null" +
			");";

	//--------------------------------------------------------------------------------------------------------------
	// End User Table
	//--------------------------------------------------------------------------------------------------------------
	
	
	
	//--------------------------------------------------------------------------------------------------------------
	// Patient List Table
	//--------------------------------------------------------------------------------------------------------------
	// name table
	public static final String DATABASE_PATIENTLIST_TABLE = "patient_list_table";
	
	// set column names
	public static final String PATIENTLIST_KEY_PATIENTLISTID = "patient_list_id";
	public static final String PATIENTLIST_KEY_DOCTORID = "doctor_id";
	public static final String PATIENTLIST_KEY_PATIENTID = "patient_id";
	
	// set column index numbers
	public static final int PATIENTLIST_COL_PATIENTLISTID = 0;
	public static final int PATIENTLIST_COL_DOCTORID = 1;
	public static final int PATIENTLIST_COL_PATIENTID = 2;
	
	// save all column names
	public static final String[] ALL_PATIENTLIST_KEYS = new String[]
			{
				PATIENTLIST_KEY_PATIENTLISTID,
				PATIENTLIST_KEY_DOCTORID,
				PATIENTLIST_KEY_PATIENTID
			};
	
	// create sql database creation text
	private static final String DATABASE_CREATE_PATIENTLIST_TABLE = 
			"create table " + DATABASE_PATIENTLIST_TABLE + " (" +
			PATIENTLIST_KEY_PATIENTLISTID + " integer primary key autoincrement, " +
			PATIENTLIST_KEY_DOCTORID + " integer not null, " +
			PATIENTLIST_KEY_PATIENTID + " integer not null" +
			");";
	
	//--------------------------------------------------------------------------------------------------------------
	// End Patient List Table
	//--------------------------------------------------------------------------------------------------------------
	
	
	
	//--------------------------------------------------------------------------------------------------------------
	// Appointments Table
	//--------------------------------------------------------------------------------------------------------------
	// name table
	public static final String DATABASE_APPOINTMENT_TABLE = "appointment_table";
	
	// set column names
	public static final String APPOINTMENT_KEY_APPOINTMENTID = "appointment_id";
	public static final String APPOINTMENT_KEY_USERID = "user_id";
	public static final String APPOINTMENT_KEY_DATE = "date";
	public static final String APPOINTMENT_KEY_STATUS = "status";
	public static final String APPOINTMENT_KEY_COMMENTS = "comments";
	
	// set column index numbers
	public static final int APPOINTMENT_COL_APPOINTMENTID = 0;
	public static final int APPOINTMENT_COL_USERID = 1;
	public static final int APPOINTMENT_COL_DATE = 2;
	public static final int APPOINTMENT_COL_STATUS = 3;
	public static final int APPOINTMENT_COL_COMMENTS = 4;
	
	// save all column names
	public static final String[] ALL_APPOINTMENT_KEYS = new String[]
			{
				APPOINTMENT_KEY_APPOINTMENTID,
				APPOINTMENT_KEY_USERID,
				APPOINTMENT_KEY_DATE,
				APPOINTMENT_KEY_STATUS,
				APPOINTMENT_KEY_COMMENTS
			};
	
	// create sql database creation text
	private static final String DATABASE_CREATE_APPOINTMENT_TABLE = 
			"create table " + DATABASE_APPOINTMENT_TABLE + " (" +
			APPOINTMENT_KEY_APPOINTMENTID + " integer primary key autoincrement, " +
			APPOINTMENT_KEY_USERID + " integer not null, " +
			APPOINTMENT_KEY_DATE + " integer not null, " +
			APPOINTMENT_KEY_STATUS + " integer not null, " +
			APPOINTMENT_KEY_COMMENTS + " text not null" +
			");";

	//--------------------------------------------------------------------------------------------------------------
	// End Appointments Table
	//--------------------------------------------------------------------------------------------------------------
	
	
	
	//--------------------------------------------------------------------------------------------------------------
	// Patient History Table
	//--------------------------------------------------------------------------------------------------------------
	
	// set name
	public static final String DATABASE_PATIENTHISTORY_TABLE = "patient_history_table";
	
	// set column names
	public static final String PATIENTHISTORY_KEY_PATIENTHISTORYID = "history_id";
	public static final String PATIENTHISTORY_KEY_PATIENTID = "patient_id";
	public static final String PATIENTHISTORY_KEY_DATE = "date";
	public static final String PATIENTHISTORY_KEY_HEIGHT = "height";
	public static final String PATIENTHISTORY_KEY_WEIGHT = "weight";
	public static final String PATIENTHISTORY_KEY_HEARTRATE = "heart_rate";
	public static final String PATIENTHISTORY_KEY_BLOODPRESSURE = "blood_pressure";
	public static final String PATIENTHISTORY_KEY_CONDITION = "condition";
	public static final String PATIENTHISTORY_KEY_MEDICATION = "medication";
	public static final String PATIENTHISTORY_KEY_COMMENTS = "comments";
	
	// set column index numbers
	public static final int PATIENTHISTORY_COL_PATIENTHISTORYID = 0;
	public static final int PATIENTHISTORY_COL_PATIENTID = 1;
	public static final int PATIENTHISTORY_COL_DATE = 2;
	public static final int PATIENTHISTORY_COL_HEIGHT = 3;
	public static final int PATIENTHISTORY_COL_WEIGHT = 4;
	public static final int PATIENTHISTORY_COL_HEARTRATE = 5;
	public static final int PATIENTHISTORY_COL_BLOODPRESSURE = 6;
	public static final int PATIENTHISTORY_COL_CONDITION = 7;
	public static final int PATIENTHISTORY_COL_MEDICATION = 8;
	public static final int PATIENTHISTORY_COL_COMMENTS = 9;
	
	// save all column names
	public static final String[] ALL_PATIENTHISTORY_KEYS = new String[]
			{
				PATIENTHISTORY_KEY_PATIENTHISTORYID,
				PATIENTHISTORY_KEY_PATIENTID,
				PATIENTHISTORY_KEY_DATE,
				PATIENTHISTORY_KEY_HEIGHT,
				PATIENTHISTORY_KEY_WEIGHT,
				PATIENTHISTORY_KEY_HEARTRATE,
				PATIENTHISTORY_KEY_BLOODPRESSURE,
				PATIENTHISTORY_KEY_CONDITION,
				PATIENTHISTORY_KEY_MEDICATION,
				PATIENTHISTORY_KEY_COMMENTS
			};
	
	// create sql database creation string
	private static final String DATABASE_CREATE_PATIENTHISTORY_TABLE = 
			"create table " + DATABASE_PATIENTHISTORY_TABLE + " (" +
			PATIENTHISTORY_KEY_PATIENTHISTORYID + " integer primary key autoincrement, " +
			PATIENTHISTORY_KEY_PATIENTID + " integer not null, " +
			PATIENTHISTORY_KEY_DATE + " integer not null, " +
			PATIENTHISTORY_KEY_HEIGHT + " blob not null, " +
			PATIENTHISTORY_KEY_WEIGHT + " blob not null, " +
			PATIENTHISTORY_KEY_HEARTRATE + " blob not null, " +
			PATIENTHISTORY_KEY_BLOODPRESSURE + " blob not null, " +
			PATIENTHISTORY_KEY_CONDITION + " text not null, " +
			PATIENTHISTORY_KEY_MEDICATION + " text not null, " +
			PATIENTHISTORY_KEY_COMMENTS + " text not null" +
			");";

	//--------------------------------------------------------------------------------------------------------------
	// End Patient History Table
	//--------------------------------------------------------------------------------------------------------------
	
	
	// Context of application who uses us.
	private final Context context;
	
	private DatabaseHelper myDBHelper;
	private SQLiteDatabase db;

	
	//--------------------------------------------------------------------------------------------------------------
	// Public Methods
	//--------------------------------------------------------------------------------------------------------------
	
	public DBAdapter(Context ctx)
	{
		this.context = ctx;
		myDBHelper = new DatabaseHelper(context);
	}
	
	// Open the database connection.
	public DBAdapter open()
	{
		db = myDBHelper.getWritableDatabase();
		return this;
	}
	
	// Close the database connection.
	public void close()
	{
		myDBHelper.close();
	}
	
	//--------------------------------------------------------------------------------------------------------------
	// End Public Methods
	//--------------------------------------------------------------------------------------------------------------
	
	
	
	//--------------------------------------------------------------------------------------------------------------
	// User Table Access Functions
	//--------------------------------------------------------------------------------------------------------------
	
	// Add a new set of values to the database.
	public long UserTableAddRow(String userName,
			String password,
			int userType,
			String nameFirst,
			String nameLast,
			String nameMiddle,
			int birthDate,
			String healthCard,
			double weight,
			double height)
	{
		ContentValues initialValues = new ContentValues();
		
		initialValues.put(USER_KEY_USERNAME, userName);
		initialValues.put(USER_KEY_PASSWORD, password);
		initialValues.put(USER_KEY_USERTYPE, userType);
		initialValues.put(USER_KEY_NAMEFIRST, nameFirst);
		initialValues.put(USER_KEY_NAMELAST, nameLast);
		initialValues.put(USER_KEY_NAMEMIDDLE, nameMiddle);
		initialValues.put(USER_KEY_BIRTHDATE, birthDate);
		initialValues.put(USER_KEY_HEALTHCARD, healthCard);
		initialValues.put(USER_KEY_WEIGHT, weight);
		initialValues.put(USER_KEY_HEIGHT, height);
		
		// Insert it into the database.
		return db.insert(DATABASE_USER_TABLE, null, initialValues);
	}
	
	// Delete a row from the database, by rowId (primary key)
	public boolean UserTableDeleteRow(long rowId)
	{
		String where = USER_KEY_USERID + "=" + rowId;
		return db.delete(DATABASE_USER_TABLE, where, null) != 0;
	}
	
	// delete all contents of table
	public void UserTableDeleteAll()
	{
		Cursor c = UserTableGetAll();
		long rowId = c.getColumnIndexOrThrow(USER_KEY_USERID);
		if (c.moveToFirst())
		{
			do
			{
				UserTableDeleteRow(c.getLong((int) rowId));				
			} while (c.moveToNext());
		}
		c.close();
	}
	
	// Return all data in the database.
	public Cursor UserTableGetAll()
	{
		String where = null;
		Cursor c = 	db.query(true, DATABASE_USER_TABLE, ALL_USER_KEYS, 
							where, null, null, null, null, null);
		if (c != null)
		{
			c.moveToFirst();
		}
		return c;
	}

	// Get a specific row (by rowId)
	public Cursor UserTableGetRow(long rowId)
	{
		String where = USER_KEY_USERID + "=" + rowId;
		Cursor c = 	db.query(true, DATABASE_USER_TABLE, ALL_USER_KEYS, 
						where, null, null, null, null, null);
		if (c != null)
		{
			c.moveToFirst();
		}
		return c;
	}
	
	// Change an existing row to be equal to new data.
	public boolean UserTableUpdateRow(int rowId,
			String userName,
			String password,
			int userType,
			String nameFirst,
			String nameLast,
			String nameMiddle,
			int birthDate,
			String	healthCard,
			double weight,
			double height)
	{
		String where = USER_KEY_USERID + "=" + rowId;
		ContentValues newValues = new ContentValues();
		
		newValues.put(USER_KEY_USERNAME, userName);
		newValues.put(USER_KEY_PASSWORD, password);
		newValues.put(USER_KEY_USERTYPE, userType);
		newValues.put(USER_KEY_NAMEFIRST, nameFirst);
		newValues.put(USER_KEY_NAMELAST, nameLast);
		newValues.put(USER_KEY_NAMEMIDDLE, nameMiddle);
		newValues.put(USER_KEY_BIRTHDATE, birthDate);
		newValues.put(USER_KEY_HEALTHCARD, healthCard);
		newValues.put(USER_KEY_WEIGHT, weight);
		newValues.put(USER_KEY_HEIGHT, height);
	
		// Insert it into the database.
		return db.update(DATABASE_USER_TABLE, newValues, where, null) != 0;
	}
	
	public long AuthenticateLogin(String username, String password)
	{
		username = "'" + username + "'";
		password = "'" + password + "'";
		long validation = 0;
		String where = "(" + USER_KEY_USERNAME + "=" + username + " and " + USER_KEY_PASSWORD + "=" + password + ")";
		
		Cursor c = db.query(true, DATABASE_USER_TABLE, ALL_USER_KEYS, 
						where, null, null, null, null, null);
		
		if (c.getCount() != 0)
		{
			c.moveToFirst();
			validation = c.getLong(USER_COL_USERID);
		}
		
		return validation;
	}
	
	//--------------------------------------------------------------------------------------------------------------
	// End User Table Access Functions
	//--------------------------------------------------------------------------------------------------------------
	
	
	//--------------------------------------------------------------------------------------------------------------
	// Patient List Access Functions
	//--------------------------------------------------------------------------------------------------------------
	
	// Add a new set of values to the database.
	public long PatientListAddRow(int doctorId,
			int patientId)
	{
		ContentValues initialValues = new ContentValues();
		
		initialValues.put(PATIENTLIST_KEY_DOCTORID, doctorId);
		initialValues.put(PATIENTLIST_KEY_PATIENTID, patientId);
		
		// Insert it into the database.
		return db.insert(DATABASE_PATIENTLIST_TABLE, null, initialValues);
	}
	
	// Delete a row from the database, by rowId (primary key)
	public boolean PatientListDeleteRow(long rowId)
	{
		String where = PATIENTLIST_KEY_PATIENTLISTID + "=" + rowId;
		return db.delete(DATABASE_PATIENTLIST_TABLE, where, null) != 0;
	}
	
	// delete all values in the database
	public void PatientListDeleteAll()
	{
		Cursor c = UserTableGetAll();
		long rowId = c.getColumnIndexOrThrow(PATIENTLIST_KEY_PATIENTLISTID);
		if (c.moveToFirst())
		{
			do
			{
				PatientListDeleteRow(c.getLong((int) rowId));				
			} while (c.moveToNext());
		}
		c.close();
	}
	
	// Return all data in the database.
	public Cursor PatientListGetAll()
	{
		String where = null;
		Cursor c = 	db.query(true, DATABASE_PATIENTLIST_TABLE, ALL_PATIENTLIST_KEYS, 
							where, null, null, null, null, null);
		if (c != null)
		{
			c.moveToFirst();
		}
		return c;
	}

	// Get a specific row (by rowId)
	public Cursor PatientListGetRow(long rowId)
	{
		String where = PATIENTLIST_KEY_PATIENTLISTID + "=" + rowId;
		Cursor c = 	db.query(true, DATABASE_PATIENTLIST_TABLE, ALL_PATIENTLIST_KEYS, 
						where, null, null, null, null, null);
		if (c != null)
		{
			c.moveToFirst();
		}
		return c;
	}
	
	// Change an existing row to be equal to new data.
	public boolean PatientListUpdateRow(int rowId,
			int doctorId,
			int patientId)
	{
		String where = PATIENTLIST_KEY_PATIENTLISTID + "=" + rowId;
		ContentValues newValues = new ContentValues();
		
		newValues.put(PATIENTLIST_KEY_DOCTORID, doctorId);
		newValues.put(PATIENTLIST_KEY_PATIENTID, patientId);
	
		// Insert it into the database.
		return db.update(DATABASE_PATIENTLIST_TABLE, newValues, where, null) != 0;
	}
	
	//--------------------------------------------------------------------------------------------------------------
	// End Patient List Access Functions
	//--------------------------------------------------------------------------------------------------------------
	
	
	
	//--------------------------------------------------------------------------------------------------------------
	// Appointments Access Functions
	//--------------------------------------------------------------------------------------------------------------
	
	// Add a new set of values to the database.
	public long ApppointmentAddRow(int userId,
			int date,
			int status,
			String comments)
	{
		ContentValues initialValues = new ContentValues();
		
		initialValues.put(APPOINTMENT_KEY_USERID, userId);
		initialValues.put(APPOINTMENT_KEY_DATE, date);
		initialValues.put(APPOINTMENT_KEY_STATUS, status);
		initialValues.put(APPOINTMENT_KEY_COMMENTS, comments);
		
		// Insert it into the database.
		return db.insert(DATABASE_APPOINTMENT_TABLE, null, initialValues);
	}
	
	// Delete a row from the database, by rowId (primary key)
	public boolean AppointmentDeleteRow(long rowId)
	{
		String where = APPOINTMENT_KEY_APPOINTMENTID + "=" + rowId;
		return db.delete(DATABASE_APPOINTMENT_TABLE, where, null) != 0;
	}

	// delete all values in the database
	public void AppointmentDeleteAll()
	{
		Cursor c = AppointmentGetAll();
		long rowId = c.getColumnIndexOrThrow(APPOINTMENT_KEY_APPOINTMENTID);
		if (c.moveToFirst())
		{
			do
			{
				AppointmentDeleteRow(c.getLong((int) rowId));
			} while (c.moveToNext());
		}
		c.close();
	}
	
	// Return all data in the database.
	public Cursor AppointmentGetAll()
	{
		String where = null;
		Cursor c = 	db.query(true, DATABASE_APPOINTMENT_TABLE, ALL_APPOINTMENT_KEYS, 
							where, null, null, null, null, null);
		if (c != null)
		{
			c.moveToFirst();
		}
		return c;
	}

	// Get a specific row (by rowId)
	public Cursor AppointmentGetRow(long rowId)
	{
		String where = APPOINTMENT_KEY_APPOINTMENTID + "=" + rowId;
		Cursor c = 	db.query(true, DATABASE_APPOINTMENT_TABLE, ALL_APPOINTMENT_KEYS, 
						where, null, null, null, null, null);
		if (c != null)
		{
			c.moveToFirst();
		}
		return c;
	}
	
	// Change an existing row to be equal to new data.
	public boolean AppointmentUpdateRow(int rowId,
			int userId,
			int date,
			int status,
			String comments)
	{
		String where = APPOINTMENT_KEY_APPOINTMENTID + "=" + rowId;
		ContentValues newValues = new ContentValues();
		
		newValues.put(APPOINTMENT_KEY_USERID, userId);
		newValues.put(APPOINTMENT_KEY_DATE, date);
		newValues.put(APPOINTMENT_KEY_STATUS, status);
		newValues.put(APPOINTMENT_KEY_COMMENTS, comments);

		// Insert it into the database.
		return db.update(DATABASE_APPOINTMENT_TABLE, newValues, where, null) != 0;
	}
	
	//--------------------------------------------------------------------------------------------------------------
	// End Appointments Access Functions
	//--------------------------------------------------------------------------------------------------------------
	
	
	
	//--------------------------------------------------------------------------------------------------------------
	// Patient History Access Functions
	//--------------------------------------------------------------------------------------------------------------
	
	// Add a new set of values to the database.
	public long PatientHistoryAddRow(int patientId,
			int date,
			double height,
			double weight,
			double heartRate,
			double bloodPressure,
			String condition,
			String medication,
			String comments)
	{
		ContentValues initialValues = new ContentValues();
		
		initialValues.put(PATIENTHISTORY_KEY_PATIENTID, patientId);
		initialValues.put(PATIENTHISTORY_KEY_DATE, date);
		initialValues.put(PATIENTHISTORY_KEY_HEIGHT, height);
		initialValues.put(PATIENTHISTORY_KEY_WEIGHT, weight);
		initialValues.put(PATIENTHISTORY_KEY_HEARTRATE, heartRate);
		initialValues.put(PATIENTHISTORY_KEY_BLOODPRESSURE, bloodPressure);
		initialValues.put(PATIENTHISTORY_KEY_CONDITION, condition);
		initialValues.put(PATIENTHISTORY_KEY_CONDITION, medication);
		initialValues.put(PATIENTHISTORY_KEY_COMMENTS, comments);
		
		// Insert it into the database.
		return db.insert(DATABASE_PATIENTHISTORY_TABLE, null, initialValues);
	}
	
	// Delete a row from the database, by rowId (primary key)
	public boolean PatientHistoryDeleteRow(long rowId)
	{
		String where = PATIENTHISTORY_KEY_PATIENTHISTORYID + "=" + rowId;
		return db.delete(DATABASE_PATIENTHISTORY_TABLE, where, null) != 0;
	}

	// delete all values in the database
	public void PatientHistoryDeleteAll()
	{
		Cursor c = PatientHistoryGetAll();
		long rowId = c.getColumnIndexOrThrow(PATIENTHISTORY_KEY_PATIENTHISTORYID);
		if (c.moveToFirst())
		{
			do
			{
				PatientHistoryDeleteRow(c.getLong((int) rowId));
			} while (c.moveToNext());
		}
		c.close();
	}
	
	// Return all data in the database.
	public Cursor PatientHistoryGetAll()
	{
		String where = null;
		Cursor c = 	db.query(true, DATABASE_PATIENTHISTORY_TABLE, ALL_PATIENTHISTORY_KEYS, 
							where, null, null, null, null, null);
		if (c != null)
		{
			c.moveToFirst();
		}
		return c;
	}

	// Get a specific row (by rowId)
	public Cursor PatientHistoryGetRow(long rowId)
	{
		String where = PATIENTHISTORY_KEY_PATIENTHISTORYID + "=" + rowId;
		Cursor c = 	db.query(true, DATABASE_PATIENTHISTORY_TABLE, ALL_PATIENTHISTORY_KEYS, 
						where, null, null, null, null, null);
		if (c != null)
		{
			c.moveToFirst();
		}
		return c;
	}
	
	// Change an existing row to be equal to new data.
	public boolean PatientHistoryUpdateRow(int rowId,
			int patientId,
			int date,
			double height,
			double weight,
			double heartRate,
			double bloodPressure,
			String condition,
			String medication,
			String comments)
	{
		String where = PATIENTHISTORY_KEY_PATIENTHISTORYID + "=" + rowId;
		ContentValues newValues = new ContentValues();
		
		newValues.put(PATIENTHISTORY_KEY_PATIENTID, patientId);
		newValues.put(PATIENTHISTORY_KEY_DATE, date);
		newValues.put(PATIENTHISTORY_KEY_HEIGHT, height);
		newValues.put(PATIENTHISTORY_KEY_WEIGHT, weight);
		newValues.put(PATIENTHISTORY_KEY_HEARTRATE, heartRate);
		newValues.put(PATIENTHISTORY_KEY_BLOODPRESSURE, bloodPressure);
		newValues.put(PATIENTHISTORY_KEY_CONDITION, condition);
		newValues.put(PATIENTHISTORY_KEY_CONDITION, medication);
		newValues.put(PATIENTHISTORY_KEY_COMMENTS, comments);
	
		// Insert it into the database.
		return db.update(DATABASE_PATIENTHISTORY_TABLE, newValues, where, null) != 0;
	}
	
	//--------------------------------------------------------------------------------------------------------------
	// End Patient History Access Functions
	//--------------------------------------------------------------------------------------------------------------
	
	
	
	//--------------------------------------------------------------------------------------------------------------
	// Private Helper Classes
	//--------------------------------------------------------------------------------------------------------------
	
	/**
	 * Private class which handles database creation and upgrading.
	 * Used to handle low-level database access.
	 */
	private static class DatabaseHelper extends SQLiteOpenHelper
	{
		DatabaseHelper(Context context)
		{
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase _db)
		{
			_db.execSQL(DATABASE_CREATE_USER_TABLE);
			_db.execSQL(DATABASE_CREATE_PATIENTLIST_TABLE);
			_db.execSQL(DATABASE_CREATE_APPOINTMENT_TABLE);
			_db.execSQL(DATABASE_CREATE_PATIENTHISTORY_TABLE);
		}

		@Override
		public void onUpgrade(SQLiteDatabase _db, int oldVersion, int newVersion)
		{
			Log.w(TAG, "Upgrading application's database from version " + oldVersion
					+ " to " + newVersion + ", which will destroy all old data!");
			
			// Destroy old database:
			_db.execSQL("DROP TABLE IF EXISTS " + DATABASE_USER_TABLE);
			_db.execSQL("DROP TABLE IF EXISTS " + DATABASE_PATIENTLIST_TABLE);
			_db.execSQL("DROP TABLE IF EXISTS " + DATABASE_APPOINTMENT_TABLE);
			_db.execSQL("DROP TABLE IF EXISTS " + DATABASE_PATIENTHISTORY_TABLE);
			
			// Recreate new database:
			onCreate(_db);
		}
	}
}
