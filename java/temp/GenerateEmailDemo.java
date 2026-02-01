package temp;

import java.util.Date;

public class GenerateEmailDemo {

	public static void main(String[] args) {
		
		Date date = new Date(); // creates a Date object with current date & time
		String dateString = date.toString();// Convert the Date object to a string
		String noSpaceDateString = dateString.replaceAll(" ", "");// Remove all spaces from the string
		String noSpaceAndColonsDateString= noSpaceDateString.replaceAll("\\:", "");// Remove all colons ":" from the string
		String emailWithTimeStamp=noSpaceAndColonsDateString+"@gmail.com";// Add "@gmail.com" at the end to create an email address
		System.out.println(emailWithTimeStamp);// Print the final email address

	}

}
