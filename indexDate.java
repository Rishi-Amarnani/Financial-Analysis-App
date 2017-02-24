import java.util.*;	//Data structures (Collections), time, Scanner, etc classes.
import java.io.*;	//Input-output classes.




public class indexDate extends Date {


	public indexDate(int year, int month, int day)
	{
		super(year, month, day);
	}


	//compute an integer value from date
	//subtract startIndex from this value
	//because startIndex is where our sums begin from
	//it is like our "0 spot" in an array
	public int getIndex(Integer startIndex)
	{
		int index = this.getYear() * this.getMonth() * this.getDay();
		return (index - startIndex);
	}

}