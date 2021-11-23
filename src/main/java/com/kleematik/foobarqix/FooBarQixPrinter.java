package com.kleematik.foobarqix;

public class FooBarQixPrinter {
    public static String printNumberBetweenOneToCount(int count) {
        final StringBuilder result = new StringBuilder();
        for (int number = 1; number <= count; number++) {
            result.append(FooBarQix.convert(number)).append(" ");
        }
        return result.toString();
    }
}
