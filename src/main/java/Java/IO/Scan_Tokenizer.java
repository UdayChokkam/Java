package Java.IO;

import java.io.*;
import java.util.StringTokenizer;

public class Scan_Tokenizer {

    protected static LineNumberReader is;

    public static void main(String[] args){

        // This is just to check  that int is -1 when reached to the end
       // readCharOneAtTime();
        read(args);



    }

    private static void read(String[] av){
        try {
            if (av.length == 0)
                new Scan_Tokenizer(
                        new InputStreamReader(System.in)).process();
            else
                for (int i = 0; i < av.length; i++)
                    new Scan_Tokenizer(av[i]).process();
        } catch(Exception e){
            System.out.println("Exception occured");
        }
    }

    /** Construct a file scanner by name */
    public Scan_Tokenizer(String fileName) throws IOException {
        is = new LineNumberReader(new FileReader(fileName));
    }

    /** Construct a file scanner by existing Reader */
    public Scan_Tokenizer(Reader rdr) throws IOException {
        // no point adding another level of buffering, if already
        // being buffered...
        if (rdr instanceof LineNumberReader)
            is = (LineNumberReader)rdr;
        else
            is = new LineNumberReader(rdr);
    }

    // The below  is not efficient
    private static void readCharOneAtTime() {
        Reader is = new BufferedReader(new InputStreamReader(System.in));
        int c;
        while (true) {
            try {
                if (!((c=is.read( )) != -1)) break;
                System.out.print((char)c);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private static void process (){
        String s;
            try {
                while  ((s =is.readLine()) != null){
                    StringTokenizer st = new StringTokenizer(s, "@", true);
                    String  user  = (String)st.nextElement();
                    st.nextElement();
                    String host = (String)st.nextElement();
                    System.out.println("user name is "+ user);
                    System.out.println("Host is "+ host);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
}
