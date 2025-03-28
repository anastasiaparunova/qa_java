import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import java.util.List;

public class LionTests {

    private Feline feline;

    @Before
    public void setUp() {
        feline = Mockito.mock(Feline.class);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void throwsExceptionForInvalidSex() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("Используйте допустимые значения пола животного - самец или самка");
        Lion lion = new Lion(feline, "Другое");
    }

    @Test
    public void shouldReturnCorrectKittenCount() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        Mockito.when(feline.getKittens()).thenReturn(10);
        Assert.assertEquals("Неверное количество котят:", 10, lion.getKittens());
    }

    @Test
    public void shouldReturnFoodForPredator() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        Assert.assertEquals("Еда не соответствует хищнику!", expectedFood, lion.getFood());
    }

}
