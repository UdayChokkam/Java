package Java.IO;

import java.io.*;

public class FileOpening {

    public static void main(String[] args){

        try {
            // To read and write character stream
            BufferedReader br = new BufferedReader(new FileReader("/uday/sample.txt" ));
            BufferedWriter bw = new BufferedWriter(new FileWriter("/uday/sample.txt"));

            // To read and write byte stream
            BufferedInputStream bi = new BufferedInputStream(new FileInputStream("/uday/sample.txt"));
            BufferedOutputStream bo = new BufferedOutputStream((new FileOutputStream("/uday/sample.txt")));
        } catch (Exception e) {
           System.out.println("Exception occured");
        }

    }
}
