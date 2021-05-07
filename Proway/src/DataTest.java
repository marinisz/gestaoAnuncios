import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataTest {

    @Test
    void diferencaDatas() {
        Data data = new Data();
        Data data2 = new Data();
        assertEquals(data.igualData(data,data2),true);
    }
}