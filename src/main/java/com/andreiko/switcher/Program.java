package com.andreiko.switcher;

import java.util.Arrays;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        List<String> list1 = Arrays.asList("a1", "a2", "a3", "a1");
        List<String> list2 = Arrays.asList("");

        long count = list1.stream()
                .filter(el -> el.equals("a1"))
                .count();
        System.out.println(count);

        String firstElement = list1.stream().findFirst().get();
        System.out.println(firstElement);

        String firstElement1 = list2.stream().findFirst().get();
        System.out.println(firstElement1);




        Lamp lamp = new Lamp();
        Switcher switcher = new Switcher();

        switcher.addConsumer(() -> System.out.println("Light is on"));
        switcher.addConsumer(lamp);
        switcher.switchOn();




    }
}
