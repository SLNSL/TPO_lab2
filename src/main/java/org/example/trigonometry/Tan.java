package org.example.trigonometry;

public class Tan {
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

        return sin.calc(x, eps) / cos.calc(x, eps);
    }
}
