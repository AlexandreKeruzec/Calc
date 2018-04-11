package Calc;

public class Calc {
	
	// Main using args, no priority for * or /
	public static void main(String[] args) {
		int result = 0; 				// to store the final result
		int value = 0; 					// to store the value of the args
		String previousOperator = "+";	// to store the last operator
		boolean isAnInt;
		
		for(String arg : args) {
			value = 0;
			isAnInt = false;
			
			// Find out if value is an int or symbol
			try {
				value = Integer.parseInt(arg);
				isAnInt = true;
//				System.out.println(value);
			}
			catch (NumberFormatException  e) {
				// not an int
			}
			// check if it's a symbol and remember it
			if(!isAnInt) {
				if("+".equals(arg)) {previousOperator = "+";}
				else if("-".equals(arg)) {previousOperator = "-";}
				else if("x".equals(arg)) {previousOperator = "*";}
				else if("/".equals(arg)) {previousOperator = "/";}
				else {
					System.out.println(arg + " is not a valid operator");
					continue;
					}
			}
			
			// Do the math if it's an int
			if(isAnInt) {
				if("+".equals(previousOperator)) {
					result += value;
				}
				if("-".equals(previousOperator)) {
					result -= value;
				}
				if("*".equals(previousOperator)) {
					result *= value;
				}
				if("/".equals(previousOperator)) {
					if(value!=0) {
						result /= value;
					}
					else {
						System.out.println("Error : //0");
						break;
						}
				}
				System.out.println(previousOperator + " " + value + " = " + result);
			}
		}
		// print the result
		System.out.println("Result : " + result);
	}

}
