package com.kleematik.foobarqix;

public class FooBarQix {
    private static final String FOO = "Foo";
    private static final String BAR = "Bar";
    private static final String QIX = "Qix";
    private static final String FOO_BAR = "FooBar";

    public static String convert(int number) {

        final String value = String.valueOf(number);

        if (!(isNumberDivisible(number) || isNumberContaining(value))) {
            return String.valueOf(number);
        }

        final StringBuilder result = new StringBuilder();
        handleDivisionCase(result, number);
        handleContainsCase(result, value);
        return result.toString();
    }

    private static void handleDivisionCase(StringBuilder result, int number) {
        if (isDivisibleBy3(number) && isDivisibleBy5(number)) {
            addFooBar(result);
        } else if (isDivisibleBy3(number)) {
            addFoo(result);
        } else if (isDivisibleBy5(number)) {
            addBar(result);
        }
    }

    private static void handleContainsCase(StringBuilder result, String value) {
        final String[] valueSplitted = value.split("");

        for (String singleValue : valueSplitted) {

            if (isContains3(singleValue)) {
                addFoo(result);
            }

            if (isContains5(singleValue)) {
                addBar(result);
            }

            if (isContains7(singleValue)) {
                addQix(result);
            }
        }
    }

    private static boolean isNumberContaining(String value) {
        return isContains3(value) || isContains5(value) || isContains7(value);
    }

    private static boolean isNumberDivisible(int number) {
        return isDivisibleBy3(number) || isDivisibleBy5(number);
    }

    private static boolean isContains3(String value) {
        return isContains(value, "3");
    }

    private static boolean isContains5(String value) {
        return isContains(value, "5");
    }

    private static boolean isContains7(String value) {
        return isContains(value, "7");
    }

    private static boolean isContains(String string, String value) {
        return string.contains(value);
    }

    private static void addFooBar(StringBuilder result) {
        addValue(result, FOO_BAR);
    }

    private static void addQix(StringBuilder result) {
        addValue(result, QIX);
    }

    private static void addBar(StringBuilder result) {
        addValue(result, BAR);
    }

    private static void addFoo(StringBuilder result) {
        addValue(result, FOO);
    }

    private static void addValue(StringBuilder result, String value) {
        result.append(value);
    }

    private static boolean isDivisibleBy5(int number) {
        return number % 5 == 0;
    }

    private static boolean isDivisibleBy3(int number) {
        return number % 3 == 0;
    }
}
