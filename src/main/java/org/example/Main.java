package org.example;

import org.example.trigonometry.Sin;

public class Main {
    public static void main(String[] args) {

        Sin sin = new Sin();
        System.out.println(sin.calc(-3.1415926, 0.1));
    }
}