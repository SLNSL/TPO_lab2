package org.example.logarithms;

public class Log extends Ln{

    @Override
    public double calc(double x, double eps) {
        return calc(10, x, eps);
    }

    public double calc(double base, double x, double eps) {
        if (base <= 0 || base == 1){
            return Double.NaN;
        } 
        
        double minuend = super.calc(x, eps/2);
        double subtrahend = super.calc(base, eps/2);
        
        if (!Double.isFinite(minuend) || !Double.isFinite(subtrahend)){
            return Double.NaN;
        }
        
        return minuend - subtrahend;
    }
}