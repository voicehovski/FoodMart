package learn.goit.foodmart;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpecialCostCalculatorTest {

    @Test
    void testCalcCalculateRegularPriceForProductWithRegularPrice() {
        //given
        Product productWithRegularPrice = new Product('A', 120, 0, 0 );
        int count = 2;
        CostCalculator calculator = new SpecialCostCalculator(3);
        int expectedPrice = 240;
        //when
        int actualPrice = calculator.calc(productWithRegularPrice, count);
        //then
        assertEquals(expectedPrice, actualPrice);
    }
    @Test
    void testCalcCalculateSpecialPriceForProductWithSpecialPrice() {
        //given
        Product productWithSpecialPrice = new Product('A', 120, 3, 300 );
        int countTogetSpecPrice = 3;
        CostCalculator calculator = new SpecialCostCalculator(3);
        int expectedPrice = 300;
        //when
        int actualPrice = calculator.calc(productWithSpecialPrice, countTogetSpecPrice);
        //then
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    void testCalcCalculateRegularPriceForProductWithSpecialPrice() {
        //given
        Product productWithSpecialPrice = new Product('A', 120, 3, 300 );
        int countTogetSpecPrice = 8;
        CostCalculator calculator = new SpecialCostCalculator(3);
        int expectedPrice = 960;
        //when
        int actualPrice = calculator.calc(productWithSpecialPrice, countTogetSpecPrice);
        //then
        assertEquals(expectedPrice, actualPrice);
    }

}