import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Sherlock {

    // Complete the isValid function below.
    static String isValid(String s) {

        Map<Character, Long> map = s.chars().mapToObj(i -> (char)i).collect(groupingBy(Function.identity(), counting()));
        List<Long> values = new ArrayList<>(map.values());
        boolean ss = values.stream().allMatch(e -> values.get(0) == e);
        long min  = values.stream().min(Comparator.comparing(Long::valueOf)).get();
        values.stream().filter(value -> values.get(0) < value);



       String x = "YES";
       /*boolean excusedOnce = false;
       for(int i  = 0 ; i < list.size()-1;i++){
           long previous = list.get(i);
           long after = list.get(i+1);
           if(previous == after){
               continue;
           } else{
               if(!excusedOnce){
                   x =  Math.abs(previous - after) == 1 ? "YES" : "NO";
                   if(x.equalsIgnoreCase("yes")){
                       excusedOnce = true;
                   } else {
                       break;
                   }

               } else {
                   x = "NO";
                   break;
               }

           }
       }*/

       return x;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        String result = isValid("aabbcd");
        System.out.print(result);


    }
}