package learn.goit.foodmart;

public class SpecialCostCalculator implements CostCalculator {
    private int productCount;
    public SpecialCostCalculator (int productCount) {
        this .productCount = productCount;
    }
    @Override
    public int calc(Product product, int count) {
        return productCount == count ? product.getSpecPrice() : product .getPrice() * count;
        //return product .correspondSpecPriceCondition(count) ? product.getSpecPrice() : product .getPrice();
    }
}
