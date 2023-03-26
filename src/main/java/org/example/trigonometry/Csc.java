package org.example.trigonometry;

public class Csc {

    private final Sin sin;


    public Csc(){
        this.sin = new Sin();

    }

    public Csc(Sin sin){
        this.sin = sin;
    }

    public double calc(double x, double eps){

        return 1 / sin.calc(x, eps);
    }
}
