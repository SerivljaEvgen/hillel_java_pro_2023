package homework.task_11_lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task_1_5 {

    //1
    private static int countOccurance(List<String> list, String str) {
        int count = 0;
        for (String s : list) {
            if (s.equals(str)) {
                count++;
            }
        }
        return count;
    }

    //2
    private static List<Integer> toList(Integer[] arr) {
        List<Integer> arrList;
        arrList = Arrays.asList(arr);
        return arrList;
    }

    //3
    private static List<Integer> findUnique(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        for (Integer each : list) {
            if (!newList.contains(each)) {
                newList.add(each);
            }
        }
        return newList;
    }

    // 3.1 with String
    private static List<String> findUnique2(List<String> list) {
        List<String> newList = new ArrayList<>();
        for (String each : list) {
            if (!newList.contains(each)) {
                newList.add(each);
            }
        }
        return newList;
    }

    //4
    private static List<String> calcOccurance(List<String> list) {
        List<String> resultList = new ArrayList<>();
        for (String s : list) {
            resultList.add(s + ":" + countOccurance(list, s));
        }
        return findUnique2(resultList);
    }

    //5
    private static List<ClassForTask5> findOccurance(List<String> list) {
        List<ClassForTask5> resultList = new ArrayList<>();
        for (String s : findUnique2(list)) {
            resultList.add(new ClassForTask5(s, countOccurance(list, s)));
        }
        return resultList;
    }

    public static void main(String[] args) {
        //1
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("dog");
        list.add("bird");
        list.add("fish");
        list.add("lion");
        list.add("cat");
        list.add("dog");
        list.add("cat");
        String word = "cat";
        System.out.println("The word: " + word + " occurs " + countOccurance(list, word) + " times");
        System.out.println("---------------------------------");

        //2
        Integer[] arr = {1, 2, 3, 4, 5};
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Array as List: " + toList(arr));
        System.out.println("---------------------------------");

        //3
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(1);
        list2.add(2);
        list2.add(4);

        System.out.println("Basic list: " + list2);
        System.out.println("This list with unique elements: " + findUnique(list2));
        System.out.println("---------------------------------");

        //4
        System.out.println(calcOccurance(list));
        System.out.println("---------------------------------");

        //5
        System.out.println(findOccurance(list));

    }
}

