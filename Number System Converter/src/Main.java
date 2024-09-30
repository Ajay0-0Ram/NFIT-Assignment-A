/*Natural Foundation of Informatics Technology
 * Group 12: Ebubechukwu Agwagah, Sameer Karodia, Zaid Mostafa, Ajay Ramsaran, Muhammad Saad
 * Assignment Part A: Number Systems
 */

import java.util.*;
import java.lang.Math;

public class Main{
    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);
        int source_base, target_base;
        String input_number;

        //getting the users input (Input number, source base, and target base)
        System.out.println("**Welcome to our Number System Converter**\nHere you can convert any digit (including negative and fractional) from one of our approved number systems to another!\n\n**NOTE any invalid input will be disregarded");

        //getting source base
        System.out.println("What is your source base (2: Binary, 10: Decimal, 16: Hexadecimal): ");
        while (true) {
            try {
                source_base = sc.nextInt();
                if (source_base == 2 || source_base == 10 || source_base == 16) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 2, 10, or 16.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number (2, 10, or 16).");
                sc.next(); // Clear the invalid input
            }
        }


        //getting target base
        System.out.println("What is your target base (2: Binary, 10: Decimal, 16: Hexadecimal): ");
        while (true) {
            try {
                target_base = sc.nextInt();
                if (target_base == 2 || target_base == 10 || target_base == 16) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 2, 10, or 16.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number (2, 10, or 16).");
                sc.next(); // Clear the invalid input
            }
        }


        //getting input number
        System.out.println("What is your number: ");

        while (true) {
            input_number = sc.next();
            if (ValidateInput(input_number, source_base)) {
                // After the input is validated, print confirmation
                System.out.println("valid input number");
                break;  // Valid input number, exit loop
            }
            System.out.println("Invalid input number. Please try again.");
        }


        //GETTING AN ARRAY OF THE INPUT NUMBER PROVIDED
        ArrayList<Integer>Input_array=digitSplit(input_number);





        String converter = convert_number(input_number,source_base,target_base);
        System.out.print("\nConverted number is: " + converter);


    }


    //Description: Validates the users number, checks if the number given adheres to the restrictions of their source_base
    //Parameters: input_number and source_base
    //Return: returns true if the users number adheres to the source, and false otherwise
    public static boolean ValidateInput(String input_number, int source_base){

        String valid_nums="";
        //Flag to make sure only 1 negative number and 1 decimal point can be used
        boolean hasDecimal_point=false;
        boolean hasNegative_sign=false;

        // Define valid characters based on the source_base given
        if(source_base == 2){
            valid_nums="01";
        }
        else if(source_base == 10){
            valid_nums="0123456789";
        }
        else if(source_base == 16){
            valid_nums="0123456789abcdefABCDEF";
        }
        else{
            return false;
        }

        // Loop through each character of the input_number
        for (int i=0; i<input_number.length(); i++){
            char z=input_number.charAt(i);

            //checking ONLY first value for a negative sign
            if(z=='-' && i==0 && !hasNegative_sign){
                hasNegative_sign=true;
                continue;
            }

            //if character is a decimal then changes flag to not allow anymore decimals
            if(z=='.' && !hasDecimal_point){
                hasDecimal_point=true;
                continue;
            }


            //checking to see if the character is valid for source_base
            if(valid_nums.indexOf(z)==-1){
                return false;
            }
        }
        return true;
    }



    //Description: computes the conversion of the input_number from decimal to target_base
    //Parameters: input_number, source_base and target_base
    //Return: the input_number in the target_base
    public static String convert_number(String input_number, int source_base, int target_base){
        double converted_number;
        ArrayList<Integer> Input_array_integers = digitSplitInteger(digitSplit(input_number));
        ArrayList<Integer> Input_array_fraction = digitSplitFraction(digitSplit(input_number));

        //if target base is decimal automatically returns the decimal value from toDec method
        if (target_base==10){
            converted_number=toDec(source_base, Input_array_integers, Input_array_fraction);
            return (String.valueOf(converted_number));
        }

        //takes decimal equivalent and converts to binary
        if(target_base==2){
            double decimal_value = toDec(source_base, Input_array_integers, Input_array_fraction);
            String binary_as_String = (toBinOrHex(target_base, decimal_value));
            converted_number = Integer.parseInt(binary_as_String);
            return (String.valueOf(converted_number));
        }


        //takes decimal equivalent and converts to hexadecimal
        if(target_base==16){
            double decimal_value = toDec(source_base, Input_array_integers, Input_array_fraction);
            String hexa_as_String = (toBinOrHex(target_base, decimal_value));
            return (String.valueOf(hexa_as_String));
        }

        return "0";
    }

    //Converts the guaranteed decimal value to either binary or hex
    public static String toBinOrHex(int target_base, double decimal_value) {
        double quotient = (int) decimal_value;
        int remainder;
        String BinOrHex = "";
        // Converting whole portion
        while (quotient > 0) {
            remainder = ((int) quotient) % target_base;
            // Converts the hexadecimal digits if necessary
            switch (remainder) {
                case 10:
                    BinOrHex = "A" + BinOrHex;
                    break;
                case 11:
                    BinOrHex = "B" + BinOrHex;
                    break;
                case 12:
                    BinOrHex = "C" + BinOrHex;
                    break;
                case 13:
                    BinOrHex = "D" + BinOrHex;
                    break;
                case 14:
                    BinOrHex = "E" + BinOrHex;
                    break;
                case 15:
                    BinOrHex = "F" + BinOrHex;
                    break;
                default:
                    BinOrHex = remainder + BinOrHex;
                    break;
            }
            quotient = Math.floor(quotient / target_base);
        }

        // Converting the fractional part
        quotient = decimal_value - (int) decimal_value;
        if (quotient > 0) {
            BinOrHex += ".";
            int count = 0;  // To limit the number of digits for non-terminating fractions

            while (quotient != 0 ) { // Limit to 10 digits to avoid infinite loops
                quotient *= target_base;
                remainder = (int) quotient;

                // Converts the hexadecimal digits if necessary
                switch (remainder) {
                    case 10:
                        BinOrHex += "A";
                        break;
                    case 11:
                        BinOrHex += "B";
                        break;
                    case 12:
                        BinOrHex += "C";
                        break;
                    case 13:
                        BinOrHex += "D";
                        break;
                    case 14:
                        BinOrHex += "E";
                        break;
                    case 15:
                        BinOrHex += "F";
                        break;
                    default:
                        BinOrHex += remainder;
                        break;
                }

                quotient -= remainder;  // Update the fractional part
                count++;  // Increment count to prevent infinite loop for non-terminating fractions
            }
        }

        return BinOrHex;
    }

//*********************************************************************************************************************
    //6 METHODS WORKING TOGETHER TO CONVERT THE USER INPUT INTO 2 ARRAYLISTS WHOLE AND FRAC PORTIONS, IN DECIMAL

    //Description: splits the input_number into its digits, and stores them in an array of integers,
    //the first entry is reserved for 1 or -1 to denote negative/positive values,
    // the number 100 is used as a decimal point to separate whole and fractional parts
    //Parameters: input_number
    //Return: an array with each digit of the input_number,
    public static ArrayList<Integer> digitSplit(String input_number){
        //Initialize: array for splitting the input string, and ArrayList for storing the integers
        String[] array_input = input_number.split("");
        ArrayList<Integer>input_number_digits = new ArrayList<>();

        //loop through the users number, and converts each digit/char to their integer representation
        for(int i = 0; i<array_input.length;i++){

            //leftmost integer reserved for positive or negative
            if(i==0){
                if(array_input[0].equals("-")){
                    input_number_digits.add(-1);
                }
                else{input_number_digits.add(1);}
            }

            //converts the rest of the digits/hexa
            switch ((array_input[i]).toUpperCase()){
                case "-": break;
                case "A": input_number_digits.add(10); break;
                case "B": input_number_digits.add(11); break;
                case "C": input_number_digits.add(12); break;
                case "D": input_number_digits.add(13); break;
                case "E": input_number_digits.add(14); break;
                case "F": input_number_digits.add(15); break;
                //sets up an identifiable split between whole and fractional portions
                case ".": input_number_digits.add(100); break;
                default: input_number_digits.add(Integer.parseInt(array_input[i]));
            }
        }
        //finally return the final arrayList
        return input_number_digits;


    }
    public static ArrayList<Integer> digitSplitInteger(ArrayList<Integer> Input_array) {
        ArrayList<Integer> integerPart = new ArrayList<>();

        // Goes through the input array and spits out everything before the decimal point (100)
        for (int digit : Input_array) {

            if (digit == 100) {
                break;  // Stop at the decimal point
            }
            integerPart.add(digit);  // Add digits before the decimal point
        }

        return integerPart;
    }

    public static ArrayList<Integer> digitSplitFraction(ArrayList<Integer> Input_array) {
        ArrayList<Integer> fractionalPart = new ArrayList<>();
        //flag for checking if found a decimal
        boolean foundDecimalPoint=false;

        // Going through each value in the input array
        for (int digit : Input_array) {
            // Once it sees (100), starts adding the digits after it
            if (digit == 100) {
                foundDecimalPoint = true;
                continue;  // Skip the decimal point (100) itself
            }

            if (foundDecimalPoint) {
                fractionalPart.add(digit);  // Add all digits after the decimal point
            }
        }

        return fractionalPart;
    }

    //Converts any number they give to its decimal value
    public static double toDec(int source_base, ArrayList<Integer> Input_array_integers, ArrayList<Integer> Input_array_fraction) {
        double decimal_int_value = 0;
        double decimal_fraction_value = 0;
        double decimal_value = 0;

        int power = 0;

        // Converting the integer part
        for (int i = Input_array_integers.size() - 1; i > 0; i--) {  // Skip the first element for negative sign
            double currentDigit = Input_array_integers.get(i);
            decimal_int_value += currentDigit * Math.pow(source_base, power);
            power++;
        }

        // Converting the fractional part
        power = -1;
        for (int i = 0; i < Input_array_fraction.size(); i++) {
            double currentDigit = Input_array_fraction.get(i);
            decimal_fraction_value += currentDigit * Math.pow(source_base, power);
            power--;
        }

        // Adding up both the integer and fractional parts
        decimal_value = decimal_int_value + decimal_fraction_value;

        // Applying negative sign if the first element of Input_array_integers is -1
        if (Input_array_integers.get(0) == -1) {
            decimal_value = -decimal_value;
        }

        return decimal_value;
    }

    // Method to extract integer part digits from decimal_value (with negative sign)
    public static ArrayList<Integer> getDecIntegers(double decimal_value) {
        ArrayList<Integer> decimal_value_integers = new ArrayList<>();

        // Convert the double value to a string
        String decimalString = Double.toString(decimal_value);

        // Split the string into integer and fractional parts using the decimal point
        String[] parts = decimalString.split("\\.");

        // Get the integer part, including the negative sign if present
        String integerPart = parts[0];

        // Extract digits from the integer part (including the negative sign)
        for (char digitChar : integerPart.toCharArray()) {
            if (digitChar == '-') {
                decimal_value_integers.add(-1);  // Add -1 for the negative sign
            } else {
                int digit = Character.getNumericValue(digitChar);
                decimal_value_integers.add(digit);  // Add each digit to the list
            }
        }

        return decimal_value_integers;
    }

    // Method to extract fractional part digits from decimal_value (with precision)
    public static ArrayList<Integer> getDecFractions(double decimal_value) {
        ArrayList<Integer> decimal_value_fractions = new ArrayList<>();

        // Convert the double value to a string
        String decimalString = Double.toString(decimal_value);

        // Split the string into integer and fractional parts using the decimal point
        String[] parts = decimalString.split("\\.");

        // If there's no fractional part, return an empty list
        if (parts.length == 1) {
            return decimal_value_fractions;  // No fractional part
        }

        // Get the fractional part (everything after the decimal point)
        String fractionalPart = parts[1];

        // Extract digits from the fractional part
        for (char digitChar : fractionalPart.toCharArray()) {
            int digit = Character.getNumericValue(digitChar);
            decimal_value_fractions.add(digit);  // Add each digit to the list
        }

        return decimal_value_fractions;
    }

}
