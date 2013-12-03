// done entirely by mike leger
package com.example.medicaldatabase;

public class PatientList
{
	private int patientListId;
	private int doctorId;
	private int patientId;
	
	public static void main(String[] args)
	{

	}
	
	public int getPatientListId()
	{
		return patientListId;
	}
	
	public int getDoctorId()
	{
		return doctorId;
	}
	
	public int getPatientId()
	{
		return patientId;
	}
	
	public void setPatientListId(int input)
	{
		patientListId = input;
	}
	
	public void setDoctorId(int input)
	{
		doctorId = input;
	}

	public void setPatientId(int input)
	{
		patientId = input;
	}
	
}
