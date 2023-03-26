import org.example.Calculable;
import org.example.logarithms.Ln;
import org.example.logarithms.Log;
import org.example.trigonometry.*;

public class Func implements Calculable {

    Cot cot;
    Csc csc;
    Sec sec;
    Cos cos;
    Tan tan;
    Sin sin;
    Ln ln;
    Log log;

    public Func(){
        cot = new Cot();
        csc = new Csc();
        sec = new Sec();
        cos = new Cos();
        tan = new Tan();
        sin = new Sin();
        ln = new Ln();
        log = new Log();
    }

    public Func(Cot cot, Csc csc, Sec sec, Cos cos, Tan tan, Sin sin, Ln ln, Log log){
        this.cot = cot;
        this.csc = csc;
        this.sec = sec;
        this.cos = cos;
        this.tan = tan;
        this.sin = sin;
        this.ln = ln;
        this.log = log;
    }


    public double calc(double x, double eps){
        if (!Double.isFinite(x)) return Double.NaN;
        
        if (x <= 0){
            return ((Math.pow((((((cot.calc(x, eps) * csc.calc(x, eps)) * sec.calc(x, eps)) + cos.calc(x, eps)) +
                    (sec.calc(x, eps) / tan.calc(x, eps))) -
                    ((((cos.calc(x, eps) * sec.calc(x, eps)) - sec.calc(x, eps)) - cos.calc(x, eps)) -
                    (tan.calc(x, eps) * sin.calc(x, eps)))), 3) + ((sin.calc(x, eps) - (csc.calc(x, eps) / tan.calc(x, eps))) -
                    (((sin.calc(x, eps) * cot.calc(x, eps)) + cos.calc(x, eps))
                            + (((sin.calc(x, eps) + sec.calc(x, eps)) + csc.calc(x, eps)) /
                            Math.pow(tan.calc(x, eps), 3))))) * csc.calc(x, eps));
        } else {
            return Math.pow((
                    ((ln.calc(x, eps) - log.calc(x, eps)) + (ln.calc(x, eps) / log.calc(5, x, eps)))
                    / (ln.calc(x, eps) + log.calc(3, x, eps))
            ), 2.0) * log.calc(2, x, eps);
        }
    }


}