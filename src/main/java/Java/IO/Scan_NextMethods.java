package Java.IO;

import java.util.Scanner;

public class Scan_NextMethods {

    public static void main(String[] args){


        String sampleDate = "25 Dec 1988";

        try (Scanner sDate = new Scanner(sampleDate)) {
            int dayOfMonth = sDate.nextInt();
            String month = sDate.next();
            int year = sDate.nextInt();
            System.out.printf("%d-%s-%02d%n", year, month, dayOfMonth);
        } catch (Exception e){
            System.out.println("Exception occured");
        }

    }
}
