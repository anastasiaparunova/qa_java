import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;


public class FelineTests {

    private Feline feline;

    @Before
    public void createFeline() {
        feline = Mockito.spy(new Feline());
    }

    @Test
    public void testEatMeatReturnsPredatorFood() throws Exception {
        List<String> expectedFelineFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFelineFood);
        Assert.assertEquals("Неправильный список еды:", expectedFelineFood, feline.eatMeat());
    }

    @Test
    public void testGetFamilyReturnsFeline() {
        String animalFamily = feline.getFamily();
        Assert.assertEquals("Неправильное семейство:", "Кошачьи", animalFamily);
    }

    @Test
    public void testGetKittensReturnsDefault() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
        Assert.assertEquals("Неправильное количество котят:", 1, feline.getKittens());
    }

    @Test
    public void testGetKittensReturnsInput() {
        Assert.assertEquals("Неправильное количество котят:", 15, feline.getKittens(15));
    }
}