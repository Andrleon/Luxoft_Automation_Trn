package com.andreiko.switcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) {

        List<String> list1 = Arrays.asList("a1", "a2", "a10", "a7", "a1");
        List<String> list2 = new ArrayList<>();
        long count;
        String firstElement;
        String lasrElement;
        String element;

        count = getCountOfElement(list1, "a1");
        System.out.println(count);
        count = getCountOfElement(list1, "a2");
        System.out.println(count);
        count = getCountOfElement(list1, "a0");
        System.out.println(count);

        firstElement = getFirstElement(list1);
        System.out.println(firstElement);
        firstElement = getFirstElement(list2);
        System.out.println(firstElement);

        lasrElement = getLastElement(list1);
        System.out.println("Last element " + lasrElement);
        lasrElement = getLastElement(list2);
        System.out.println(lasrElement);

        element = getElementOrTrowException(list1, "a1");
        System.out.println(element);
        element = getElementOrTrowException(list1, "a7");
        System.out.println(element);
//        element = getElementOrTrowException(list1, "a19");
//        System.out.println(element);

        System.out.println("-------------------");
        list1.stream().skip(2).limit(1).forEach(System.out::println);
        list2.stream().skip(2).limit(1).forEach(System.out::println);
        List<String> list3 = list1.stream()
                .skip(1)
                .limit(2)
                .collect(Collectors.toList());





        /*Lamp lamp = new Lamp();
        Switcher switcher = new Switcher();

        switcher.addConsumer(() -> System.out.println("Light is on"));
        switcher.addConsumer(lamp);
        switcher.switchOn();
*/

    }

    private static String getElementOrTrowException(List<String> list, String str) {
        return list.stream()
                .filter(x -> x.equals(str))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    private static String getLastElement(List<String> list) {
        return list.stream()
                .skip((list.size() == 0) ? 0 : list.size() - 1)
                .findFirst()
                .orElse("empy");
    }

    public static long getCountOfElement(List<String> list, String str) {
        return list.stream()
                .filter(el -> el.equals(str))
                .count();
    }

    public static String getFirstElement(List<String> list){
        return list.stream()
                .findFirst()
                .orElse("0");
    }


}
