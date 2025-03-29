import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class CatTests {

    @Mock
    Feline feline;

    @Test
    public void testSaysMeow() {
        Cat cat = new Cat(feline);
        assertEquals("Неправильный звук:", "Мяу", cat.getSound());
    }


    @Test
    public void testGetsFelineFood() throws Exception {
        Cat newCat = new Cat(feline);
        when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> catFood = newCat.getFood();
        verify(feline, times(1)).eatMeat();
        assertEquals("Неправильный список еды:", List.of("Животные", "Птицы", "Рыба"), catFood);
    }
}
