import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    Burger burger = new Burger();

    @Test
    public void setBunsSetsBunsToBurger() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void removeIngredientRemovesIngredientFromBurger() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        int actualValue = burger.ingredients.size();
        int expectedValue = 0;
        assertEquals("Обратите внимание! Бургер собран не верно", expectedValue, actualValue);
    }

    @Test
    public void addIngredientAddsIngredientToBurger() {
        burger.addIngredient(ingredient);
        int actualValue = burger.ingredients.size();
        int expectedValue = 1;
        assertEquals("Обратите внимание! Бургер собран не верно", expectedValue, actualValue);
    }

    @Test
    public void getReceiptReturnsCorrectString() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(bun.getPrice()).thenReturn(200f);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("cutlet");
        Mockito.when(ingredient.getPrice()).thenReturn(200f);
        String actualValue = burger.getReceipt();
        String expectedValue = "(==== white bun ====)\n" +
                "= filling cutlet =\n" +
                "(==== white bun ====)\n" +
                "\n" +
                "Price: 600,000000\n";
        assertEquals( expectedValue.replace("\r\n", "\n"), actualValue.replace("\r\n", "\n"));
    }

    @Test
    public void moveIngredientMovesIngredientFromBurger() {
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "sausage", 300));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        burger.moveIngredient(0, 1);
        String actualValue = burger.ingredients.get(1).name;
        String expectedValue = "sausage";
        assertEquals("Обратите внимание! Бургер собран не верно", expectedValue, actualValue);
    }

    @Test
    public void getPriceReturnsCorrectPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(2f);
        Mockito.when(ingredient.getPrice()).thenReturn(2f);
        float expectedPrice = 6;
        float actualPrice = burger.getPrice();
        assertEquals("Обратите внимание! Неправильная цена", expectedPrice, actualPrice, 0);
    }
}