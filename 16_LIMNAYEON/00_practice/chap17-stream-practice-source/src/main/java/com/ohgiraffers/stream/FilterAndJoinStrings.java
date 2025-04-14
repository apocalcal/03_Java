package com.ohgiraffers.stream;

import java.util.List;
import java.util.stream.Collectors;

public class FilterAndJoinStrings {


    public static void main(String[] args) {
        List<String> words = List.of("hi", "hello", "to", "world", "java");
        // 출력값
        // hello, world, java

        String joining = words.stream()
                .filter(s -> s.length() >= 3)
                .collect(Collectors.joining(", "));
        System.out.println(joining);

    }

        // 문제: 길이가 3 이상인 문자열만 골라 쉼표로 연결하여 출력하세요.
}
