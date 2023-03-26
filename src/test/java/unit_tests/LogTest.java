package unit_tests;

import org.example.logarithms.Log;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LogTest {
    private static Log log;

    @BeforeAll
    public static void doBefore(){
        log = new Log();
    }

    @ParameterizedTest
    @CsvSource({
            "e, 0, -Infinity",
            "e, 1, 0",
            "e, 2, 0.69",
            "e, 3, 1.099"
    })
    public void testLog(double base, double x, double y){
        Assertions.assertEquals(y, log.calc(base, x, 0.01), 0.01);
    }
}