package com.springheaven.transformx.main;

import java.util.function.Supplier;


public class StreamMain {

    public static void main(String[] args) {
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "";
            }
        };

    }

    static class MySupplier implements Supplier<String> {

        @Override
        public String get() {
            return "Hello World";
        }
    }

}
