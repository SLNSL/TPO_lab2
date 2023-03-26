package org.example;

import org.example.trigonometry.Cot;

public class Main {
    public static void main(String[] args) {

        Cot cot = new Cot();
        System.out.println(cot.calc(Math.PI, 0.1));
    }
}