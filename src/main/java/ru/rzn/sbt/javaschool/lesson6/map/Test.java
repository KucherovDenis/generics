package ru.rzn.sbt.javaschool.lesson6.map;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        // creating a Stream of strings
        Stream<String> s = Stream.of("1", "2", "3", "4");

        // using Collectors toList() function
        List<String> myList = s.collect(Collectors.toList());

        // printing the elements
        System.out.println(myList);
    }
}
