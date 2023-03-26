package org.example.trigonometry;

public class Cot extends Tan {
    @Override
    public double calc(double x, double eps){
        return 1.0 / super.calc(x, eps);
    }
}