package com.moon.stream;

import com.moon.lambda.Product;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Moon on 22/08/2021
 */
public class MyStream {
    public static void main(String[] args) {

        // streamPipeline();

        otherStreamPipeline();

        Stream<String> streamGenerated =
                Stream.generate(() -> "element").limit(10);
        streamGenerated.forEach(System.out::println);

        Stream.iterate(40, n -> n + 2).limit(20).forEach(System.out::println);

        Stream<String> stream =
                Stream.of("a", "b", "c").filter(element -> element.contains("b"));
        Optional<String> anyElement1 = stream.findAny();

        //However, an attempt to reuse the same reference after calling the terminal operation will trigger the IllegalStateException:

        // Optional<String> firstElement1 = stream.findFirst();

        // So to make the previous code work properly, some changes should be made:

        List<String> elements =
                Stream.of("a", "b", "c").filter(element -> element.contains("b"))
                        .collect(Collectors.toList());
        Optional<String> anyElement2 = elements.stream().findAny();
        Optional<String> firstElement2 = elements.stream().findFirst();

    }

    public static Stream<String> streamOf(List<String> list) {
        return list == null || list.isEmpty() ? Stream.empty() : list.stream();
    }

    public static void arraystream() {
        Stream<String> streamOfArray = Stream.of("a", "b", "c");

        //  We can also create a stream out of an existing array or of part of an array:

        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> streamOfArrayFull = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 2);
    }

    public static void otherStreamPipeline(){
        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
       int  counter = 0;

     list.stream()
            .filter(element ->  element.contains("a"))
            .map(element ->  element.toUpperCase())
            .findFirst().stream()
            .forEach(System.out::println);

        List<Product> productList = Arrays.asList(new Product(23, "potatoes"),
                new Product(14, "orange"), new Product(13, "lemon"),
                new Product(23, "bread"), new Product(13, "sugar"));

        Map<Boolean, List<Product>> mapPartioned = productList.stream()
                .collect(Collectors.partitioningBy(element -> element.getPrice() > 15));
        System.out.println(mapPartioned);

    }

    public static void streamPipeline(){
        Stream.of("abcd", "bbcd", "cbcd").skip(1).forEach(System.out::println);

        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        long size = list.stream().skip(1)
                .map(element -> element.substring(0, 3)).sorted().count();

        System.out.println(size);

        list.stream().skip(1)
                .map(element -> element.substring(0, 3)).sorted().forEach(System.out::println);
    }
}
