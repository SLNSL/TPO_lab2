package unit_tests;

import org.example.logarithms.Ln;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LnTest {
    
    private static Ln ln;
    
    @BeforeAll
    public static void doBefore(){
        ln = new Ln();
    }
    
    @ParameterizedTest
    @CsvSource({
            "0, -Infinity",
            "1, 0",
            "2, 0.69",
            "3, 1.099"
    })
    public void testLn(double x, double y){
        Assertions.assertEquals(y, ln.calc(x, 0.01), 0.01);
    }
}