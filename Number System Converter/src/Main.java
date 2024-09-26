/*Natural Foundation of Informatics Technology
 * Group 12: Sameer Karodia, Zaid Mostafa, Ajay Ramsaran, Muhammad Saad
 * Assignment Part A: Number Systems
 */

import java.util.*;

public class Main{
    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);
        int source_base, target_base;
        String input_number;

        //getting the users input (Input number, source base, and target base)
        System.out.println("**Welcome to our Number System Converter**\nHere you can convert any digit (including negative and fractional) from one of our approved number systems to another!\n\n**NOTE any invalid input will be disregarded");

        //getting source base
        System.out.println("What is your source base (2: Binary, 10: Decimal, 16: Hexadecimal): ");
        do{
            source_base = sc.nextInt();
        }while(source_base != 2 && source_base != 10 && source_base != 16);

        //getting target base
        System.out.println("What is your target base (2: Binary, 10: Decimal, 16: Hexadecimal): ");
        do{
            target_base = sc.nextInt();
        }while(target_base != 2 && target_base != 10 && target_base != 16);

        //getting input number
        System.out.println("What is your number: ");
        do{
            input_number = sc.next();

        }while(!ValidateInput(input_number, source_base));

    }

    //Description: Validates the users number, checks if the number given adheres to the restrictions of their source_base
    //Parameters: input_number and source_base
    //Return: returns true if the users number adheres to the source, and false otherwise
    public static boolean ValidateInput(String input_number, int source_base){
        return true;
    }

    //Descripton: computes the conversion of the input_number from  source_base to target_base
    //Parameters: input_number, source_base and target_base
    //Return: the input_number in the target_base
    public static double convert_number(String input_number, int source_base, int target_base){
        //code to convert from source_base to decimal

        //code to convert form decimal to target_base
        return 0.0;
    }

    //Descripton: splits the input_number into its digits, and stores them in an array of integers,
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
}


