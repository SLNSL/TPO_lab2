package org.example.logarithms;

import org.example.Calculable;

public class Log implements Calculable {
    
    private final Ln ln;
    
    public Log(Ln ln){
        this.ln = ln;
    }
    
    public Log(){
        ln = new Ln();
    }

    @Override
    public double calc(double x, double eps) {
        return calc(10, x, eps);
    }

    public double calc(double base, double x, double eps) {
        if (base <= 0 || base == 1){
            return Double.NaN;
        } 
        
        double nominator = ln.calc(x, eps / 2.0);
        double denominator = ln.calc(base, eps / 2.0);

        return nominator / denominator;
    }
}