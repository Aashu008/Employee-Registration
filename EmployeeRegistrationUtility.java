package com.sears.employee.registration.utility;

public class EmployeeRegistrationUtility {

	public static boolean isInValidGender(String gender) {
		if (((gender.charAt(0) == 'm' || gender.charAt(0) == 'M') && gender.endsWith("e"))
				|| ((gender.charAt(0) == 'f' || gender.charAt(0) == 'F') && gender.endsWith("e")))
			return false;
		else {
			System.out.println("Enter male /female");
			return true;
		}
	}

	public static boolean isInValidAge(String age) {

		try {
			Integer.parseInt(age);
		} catch (NumberFormatException ne) {
			System.out.println("Please Enter valid age(Number Only)");
			return true;
		}
		return false;
	}

	public static boolean isInValidBoolean(String isFTE)

	{
		if (Boolean.parseBoolean(isFTE))
			return false;

		else {
			System.out.println("Enter only true / false");
			return true;
		}

	}
	
	public static boolean setisFTEfromDatabase(String checkIsTE) {
		if (checkIsTE == "y" || checkIsTE == "Y")
			return true;
		else
			return false;
	}

}
