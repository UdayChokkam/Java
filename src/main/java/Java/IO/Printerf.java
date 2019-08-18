package Java.IO;

import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;

public class Printerf {

    public static void main(String[] args) {

        printWithFormat();
    }

    private static void printWithFormat(){

        Formatter fmtr = new Formatter();
        Object result = fmtr.format("%1$4d - the year of %2$f", 1956, Math.PI);
        System.out.println(result);

        // Shorter way using static String.format(), and
        // default parameter numbering.
        Object stringResult = String.format("%4d - the year of %f", 1956, Math.PI);
        System.out.println(stringResult);

        // A shorter way using PrintStream/PrintWriter.format, more in line with
        // other languages. But this way you must provide the newline delimiter
        // using %n (do NOT use \n as that is platform-dependant!).
        System.out.printf("%4d - the year of %f%n", 1956, Math.PI);

        // Format doubles with more control
        System.out.printf("PI is approximately %4.2f%n", Math.PI);

        // Format number as dates e.g., 2014-06-28
        System.out.printf("%4d-%02d-%2d%n", 2014, 6, 28);

        // Format fields directly from a Date object: multiple fields from "1$"
        // (hard-coded formatting for Date not advisable; see I18N chapter)
        Date today = Calendar.getInstance().getTime();
        System.out.printf("Today is %1$tB %1$td, %1$tY%n", today);    // e.g., July 4, 2014

    }
}
