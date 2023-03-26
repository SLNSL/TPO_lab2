package org.example.trigonometry;

public class Cot {

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

    public double calc(double x, double eps){
        return cos.calc(x, eps) / sin.calc(x, eps);
    }
}
