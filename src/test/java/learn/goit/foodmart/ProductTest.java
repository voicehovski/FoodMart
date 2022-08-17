package learn.goit.foodmart;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Product productA = new Product ('A', 220, 4, 700);
    private Product productB = new Product ('B', 330, 0, 0);
    private Product productWrong = new Product ('C', 330, -20, 50);

    private Product [] products = {productA, productB, productWrong};

    @Test
    void testIsReturnTrueForRelevantProduct() {
        char id = 'A';

        List<Product> findedProducts = Arrays.stream(products)
                .filter(p -> p.is(id))
                .collect(Collectors.toList());
        Product actual = findedProducts.get(0);
        Product expected = productA;

        assertEquals(actual, expected);
    }

    @Test
    void testHasSpecialPriceTrueForSpecPrice() {
        boolean actual = productA.hasSpecialPrice();
        assertTrue(actual);
    }
    @Test
    void testHasSpecialPriceFalseForRegularPrice() {
        boolean actual = productB.hasSpecialPrice();
        assertFalse(actual);
    }
    @Test
    void testHasSpecialPriceFalseForWrongPrice() {
        boolean actual = productWrong.hasSpecialPrice();
        assertFalse(actual);
    }
}