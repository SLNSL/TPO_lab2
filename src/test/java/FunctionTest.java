import com.opencsv.CSVReader;
import org.example.Calculable;
import org.example.Func;
import org.example.logarithms.Ln;
import org.example.logarithms.Log;
import org.example.trigonometry.*;
import org.example.csv.CSVPrint;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;


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

    static CSVPrint print;

    static void fillMock(Calculable mock, String filename){
        try {
            FileReader inputs = new FileReader(filename);
            CSVReader csvReader = new CSVReader(inputs);
            
            for (String[] row : csvReader) {
                Mockito.when(mock.calc(Double.parseDouble(row[0]), eps))
                        .thenReturn(Double.parseDouble(row[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    static void fillMockForLog(Log mock, String filename){
        try {
            FileReader inputs = new FileReader(filename);
            CSVReader csvReader = new CSVReader(inputs);

            for (String[] row : csvReader) {
                Mockito.when(mock.calc(Double.parseDouble(row[0]), Double.parseDouble(row[1]), eps))
                        .thenReturn(Double.parseDouble(row[2]));

                if(Objects.equals(row[0], "10")){
                    Mockito.when(mock.calc(Double.parseDouble(row[1]), eps))
                            .thenReturn(Double.parseDouble(row[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @BeforeAll
    static void createMocks() throws FileNotFoundException {
        sinMock = Mockito.mock(Sin.class);
        cosMock = Mockito.mock(Cos.class);
        cotMock = Mockito.mock(Cot.class);
        cscMock = Mockito.mock(Csc.class);
        secMock = Mockito.mock(Sec.class);
        tanMock = Mockito.mock(Tan.class);
        lnMock = Mockito.mock(Ln.class);
        logMock = Mockito.mock(Log.class);
        print = new CSVPrint();
        
        fillMock(sinMock, "src/main/resources/trigonometry/SinInput.csv");
        fillMock(cosMock, "src/main/resources/trigonometry/CosInput.csv");
        fillMock(cotMock, "src/main/resources/trigonometry/CotInput.csv");
        fillMock(cscMock, "src/main/resources/trigonometry/CscInput.csv");
        fillMock(secMock, "src/main/resources/trigonometry/SecInput.csv");
        fillMock(tanMock, "src/main/resources/trigonometry/TanInput.csv");
        fillMock(lnMock, "src/main/resources/logarithms/LnInput.csv");
        fillMockForLog(logMock, "src/main/resources/logarithms/LogInput.csv");
    }


@Test
    void checkMock(){
        try {
            FileReader inputs = new FileReader("src/main/resources/FuncInput.csv");
            Func s = new Func();
            CSVReader csvReader = new CSVReader(inputs);
            
            for (String[] row : csvReader) {
                System.out.println(Double.parseDouble(row[0]) + ", "  + s.calc( Double.parseDouble(row[0]), eps));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @ParameterizedTest
    @CsvFileSource(resources = "FuncInput.csv")
    void testAllMocks(double x, double expected) throws FileNotFoundException {
        Func func = new Func(cotMock, cscMock, secMock, cosMock, tanMock, sinMock, lnMock, logMock);
        double ans = func.calc(x, eps);
        assertEquals(expected, ans, 0.01);
        print.csvPrint(x, ans, "src/main/resources/output.csv");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "FuncInput.csv")
    void testZeroMocks(double x, double expected) throws FileNotFoundException{
        Func func = new Func(
                new Cot(new Sin(), new Cos()),
                new Csc(new Sin()),
                new Sec(new Cos()),
                new Cos(),
                new Tan(new Sin(), new Cos()),
                new Sin(),
                new Ln(),
                new Log(new Ln()));
        double ans = func.calc(x, eps);
        assertEquals(expected, ans, 0.01);
        print.csvPrint(x, ans, "src/main/resources/output.csv");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "FuncInput.csv")
    void testOneDependency(double x, double expected) throws FileNotFoundException{
        Func func = new Func(new Cot(sinMock, cosMock), new Csc(sinMock), new Sec(cosMock), cosMock, new Tan(sinMock, cosMock), sinMock, lnMock, logMock);
        double ans = func.calc(x, eps);
        assertEquals(expected, ans, 0.01);

        print.csvPrint(x, ans, "src/main/resources/output.csv");
    }
    @ParameterizedTest
    @CsvFileSource(resources = "FuncInput.csv")
    void testTwoDependency(double x, double expected) throws FileNotFoundException{
        Func func = new Func(new Cot(sinMock, new Cos(sinMock)), new Csc(sinMock), new Sec(new Cos(sinMock)), new Cos(sinMock), new Tan(sinMock, new Cos(sinMock)), sinMock, lnMock, logMock);
        double ans = func.calc(x, eps);
        assertEquals(expected, ans, 0.01);

        print.csvPrint(x, ans, "src/main/resources/output.csv");
    }
    @ParameterizedTest
    @CsvFileSource(resources = "FuncInput.csv")
    void testThreeDependency(double x, double expected) throws FileNotFoundException{
        Func func = new Func(new Cot(new Sin(), new Cos(new Sin())), new Csc(new Sin()), new Sec(new Cos(new Sin())), new Cos(new Sin()), new Tan(new Sin(), new Cos(new Sin())), new Sin(), lnMock, logMock);
        double ans = func.calc(x, eps);
        assertEquals(expected, ans, 0.01);

        print.csvPrint(x, ans, "src/main/resources/output.csv");
    }
}