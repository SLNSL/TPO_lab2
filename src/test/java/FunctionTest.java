import com.opencsv.CSVReader;
import org.example.Calculable;
import org.example.logarithms.Ln;
import org.example.logarithms.Log;
import org.example.trigonometry.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FunctionTest {

    static double eps = 0.01;
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



    void checkMock(){
        try {
            FileReader inputs = new FileReader("src/main/resources/FuncInput.csv");

            Calculable s = new Func();
            CSVReader csvReader = new CSVReader(inputs);
            for (String[] row : csvReader) {
                System.out.println(Double.parseDouble(row[0]) + ", " + s.calc(Double.parseDouble(row[0]), eps));
            }



        } catch (IOException e) {
            e.printStackTrace();
        }



    }


    @ParameterizedTest
    @CsvFileSource(resources = "FuncInput.csv")
    void testAllMocks(double x, double expected){
        Func func = new Func(cotMock, cscMock, secMock, cosMock, tanMock, sinMock, lnMock, logMock);
        assertEquals(expected, func.calc(x, eps), eps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "FuncInput.csv")
    void testOneDependency(double x, double expected){
        Func func = new Func(new Cot(sinMock, cosMock), new Csc(sinMock), new Sec(cosMock), cosMock, new Tan(sinMock, cosMock), sinMock, lnMock, logMock);
        assertEquals(expected, func.calc(x, eps), eps);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "FuncInput.csv")
    void testTwoDependency(double x, double expected){
        Func func = new Func(new Cot(sinMock, new Cos(sinMock)), new Csc(sinMock), new Sec(new Cos(sinMock)), new Cos(sinMock), new Tan(sinMock, new Cos(sinMock)), sinMock, lnMock, logMock);
        assertEquals(expected, func.calc(x, eps), eps);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "FuncInput.csv")
    void testThreeDependency(double x, double expected){
        Func func = new Func(new Cot(new Sin(), new Cos(new Sin())), new Csc(new Sin()), new Sec(new Cos(new Sin())), new Cos(new Sin()), new Tan(new Sin(), new Cos(new Sin())), new Sin(), lnMock, logMock);
        assertEquals(expected, func.calc(x, eps), eps);
    }
}