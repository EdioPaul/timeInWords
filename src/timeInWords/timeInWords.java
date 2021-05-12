package timeInWords;

import java.util.Scanner;

public class timeInWords {
	public static void main(String[] args) {
		 @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("Type the time: "); 
		Integer hour = Integer.parseInt(scanner.nextLine());
		System.out.print("Type the minutes: ");
		Integer minute = Integer.parseInt(scanner.nextLine());
		System.out.print(hour + ":" + minute);
		String[] numNames = { 
				"", " one", " two", " three", " four", 
				" five", " six", " seven", " eight", " nine",
			    " ten", " eleven", " twelve", " thirteen", " fourteen",
				" fifteen", " sixteen", " seventeen", " eighteen", " nineteen"
				};
		String[] tensNames = { 
				"", " ten", " twenty", " thirty", " fourty",
				" fifty", " sixty", " seventy", " eighty", " ninety"
				};
		String setString1 = " minutes past ";
		String setString2 = " minutes to ";
		String minuteString = "";
		if (minute == 0)
			System.out.println(numNames[hour].trim() + " o' clock");
		else if (minute == 15)
			System.out.println(" quarter past " + numNames[hour].trim());
		else if (minute < 30) {
			if (minute == 1)
				setString1 = " minute past ";
			if (minute < 20)
				minuteString = numNames[minute % 20];
			else {
				minuteString = numNames[minute % 10];
				minute /= 10;
				minuteString = tensNames[minute % 10] + minuteString;
			}
			System.out.println(minuteString.trim() + setString1 + numNames[hour].trim());
		} else if (minute == 30)
			System.out.println(" half past " + numNames[hour].trim());
		else if (minute == 45)
			System.out.println(" quarter to " + numNames[hour + 1 < 12 ? hour + 1 : 1].trim());
		else if (minute > 30) {
			minute = 60 - minute;
			if (minute == 1)
				setString2 = " minute to ";
			if (minute < 20)
				minuteString = numNames[minute % 20];
			else {
				minuteString = numNames[minute % 10];
				minute /= 10;
				minuteString = tensNames[minute % 10] + minuteString;
			}
			System.out.println(minuteString.trim() + setString2 + numNames[hour + 1 <= 12 ? hour + 1 : 1].trim());
		}
    }
}
