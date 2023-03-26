package org.example.trigonometry;

import org.example.Calculable;

public class Sec implements Calculable {

    private final Cos cos;


    public Sec(){
        this.cos = new Cos();
    }

    public Sec(Cos cos){
        this.cos = cos;
    }

    public double calc(double x, double eps){

        return 1 / cos.calc(x, eps);
    }
}