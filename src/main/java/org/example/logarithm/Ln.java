package org.example.logarithm;

import org.example.Calculable;

public class Ln implements Calculable {
    @Override
    public double calc(double x, double eps) {
        assert eps > 0 : "Epsilon must be greater than zero";
        
        if (x <= 0) return Double.NaN;
        
        double ln = 0;
        double addend;
        double nominator = -1;
        double denominator = 0;
        
        do {
            nominator *= - (x - 1);
            denominator += 1;
            addend = nominator / denominator;
            
            ln += addend;
        }while (Math.abs(addend) > eps);
        
        return ln;
    }
}