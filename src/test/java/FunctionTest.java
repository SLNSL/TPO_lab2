import com.opencsv.CSVReader;
import org.example.Calculable;
import org.example.logarithms.Ln;
import org.example.logarithms.Log;
import org.example.trigonometry.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.FileReader;
import java.io.IOException;



public class FunctionTest {

    static double eps = 0.001;
    static Sin sinMock;
    static Cos cosMock;
    static Cot cotMock;
    static Csc cscMock;
    static Sec secMock;
    static Tan tanMock;

    static Ln lnMock;

    static Log logMock;

    static void fillMock(Calculable mock, String filename){
        try {
            FileReader inputs = new FileReader(filename
            );

            CSVReader csvReader = new CSVReader(inputs);
            for (String[] row : csvReader) {
                Mockito.when(mock.calc(Double.parseDouble(row[0]), eps)).thenReturn(Double.parseDouble(row[1]));
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @BeforeAll
    static void createMocks() {
        sinMock = Mockito.mock(Sin.class);
        cosMock = Mockito.mock(Cos.class);
        cotMock = Mockito.mock(Cot.class);
        cscMock = Mockito.mock(Csc.class);
        secMock = Mockito.mock(Sec.class);
        tanMock = Mockito.mock(Tan.class);
        fillMock(sinMock, "src/main/resources/SinInput.csv");
        fillMock(cosMock, "src/main/resources/CosInput.csv");
        fillMock(cotMock, "src/main/resources/CotInput.csv");
        fillMock(cscMock, "src/main/resources/CscInput.csv");
        fillMock(secMock, "src/main/resources/SecInput.csv");
        fillMock(tanMock, "src/main/resources/TanInput.csv");
    }


    @Test
    void checkMock(){
        try {
            FileReader inputs = new FileReader("src/main/resources/FuncInput.csv");

            Calculable s = new Func();
            CSVReader csvReader = new CSVReader(inputs);
            for (String[] row : csvReader) {
                System.out.println(Double.parseDouble(row[0]) + " " + s.calc(Double.parseDouble(row[0]), eps));
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    @ParameterizedTest
//    @CsvFileSource(resources = "FuncInput.csv")
//    void testAllMocks(double x, double expected){
//        Func func = new Func(cotMock, cscMock, secMock, cosMock, tanMock, sinMock, lnMock, logMock);
//    }
}