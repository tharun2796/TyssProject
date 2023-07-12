package sms_practice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.google.common.util.concurrent.SimpleTimeLimiter;

public class CalendarInfo {
	public static void main(String[] args) {

		// To get the Today's date with Time
		Date date = new Date();
		System.out.println(date);

		// To get only the Today's date
		SimpleDateFormat sis = new SimpleDateFormat("dd/MM/yyyy");
		String fDate = sis.format(date);
		System.out.println(fDate);

		// To go ahead 30 days from Today with Date & Time
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE,30);
		Date newDate = cal.getTime();
		System.out.println(newDate);

		// To get only date of 30 days from Today
		SimpleDateFormat sis1 = new SimpleDateFormat("dd/MM/yyyy");
		String fDate1 = sis1.format(newDate);
		System.out.println(fDate1);

		// To go back 30 days from Today with Date & Time
		Calendar calL = Calendar.getInstance();
		calL.add(Calendar.DATE,-30);
		Date newDate1 = calL.getTime();
		System.out.println(newDate1);

		// To get only date of 30 days from Today
		SimpleDateFormat sis2 = new SimpleDateFormat("dd/MM/yyyy");
		String fDate2 = sis2.format(newDate1);
		System.out.println(fDate2);
	}
}
