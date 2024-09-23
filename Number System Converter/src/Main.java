/*Natural Foundation of Informatics Technology
 * Group 12: Sameer Karodia, Zaid Mostafa, Ajay Ramsaran, Muhammad Saad
 * Assignment Part A: Number Systems
 */

import java.util.*;

public class Main{
    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);
        int source_base, target_base;
        double input_number;

        //getting the users input (Input number, source base, and target base)
        System.out.println("**Welcome to our Number System Converter**\nHere you can convert any digit (including negative and fractional) from one of our approved number systems to another!\n\n**NOTE any invalid input will be disregarded");

        //getting source base
        System.out.println("What is your source base (2: Binary, 10: Decimal, 16: Hexadecimal): ");
        do{
            source_base = sc.nextInt();
        }while(source_base != 2 && source_base != 6 && source_base != 16);

        //getting target base
        System.out.println("What is your target base (2: Binary, 10: Decimal, 16: Hexadecimal): ");
        do{
            target_base = sc.nextInt();
        }while(target_base != 2 && target_base != 6 && target_base != 16);

        //getting input number
        System.out.println("What is your number: ");
        do{
            input_number = sc.nextDouble();
        }while(!ValidateInput(input_number));

    }

    //Description: Validates the users number, checks if the number given adheres to the restrictions of their source_base
    //Parameters: the users number, and the source_base
    //Return: returns true if the users number adheres to the source, and false otherwise
    public static boolean ValidateInput(Double input_number){
        return false;
    }
}
