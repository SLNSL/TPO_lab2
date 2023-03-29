package org.example.trigonometry;

import org.example.Calculable;

public class Cot implements Calculable {

    private final Sin sin;
    private final Cos cos;

    public Cot(){
        this.sin = new Sin();
        this.cos = new Cos();
    }

    public Cot(Sin sin, Cos cos){
        this.sin = sin;
        this.cos = cos;
    }


    @Override
    public double calc(double x, double eps){
        if (Math.abs(x % Math.PI) < eps && eps < 0.05) 
            return Double.NaN;
        
        return cos.calc(x, eps) / sin.calc(x, eps);
    }
}