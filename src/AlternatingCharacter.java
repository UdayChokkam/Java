
import java.io.*;
import java.util.*;
public class AlternatingCharacter {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {

        char[] arr = s.toCharArray();
        int count = 0;
        for(int i = 0 ; i < arr.length-1; i ++){
            if(arr[i] == arr[i+1]){
                count++;
            }
        }

        return count;


    }



    public static void main(String[] args) throws IOException {


            int result = alternatingCharacters("ABBABBAA");
            System.out.print(result);

    }
}
