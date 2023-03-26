import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionTest {


    @ParameterizedTest
    @ValueSource(doubles = {0, Math.PI, -Math.PI, -10 * Math.PI})
    public void testPi(double x){

    }
}
