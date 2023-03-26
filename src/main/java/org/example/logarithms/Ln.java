package org.example.logarithms;

import org.example.Calculable;

public class Ln implements Calculable {
    @Override
    public double calc(double x, double eps) {
        assert eps > 0 : "Epsilon must be greater than zero";

        if (Double.isNaN(x) || x < 0.0) {
            return Double.NaN;
        } else if (x == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        } else if (x == 0.0) {
            return Double.NEGATIVE_INFINITY;
        }

        double n = ((x - 1) * (x - 1)) / ((x + 1) * (x + 1));
        double addend = (x - 1) / (x + 1);
        double ln = addend;
        int step = 1;
        
        do {
            addend *= (2 * step - 1) * n / (2 * step + 1);
            ln += addend;
            step++;
        }while (Math.abs(addend) > eps / 2.0);
        
        ln *= 2;
        
        return ln;
    }
}