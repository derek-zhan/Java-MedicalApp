// done entirely by mike leger
package com.example.medicaldatabase;

public class User
{
	private int userId;
	private String userName;
	private String password;
	private int	userType;
	private String nameFirst;
	private String nameLast;
	private String nameMiddle;
	private int birthDate;
	private String healthCard;
	private double weight;
	private double height;
	
	public static void main(String[] args)
	{

	}
	
	public int getUserId()
	{
		return userId;
	}
	
	public String getUserName()
	{
		return userName;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public int getUserType()
	{
		return userType;
	}

	public String getNameFirst()
	{
		return nameFirst;
	}
	
	public String getNameLast()
	{
		return nameLast;
	}
	
	public String getNameMiddle()
	{
		return nameMiddle;
	}
	
	public int getBirthDate()
	{
		return birthDate;
	}
	
	public String getHealthCard()
	{
		return healthCard;
	}
	
	public double getWeight()
	{
		return weight;
	}
	
	public double getHeight()
	{
		return height;
	}
	
	public void setUserId(int input)
	{
		userId = input;
	}

	public void setUserName(String input)
	{
		userName = input;
	}

	public void setPassword(String input)
	{
		password = input;
	}
	
	public void setUserType(int input)
	{
		userType = input;
	}

	public void setNameFirst(String input)
	{
		nameFirst = input;
	}
	
	public void setNameLast(String input)
	{
		nameLast = input;
	}
	
	public void setNameMiddle(String input)
	{
		nameMiddle = input;
	}
	
	public void setBirthDate(int input)
	{
		birthDate = input;
	}
	
	public void setHealthCard(String input)
	{
		healthCard = input;
	}
	
	public void setWeight(double input)
	{
		weight = input;
	}
	
	public void setHeight(double input)
	{
		height = input;
	}
	
}
