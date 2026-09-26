import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamsUsage {

    @Test
    public void regular() {

        List<String> list = Arrays.asList(
                "Abhijeet",
                "Don",
                "Adam",
                "Manand",
                "Alexiya",
                "Alex"
        );

        int count = 0;

        for (String str : list) {
            if (str.startsWith("A")) {
                count++;
            }
        }

        System.out.println("Count: " + count);
    }

    @Test
    public void streamFilter() {

        List<String> list = Arrays.asList(
                "Abhijeet",
                "Don",
                "Adam",
                "Mananda",
                "Alexiya",
                "Alex"
        );

        long count = list.stream()
                .filter(s -> s.startsWith("A"))
                .count();

        System.out.println("Count: " + count);

        // Print names with length >= 4 and only 3 results
        System.out.println("Printing 3 names with length >= 4:");

        list.stream()
                .filter(s -> s.length() >= 4)
                .limit(3)
                .forEach(System.out::println);
    }

    @Test
    public void streamMap() {

        // Print names ending with 'a',
        // convert them to uppercase and sort them

        System.out.println(
                "Sorting and printing names ending with 'a' in uppercase:"
        );

        Stream.of(
                        "Abhijeet",
                        "Don",
                        "Adam",
                        "Mananda",
                        "Alexiya"
                )
                .filter(s -> s.endsWith("a"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    public void streamMap2() {

        List<String> list1 = Arrays.asList(
                "Abhijeet",
                "Don",
                "Adam",
                "Mananda"
        );

        List<String> list2 = Arrays.asList(
                "Monu",
                "Sonu",
                "Tony",
                "Tetto"
        );

        // Combine two lists and sort
        Stream<String> combined =
                Stream.concat(list1.stream(), list2.stream())
                        .sorted();

        System.out.println(
                "Printing combined stream by concatenating list1 and list2:"
        );

        combined.forEach(System.out::println);

        // A stream can only be consumed once,
        // so create a new stream for anyMatch()

        boolean flag = Stream.concat(list1.stream(), list2.stream())
                .anyMatch(s -> s.equalsIgnoreCase("Adam"));

        System.out.println("Adam found: " + flag);

        Assert.assertTrue(flag);
    }

    @Test
    public void streamCollect() {

        List<String> ls = Stream.of(
                        "Abhijeet",
                        "Don",
                        "Adam",
                        "Mananda"
                )
                .filter(s -> s.startsWith("A"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        for (String s : ls) {
            System.out.println(s);
        }
    }
}