package Java.IO;

import java.io.PrintWriter;

//TODO why is the print writer not printing anything to the console
public class Read_Std_Out_Err {

    public static void main(String[] args){

        readStdOutErr();

    }

    private static void readStdOutErr(){

        // so far we   have used streams , even writer can be used as well to print unicode
        PrintWriter pw = new PrintWriter(System.out);
        pw.println("I dont know what iam printing");

        // Need to use use String builder if  needs to print i + '=' + " the answer" as it can print 103 the answer
    }
}
