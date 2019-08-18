package Java.IO;

import java.io.Console;
import java.util.Arrays;

/*
When you run an application from a “terminal window” or “command prompt window” on most systems,
its console and its standard input are both connected to the terminal, by default. However, the
standard input can be changed by piping or redirection on most OSes.
If you really want to read from “wherever the user is sitting”, bypassing any indirections,
then the Console class is usually your friend.
 */
//TODO Check how to connect to console in intellij later
public class Read_Standard_Console {

    public static void main (String[] args){

        readCredentials();
    }

    private static void readCredentials(){
        char[] password = null;
        try {
            Console sc = System.console();
            // Console can be null if not connected to standard console
            if (sc != null) {
                sc.readLine("Username :");
                password = sc.readPassword("Password :");
            }
        } catch (Exception e){
            System.out.println("Exception occured in Read_Standard_Console");
        }
        finally {
            if(null != password) {
                Arrays.fill(password, ' ');
            }
        }
    }

}
