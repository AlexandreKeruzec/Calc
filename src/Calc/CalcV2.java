package Calc;

import java.util.ArrayList;

public class CalcV2 {
	// Main using args
	// uses 'x' as '*'
	
	static ArrayList<Integer> numberList = new ArrayList<Integer>();
	static ArrayList<String> operatorList = new ArrayList<String>();
	
	public static void main(String[] args) {
		
		sortArgsInLists(args);
		
		calculateResult();
	}
	
	public static void sortArgsInLists(String[] args) {
		numberList.clear();
		operatorList.clear();
		
		int value;
		String operator;
		
		// put all the args in either list
		for(String arg : args) {
			// check if it's a number
			try {
				value = Integer.parseInt(arg);
				numberList.add(value);
				continue;
			}
			catch (NumberFormatException  e) {
			}
			// check if it's an operator
			if("+".equals(arg)) {operator = "+"; operatorList.add(operator);}
			else if("-".equals(arg)) {operator = "-"; operatorList.add(operator);}
			else if("x".equals(arg)) {operator = "*"; operatorList.add(operator);}
			else if("/".equals(arg)) {operator = "/"; operatorList.add(operator);}
			else {
				System.out.println(arg + " is not a valid operator");
				continue;
			}
		}
		// print out the resulting lists
		System.out.println(numberList);
		System.out.println(operatorList);		
	}
	
	public static void calculateResult() {
		while (operatorList.size()>0) {
			// find priority operations, calculate and put the results in a new list
			// find the first priority operator (x or /), if one found stop and calculate, if not, use the first operator
			int index = 0;
			for(String operatorInList : operatorList) {
				// if it's a priority operator, we use it for the next calculation
				// if not, we keep looking in the list 
				if ("*".equals(operatorInList) || "/".equals(operatorInList)) {
					break;
				}
				// if we reach the last element without finding any priority operator, we use the first element
				if (index == operatorList.size()-1) {
					index = 0;
					break;
				}
				index++;
			}
			// calculate and place the result at the index
			// get the values to use for the calculation
			int result = 0;
			int firstValue = numberList.get(index);
			int secondValue = numberList.get(index+1);
			String operator = operatorList.get(index);
			if("+".equals(operator)) {result = firstValue + secondValue;}
			else if("-".equals(operator)) {result = firstValue - secondValue;}
			else if("*".equals(operator)) {result = firstValue * secondValue;}
			else if("/".equals(operator)) {result = firstValue / secondValue;}

			// remove the values used and set the result at the index position
			numberList.remove(index);
			numberList.set(index, result);
			operatorList.remove(index);
		}
		// print out the result
		System.out.println(numberList.get(0));
	}
	

}
