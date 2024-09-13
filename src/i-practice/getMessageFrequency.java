// Online Java Compiler
// Use this editor to write, compile and run your Java code online


/*
[word, xPerson, yPerson, x->y word frequency, y->x frequency]
[bye, Adam, Bob, 1, 2] (Adam said "bye" word to Bob 1 (once) and Bob taled to Adam "bye" twice)
[hello, Adam, Carl, 3, 1]
[see, Carl, Bob, 2, 4]
...

input = [bye, Adam, Bob]
output = [1, 2]

*/

import java.util.*;

class HelloWorld {
    
    static List<String> getMessageFrequency(List<List<String>> inputList, String word, String x, String y) {
        // insert input List data in HashMap
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> list : inputList) {
                String key = list.get(0) + list.get(1) + list.get(2);
                List<String> valueList = new ArrayList<>();
                valueList.add(list.get(3));
                valueList.add(list.get(4));
                map.put(key, valueList);
        }
        return map.get(word + x + y);
    }
    
    public static void main(String[] args) {
        System.out.println("Let's Start...!");
        // insert input data in input List
        List<List<String>> inputList = new ArrayList<>();
        List<String> innerList1 = new ArrayList<>();
        innerList1.add("bye");
        innerList1.add("Adam");
        innerList1.add("Bob");
        innerList1.add("1");
        innerList1.add("2");
        inputList.add(innerList1);

        List<String> innerList2 = new ArrayList<>();
        innerList2.add("hello");
        innerList2.add("Adam");
        innerList2.add("Carl");
        innerList2.add("3");
        innerList2.add("1");
        inputList.add(innerList2);

        List<String> innerList3 = new ArrayList<>();
        innerList3.add("see");
        innerList3.add("Carl");
        innerList3.add("Bob");
        innerList3.add("2");
        innerList3.add("4");
        inputList.add(innerList3);
        // call fun

//        String word = "bye";
//        String x = "Adam";
//        String y = "Bob";
        
        String word = "see";
        String x = "Carl";
        String y = "Bob";
        
        List<String> result = getMessageFrequency(inputList, word, x, y);
        // Print
        System.out.println(result);
    }
}
