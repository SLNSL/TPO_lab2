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
        
        double minuend = ln.calc(x, eps/2);
        double subtrahend = ln.calc(base, eps/2);
        
        if (!Double.isFinite(minuend) || !Double.isFinite(subtrahend)){
            return Double.NaN;
        }
        
        return minuend - subtrahend;
    }
}