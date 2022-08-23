package learn.goit.foodmart;

public class SpecialCostCalculator implements CostCalculator {
    private int productCount;
    public SpecialCostCalculator (int productCount) {
        this .productCount = productCount;
    }
    @Override
    public int calc(Product product, int count) {
        int simplePriceProductCount = count % productCount;
        int specialPriceProductCount = count / productCount;
        return simplePriceProductCount * product .getPrice() + specialPriceProductCount * product .getSpecPrice();
        //return product .correspondSpecPriceCondition(count) ? product.getSpecPrice() : product .getPrice();
    }
}
