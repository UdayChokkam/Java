package Java.IO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Read_Standard_Input {

    public static void main (String[] args){

        readByte();
        readKnownType();
        readAll();

    }

    // This is same as printing the decimal value for a given character (1 byte read)
    private static void readByte() {
        try {
            System.out.println("Enter a character to get its ASCII value ");
            int a = System.in.read();
            System.out.println("Read :"+ a);
        } catch (Exception e) {
           System.out.println("Exception occured in readByte");
        }
    }


    private static void readKnownType() {
        try {
            System.out.println("Enter an integer ");
            Scanner sc = new Scanner(System.in);
            System.out.println("Read :"+ sc.nextInt());
        } catch (Exception e) {
            System.out.println("Exception occured in readKnownType");
        }
    }

    private static void readAll() {
        try {

           BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
           String line;
           while((line = br.readLine()) != null) {
               System.out.println(line);
           }
           br.close();

        } catch (Exception e) {
            System.out.println("Exception occured in readAll");
        }
    }
}
