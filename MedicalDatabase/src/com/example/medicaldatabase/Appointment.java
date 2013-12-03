// done entirely by mike leger
package com.example.medicaldatabase;

public class Appointment
{

	private int appointmentId;
	private int userId;
	private int date;
	private int status;
	private String comment;
	
	public static void main(String[] args)
	{

	}
	
	public int getAppointmentId()
	{
		return appointmentId;
	}
	
	public int getUserId()
	{
		return userId;
	}
	
	public int getDate()
	{
		return date;
	}
	
	public int getStatus()
	{
		return status;
	}
	
	public String getComment()
	{
		return comment;
	}
	
	public void setAppointmentId(int input)
	{
		appointmentId = input;
	}

	public void setUserId(int input)
	{
		userId = input;
	}
	
	public void setDate(int input)
	{
		date = input;
	}
	
	public void setStatus(int input)
	{
		status = input;
	}
	
	public void setComment(String input)
	{
		comment = input;
	}
}
