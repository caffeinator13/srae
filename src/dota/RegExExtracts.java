package dota;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExExtracts {

	public static boolean isEmailValid(String email) {
		boolean isValid = false;
		// String emailexp = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$" ;
		//this is a simple regex, if the token as '@' , identifies it as email
		String emailexp = "^(.+)@(.+)$";
		CharSequence inputStr = email;
		Pattern pattern = Pattern.compile(emailexp, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(inputStr);
		if (matcher.matches()) {

			isValid = true;
			System.out.println("email: " + email);

		}

		return isValid;

	}

	public static boolean isPhoneNumberValid(String phoneNumber) {
		boolean isValid = false;
		/*
		 * Phone Number formats: (nnn)nnn-nnnn; nnnnnnnnnn; nnn-nnn-nnnn ^\\(? :
		 * May start with an option "(" . (\\d{3}): Followed by 3 digits. \\)? :
		 * May have an optional ")" [- ]? : May have an optional "-" after the
		 * first 3 digits or after optional ) character. (\\d{3}) : Followed by
		 * 3 digits. [- ]? : May have another optional "-" after numeric digits.
		 * (\\d{4})$ : ends with four digits.
		 * 
		 * Examples: Matches following phone numbers: (123)456-7890,
		 * 123-456-7890, 1234567890, (123)-456-7890
		 * 
		 * //String expression = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
		 */

		// this expression handles all numbers (even those starting with +91 and
		// having arbitrary spaces and hyphens)
		String expression = "(?:\\+\\s*\\d{2}[\\s-]*)?(?:\\d[-\\s]*){10}";
		// String code = (?:\+\s*\d{2}[\s-]*)?(?:\d[-\s]*){10};
		CharSequence inputStr = phoneNumber;
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(inputStr);
		if (matcher.matches()) {
			isValid = true;
			System.out.println("phone: " + phoneNumber);
		}

		return isValid;
	}

}
