import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    @Test
    public void getPriceReturnIngredientPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "name", 100);
        float expectedPrice = 101;
        float actualPrice = ingredient.getPrice();
        assertEquals("Обратите внимание! Неправильная цена", expectedPrice, actualPrice, 20);
    }

    @Test
    public void getNameReturnIngredientName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "name", 300);
        String expectedName = "name";
        String actualName = ingredient.getName();
        assertEquals("Обратите внимание! Неправильное имя", expectedName, actualName);
    }

    @Test
    public void getTypeReturnIngredientType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "name", 200);
        IngredientType expectedType = IngredientType.SAUCE;
        IngredientType actualType = ingredient.getType();
        assertEquals("Обратите внимание! Неправильный тип", expectedType, actualType);
    }
}