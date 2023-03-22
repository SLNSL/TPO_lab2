package org.example;

public class Main {
    public static void main(String[] args) {
        Double value = 3.14159265;
        System.out.println(value.toString()); //outputs 3.14159265
        value = Math.sin(value);
        System.out.println(value.toString()); //outputs NaN
    }
}