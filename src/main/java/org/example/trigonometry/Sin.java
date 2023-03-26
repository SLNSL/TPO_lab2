package org.example.trigonometry;

import org.example.Calculable;

public class Sin implements Calculable {
    
    public double calc(double x, double eps){

        double fact = 1, prev_res = 1, result = 0;
        int sign = 1, cnt = 1;

        if (x >= 0) {
            while (x > Math.PI * 2) {
                x -= Math.PI * 2;
            }
        } else if (x < 0) {
            while (x < Math.PI * 2) {
                x += Math.PI * 2;
            }
        }

        double xx = x * x;
        double pow = x;


        while (Math.abs(prev_res - result) > eps) {
            fact /= cnt;
            prev_res = result;
            result += sign * pow * fact;
            sign = -sign;
            fact /= (cnt + 1);
            pow *= xx;
            cnt += 2;
        }

        if (Math.abs(result) > 1) return Double.NaN;
        if (Math.abs(result) < eps) return 0;
        return result;

    }
}