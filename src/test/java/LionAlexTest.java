import com.example.AlexLion;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

public class LionAlexTest {
    @Mock
    Feline feline;

    @Test
    public void confirmAlexAlwaysMale() throws Exception {
        AlexLion alex = new AlexLion(feline, "Самка");
        Assert.assertTrue(alex.doesHaveMane());
    }

    @Test
    public void confirmCorrectFriendList() throws Exception {
        AlexLion alex = new AlexLion(feline, "Самец");
        List<String> expectedFriends = List.of("Марти", "Глория", "Мелман");
        Assert.assertEquals("Неправильный список друзей:", expectedFriends, alex.getFriends());
    }

    @Test
    public void confirmCorrectPlaceOfLiving() throws Exception {
        AlexLion alex = new AlexLion(feline, "Самец");
        String expectedLocation = "Зоопарк Нью-Йорка";
        Assert.assertEquals("Неправильное место проживания:", expectedLocation, alex.getPlaceOfLiving());
    }

    @Test
    public void confirmAlwaysZeroKittens() throws Exception {
        AlexLion alex = new AlexLion(feline, "Самец");
        int expectedKittenCount = 0;
        Assert.assertEquals("Неправильное количество котят:", expectedKittenCount, alex.getKittens());
    }
}
