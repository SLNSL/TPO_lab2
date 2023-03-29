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
        if (Math.abs(Math.abs(x % Math.PI) - Math.PI/2) < eps && eps < 0.05) 
            return Double.NaN;
        
        return 1 / cos.calc(x, eps);
    }
}