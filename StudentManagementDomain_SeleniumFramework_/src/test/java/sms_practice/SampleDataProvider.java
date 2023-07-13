package sms_practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleDataProvider {
	@Test(dataProvider = "bookTicketsDataProvider")
	public void bookTickets(String src,String dst,int price) {
		System.out.println("From: "+src+"->"+dst+"==>"+price);
	}
	
	@DataProvider
	public Object[][] bookTicketsDataProvider(){
		Object[][] objArray = new Object[4][3];

		objArray[0][0]="Coimbatore";
		objArray[0][1]="Chennai";
		objArray[0][2]= 3200;

		objArray[1][0]="Kochi";
		objArray[1][1]="Trivandrum";
		objArray[1][2]= 2000;

		objArray[2][0]="Bangalore";
		objArray[2][1]="Hyderabad";
		objArray[2][2]= 6000;

		objArray[3][0]="Mumbai";
		objArray[3][1]="Pune";
		objArray[3][2]= 10000;

		return objArray;
	}

}
