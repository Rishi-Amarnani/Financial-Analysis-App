import java.util.*;	//Data structures (Collections), time, Scanner, etc classes.
import java.io.*;	//Input-output classes.

//import Purchase.java;
//import dateData.java;

public class Analyze {




private static HashMap<String, dateData> sums = new HashMap<String, dateData>();

private static HashMap<String, Integer> startIndices = new HashMap<String, Integer>();


private static HashMap<String, HashMap<indexDate, Day>> purchases = new HashMap<String, HashMap<indexDate, Day>>();



public static void main(String[] args)
{
	testit();
//	testit();
}

public static void testit()
{
	Purchase a = new Purchase("food", 100, new indexDate(2017, 1, 23), "Tacos");
	Purchase b = new Purchase("food", 200, new indexDate(2017, 1, 24), "Suit");
	processPurchase(a);
	processPurchase(b);
	printPurchases();
	printTotalSpending();
}


public static void printTotalSpending()
{
	int sum = 0;
	for(String type: sums.keySet())
	{
		dateData data = sums.get(type);
		double subSum = data.get(data.size()-1);
		System.out.println("$" + subSum + " spent on " + type + ".");
		sum += subSum;
	}
	System.out.println("$" + sum + " spent in total.");
}

public static void printPurchases()
{
	for(String type: purchases.keySet())
	{
		System.out.println("Purchases of "+ type);
		HashMap<indexDate, Day> typeTable = purchases.get(type);
		for(indexDate date: typeTable.keySet())
		{
			System.out.println("\tOn " + date.toString());
			Day day = typeTable.get(date);
			{
				for(Purchase purchase: day)
				{
					System.out.println("\t\t" + purchase.toString());
				}
			}
		}
	}
}




public static void processPurchase(Purchase p)
{
	recordByDate(p);
	incrementSum(p);
}


public static void incrementSum(Purchase p)
{
	String type = p.getType();

	double amt = p.getAmount();

	dateData typeTable	= sums.get(type);
	if(typeTable == null)
	{
		typeTable = new dateData();
		sums.put(type, typeTable);
	}
	
	Object startIndex = startIndices.get(type);

	if(startIndex == null)//this is the first purchase recorded
	{
		startIndex = p.getDate().getIndex(0);
		typeTable.put(0, amt);
		return;//done executing
	}

	Integer dateIndex = p.getDate().getIndex((Integer)startIndex);
	boolean valid = false;
	double oldSum = typeTable.cumulativeSum(dateIndex, valid);

	if(valid == false)
	{
		System.out.println("Bad input!!!!! Exiting!");
		System.exit(0);
	}

	typeTable.put(dateIndex, oldSum + amt);
}


public static void recordByDate(Purchase p)
{
	String type = p.getType();
	indexDate date = p.getDate();

	//table of purchase dates for each type of purchase
	HashMap<indexDate, Day> typeTable = purchases.get(type);
	if(typeTable == null)
	{
		typeTable = new HashMap<indexDate, Day>();
		purchases.put(type, typeTable);
	}	

	//within the table of each type
	//we have a list of purchases for each day
	Day day = typeTable.get(date);
	if(day == null)
	{
		day = new Day();
		typeTable.put(date, day);
	}

	//add the purchase to the list of purchases for that day
	day.add(p);	
}




}

