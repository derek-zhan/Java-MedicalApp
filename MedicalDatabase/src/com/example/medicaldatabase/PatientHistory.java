// done entirely by mike leger
package com.example.medicaldatabase;

public class PatientHistory
{
	private int patientHistoryId;
	private int patientId;
	private int date;
	private double height;
	private double weight;
	private double heartRate;
	private double bloodPressure;
	private String condition;
	private String medication;
	private String comment;
	
	public static void main(String[] args)
	{
	
	}
	
	public int getPatientHistoryId()
	{
		return patientHistoryId;
	}
	
	public int getPatientId()
	{
		return patientId;
	}
	
	public int getDate()
	{
		return date;
	}
	
	public double getHeight()
	{
		return height;
	}
	
	public double getWeight()
	{
		return weight;
	}
	
	public double getHeartRate()
	{
		return heartRate;
	}
	
	public double getBloodPressure()
	{
		return bloodPressure;
	}
	
	public String getCondition()
	{
		return condition;
	}
	
	public String getMedication()
	{
		return medication;
	}
	
	public String getComment()
	{
		return comment;
	}
	
	public void setPatientHistoryId(int input)
	{
		patientHistoryId = input;
	}
	
	public void setPatientId(int input)
	{
		patientId = input;
	}
	
	public void setDate(int input)
	{
		date = input;
	}
	
	public void setWeight(double input)
	{
		weight = input;
	}
	
	public void setHeight(double input)
	{
		height = input;
	}
	
	public void setHeartRate(double input)
	{
		heartRate = input;
	}
	
	public void setBloodPressure(double input)
	{
		bloodPressure = input;
	}
	
	public void setCondition(String input)
	{
		condition = input;
	}
	
	public void setMedication(String input)
	{
		medication = input;
	}
	
	public void setComment(String input)
	{
		comment = input;
	}

}
