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
        System.out.println("**NOTE any invalid inputs will be disregarded**");
        System.out.println("What is your source base (2: Binary, 10: Decimal, 16: Hexadecimal): ");

        do{
            source_base = sc.nextInt();
        }while(source_base != 2 && source_base != 6 && source_base != 16);
    }
}
