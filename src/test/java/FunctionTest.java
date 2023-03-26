import com.opencsv.CSVReader;
import org.example.trigonometry.Sin;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;


public class FunctionTest {

    double eps = 0.1;
    static Sin sinMock;


    @Test
    void fd() {
        sinMock = Mockito.mock(Sin.class);

        try {
            FileReader sinInputs = new FileReader(
                    Objects.requireNonNull(
                            getClass().getResource("SinInput.csv")
                    ).getPath()
            );

            CSVReader csvReader = new CSVReader(sinInputs);
            for (String[] row : csvReader) {
                Mockito.when(sinMock.calc(Double.parseDouble(row[0]), eps)).thenReturn(Double.parseDouble(row[1]));
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}