package com.ish.genericutility;

import java.util.Random;

/**
 * contains java specific utility
 * 
 * @author Tharun
 *
 */
public class JavaUtility {

	Random random = new Random();
	/**
	 * generate random number with in the limit of 40000 for very invocation
	 * 
	 * @return
	 */
	public int getRandomNumber() {
		int ranInt = random.nextInt(3000);
		return ranInt;
	}
}
