package learn.goit.foodmart;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCostCalculatorTest {

    @Test
    void testCalcCalculateValidPriceForProductWithRegularPrice() {
        //given
        Product productWithRegularPrice = new Product('A', 120, 0, 0 );
        int count = 2;
        CostCalculator calculator = new SimpleCostCalculator();
        int expectedPrice = 240;
        //when
        int actualPrice = calculator.calc(productWithRegularPrice, count);
        //then
        assertEquals(expectedPrice, actualPrice);
    }
    @Test
    void testCalcCalculateValidPriceForProductWithSpecialPrice() {
        //given
        Product productWithSpecialPrice = new Product('A', 120, 3, 300 );
        int countTogetSpecPrice = 3;
        CostCalculator calculator = new SimpleCostCalculator();
        int expectedPrice = 360;
        //when
        int actualPrice = calculator.calc(productWithSpecialPrice, countTogetSpecPrice);
        //then
        assertEquals(expectedPrice, actualPrice);
    }
}