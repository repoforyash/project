package com.cognizant.banking.utilities;

public class GenerateCustomerID {
	
	public static String generateID(String lastName) {
		String initials = lastName.substring(0, Math.min(lastName.length(), 2)).toUpperCase();
		
		int randomNumber = (int) (Math.random() * 9000) + 1000;
		
		return initials + randomNumber ;
	}

}
