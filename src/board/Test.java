package board;

import java.util.Calendar;

public class Test {
	
	public static void main(String[] args) {
		Calendar cal=Calendar.getInstance();
		int year;
		int month;
		int day;
		year=cal.get(Calendar.YEAR);
	    month=cal.get(Calendar.MONTH)+1;
	    day=cal.get(Calendar.DAY_OF_MONTH);
	
	    System.out.println(year+" "+month+" "+day);
	}
	
}
