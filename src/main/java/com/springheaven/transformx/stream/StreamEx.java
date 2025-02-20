package com.springheaven.transformx.stream;

import java.util.List;

public class StreamEx {

    public static void main(String[] args) {
        List<String> emailList = List.of("iampraveen13@gmail.com", "impraveenraj13@gmail.com",
                "dharshini.jc@gmail.com", "vasanthi@gmail.com");

        emailList.stream().filter(emails-> emails.contains("raj")).forEach(System.out::println);
    }
}
