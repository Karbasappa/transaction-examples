package com.sabtok.transaction_examples.stream_examples;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StreamExample1 {

    public static void main(String[] args) {

        List<String> words = List.of("apple", "banana", "kiwi", "mango");
        Map<String, Long> result = words.stream().filter(str -> str.length() > 4).collect(Collectors.toMap(a -> a,
                b-> Long.valueOf(b.length()),
                (c,d) -> c,
                LinkedHashMap::new
        ));

        System.out.println(result);

        List<String> longWords = words.stream()
                .collect(
                        ArrayList::new,                             // 1. Supplier: Creates an empty container list
                        (list, str) -> {                            // 2. Accumulator: Custom filtering rule
                            if (str.length() > 4) {
                                list.add(str.toUpperCase());
                            }
                        },
                        ArrayList::addAll                           // 3. Combiner: Merges two lists together
                );

        System.out.println(longWords);

    }
}
