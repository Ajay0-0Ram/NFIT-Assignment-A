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

    //**NOTE TO GROUP: ajay is working on this, in another program until it works
    //Descripton: splits the input_number into its digits, and stores them in an array
    //Parameters: input_number
    //Return: an array with each digit of the input_number, the 0th entry is reserved for 1 or -1 to denote negative/positive values
    public static int[] splitInt(String input_number){
        int[] placeHolder = {0,1};
        return placeHolder;
    }
}


