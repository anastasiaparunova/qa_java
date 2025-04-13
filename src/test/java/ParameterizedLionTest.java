import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class ParameterizedLionTest {

    private final String sex;
    private final boolean expectedHasMane;
    private Feline feline;

    public ParameterizedLionTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Before
    public void setUp() {
        feline = Mockito.mock(Feline.class);
    }

    @Parameterized.Parameters(name = "Пол: {0}, Есть ли грива: {1}")
    public static Object[][] testData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void hasManeDependsOnSex() throws Exception {
        Lion lion = new Lion(feline, sex);
        boolean actual = lion.doesHaveMane();
        assertEquals(expectedHasMane, actual);
    }
}
