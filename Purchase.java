import java.util.*;	//Data structures (Collections), time, Scanner, etc classes.
import java.io.*;	//Input-output classes.

//import indexDate.java;


public class Purchase {

	private String type;
	private double amount; 
	private indexDate date;
	private String description;

	public Purchase(String _type, double _amount, indexDate _date, String _description)
	{
		type = _type;
		amount = _amount; 
		date = _date;
		description = _description;
	}

	public String getType()
	{
		return type;
	}

	public double getAmount()
	{
		return amount; 
	}

	public indexDate getDate()
	{
		return date;
	}

	public String getDescription()
	{
		return description;
	}

	public String toString()
	{
		return description + " ($"+amount+")";
	}

}