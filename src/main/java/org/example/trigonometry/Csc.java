package org.example.trigonometry;

import org.example.Calculable;

public class Csc implements Calculable {

    private final Sin sin;


    public Csc(){
        this.sin = new Sin();
    }

    public Csc(Sin sin){
        this.sin = sin;
    }

    public double calc(double x, double eps){
        if (Math.abs(x % Math.PI) < eps && eps < 0.05) 
            return Double.NaN;
        
        return 1 / sin.calc(x, eps);
    }
}