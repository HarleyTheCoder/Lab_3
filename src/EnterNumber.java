import java.util.Scanner;

//NOTE: I decided to play around with methods.
//      I got stuck, then I realized I can't close the scanner class until the very
//      end of the 'main' method for this to work, even if Eclipse keeps telling me
//      to do so in every method I make.
//      I had to ignore the warnings, idk if there's a different way which doesn't
//      leave warnings, but at least I learned quite a bit.

public class EnterNumber {
	
	//Method to check if number is a valid integer between 1 and 100.
	public static boolean isValidNum(String input, String name) {
		try {
			int number = Integer.parseInt(input);
			if (number >= 1 && number <= 100) {
				return true;
			} else {
				System.out.println("\nThe number must be between 1 and 100, " +
									name + ".");
				return false;
			}
		} catch (NumberFormatException e) {
		    System.out.println("\nSilly " + name + ", the number must be an integer.");
		    return false;
		}
	}
	
	
	//Method to set the main number variable in the "main" class.
	public static int setNumber(String name) {
		Scanner scanner = new Scanner(System.in);
		
		boolean tryAgain;
		String  input;
		int     num;
		
		System.out.print("\n" + name + ", enter a number between 1 and 100: ");
		
		do {
			input = scanner.next();
			if (isValidNum(input, name)) {
				num = Integer.parseInt(input);
				tryAgain = false;
			} else {
				num = 0;
				tryAgain = true;
				System.out.print("Please re-enter: ");
			}
		} while (tryAgain);
		return num;
	}
	
	
	//Set the  text to display for the output.
	public static String getOutput(int number, String name) {
		String output;
		
		//I'm having the string come out EXACTLY as the paper tells me to make it.
		if (isOdd(number) && number > 60) {
			output = name + ", you entered " + number + ". Odd and over 60.";
		} else if (isOdd(number)) {
			output = number + " and Odd.";
		} else if (isEven(number) && number > 60) {
			output = number + " and Even.";
		} else if (isEven(number) && number > 25) {
			output = "Even.";
		} else if (isEven(number) && number > 1) {
			output = "Even and less than 25.";
		} else {
			output = "What the heck, how is this possible!?!?";
		}
		
		return output;
	}

	//Determines whether to continue repeating the program.
	public static boolean willContinue() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("\n\nContinue? (y/n): ");
		String keepGoing = (scanner.next()).toLowerCase();
		if (keepGoing.startsWith("y")) {
			return true;
		} else {
			return false;
		}
	}
	
	//Tests if a number is even.
	public static boolean isEven(int number) {
		if (number % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	//Tests if a number is odd.
		public static boolean isOdd(int number) {
			if (number % 2 != 0) {
				return true;
			} else {
				return false;
			}
		}
	
	//"Main" method.
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		String  name;
		int     number;
		Boolean cont = true;
		
		//get name at start of app
		System.out.print("What is your name?: ");
		name = scanner.next();

		//runs main program, calling created methods
		while (cont) {
			number = setNumber(name);
			System.out.print("\nOutput: " + getOutput(number, name));
			
			cont = willContinue();
			System.out.println();
		}
		
		scanner.close();
	}
	
}
