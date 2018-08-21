import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;


public class AnagramFinder {
    static int makeAnagram(String a, String b) {

        List<Character> charList1 = a.chars().mapToObj(c -> (char)c).collect(Collectors.toList());
        List<Character> charList2 =  b.chars().mapToObj(c -> (char)c).collect(Collectors.toList());

        Map <Character,Long> map1 = charList1.stream().collect(groupingBy(Function.identity(),counting()));
        Map <Character,Long> map2 = charList2.stream().collect(groupingBy(Function.identity(),counting()));

        Map<Character, Long> resultMap  = Stream.concat(map1.entrySet().stream(),map2.entrySet().stream()).collect(toMap(entry -> entry.getKey(),entry -> entry.getValue(),(v1, v2) -> Math.abs(v1-v2),HashMap::new)
        );




        long tobeDeleted  = resultMap.values().stream().collect(Collectors.summingLong( i -> i));

        return (int)tobeDeleted;
    }

    public static void main(String[] args) throws IOException {

        int res = new AnagramFinder().makeAnagram("showman", "woman");
        System.out.print(res);

    }
}
