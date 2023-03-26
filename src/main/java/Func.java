import org.example.Calculable;
import org.example.trigonometry.*;

public class Func implements Calculable {

    Cot cot;
    Csc csc;
    Sec sec;
    Cos cos;
    Tan tan;

    Sin sin;

    public Func(){
        cot = new Cot();
        csc = new Csc();
        sec = new Sec();
        cos = new Cos();
        tan = new Tan();
        sin = new Sin();
    }

    public Func(Cot cot, Csc csc, Sec sec, Cos cos, Tan tan, Sin sin){
        this.cot = cot;
        this.csc = csc;
        this.sec = sec;
        this.cos = cos;
        this.tan = tan;
        this.sin = sin;
    }


    public double calc(double x, double eps){
        if (x <= 0){
            return ((Math.pow((((((cot.calc(x, eps) * csc.calc(x, eps)) * sec.calc(x, eps)) + cos.calc(x, eps)) +
                    (sec.calc(x, eps) / tan.calc(x, eps))) -
                    ((((cos.calc(x, eps) * sec.calc(x, eps)) - sec.calc(x, eps)) - cos.calc(x, eps)) -
                    (tan.calc(x, eps) * sin.calc(x, eps)))), 3) + ((sin.calc(x, eps) - (csc.calc(x, eps) / tan.calc(x, eps))) -
                    (((sin.calc(x, eps) * cot.calc(x, eps)) + cos.calc(x, eps))
                            + (((sin.calc(x, eps) + sec.calc(x, eps)) + csc.calc(x, eps)) /
                            Math.pow(tan.calc(x, eps), 3))))) * csc.calc(x, eps));
        } else {
            return 12345;
        }
    }


}