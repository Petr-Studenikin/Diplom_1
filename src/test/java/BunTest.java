import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;
public class BunTest {
    @Test
    public void getPriceReturnValidPrice() {
        Bun bun = new Bun("name", 1);
        float expectedPrice = 1;
        float actualPrice = bun.getPrice();
        assertEquals("Обратите внимание! Неправильная цена", expectedPrice, actualPrice, 0);
    }
    @Test
    public void getNameReturnValidName() {
        Bun bun = new Bun("name", 1);
        String expectedName = "name";
        String actualName = bun.getName();
        assertEquals ("Обратите внимание! Неправильное имя", expectedName, actualName);
    }
}