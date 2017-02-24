import java.util.*;	//Data structures (Collections), time, Scanner, etc classes.
import java.io.*;	//Input-output classes.



public class dateData extends HashMap<Integer, Double>
{
	public double cumulativeSum(Integer dateIndex, boolean valid)
	{
		if(this.get(dateIndex)==null)
		{
			//less than 0 is invalid key
			if(dateIndex<0)
			{
				valid = false;
				return -1;
			}
				
			//if the index is valid,
			//and we don't have a value for it
			//we can get the value from the previous
			//index that has a value
			valid = true;
			return cumulativeSum(dateIndex-1, true);
		}
		valid = true;
		return this.get(dateIndex);
	}
}