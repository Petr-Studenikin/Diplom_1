import org.junit.Test;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class IngredientTypeTest {
    @Test
    public void sauceIngredientType() {
        assertThat(IngredientType.SAUCE, is(notNullValue()));
    }
    @Test
    public void fillingIngredientType() {
        assertThat(IngredientType.FILLING, is(notNullValue()));
    }
}