package org.example.trigonometry;

import org.example.Calculable;

public class Tan implements Calculable {
    private final Sin sin;
    private final Cos cos;

    public Tan(){
        this.sin = new Sin();
        this.cos = new Cos();
    }

    public Tan(Sin sin, Cos cos){
        this.sin = sin;
        this.cos = cos;
    }


    public double calc(double x, double eps){
        if (Math.abs(Math.abs(x % Math.PI) - Math.PI/2) < eps && eps < 0.05 ) 
            return Double.NaN;

        return sin.calc(x, eps) / cos.calc(x, eps);
    }
}