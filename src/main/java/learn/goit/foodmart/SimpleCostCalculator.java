package learn.goit.foodmart;

public class SimpleCostCalculator implements CostCalculator {
    @Override
    public int calc(Product product, int count) {
        return product.getPrice() * count;
        //return product.getCostOf(count);
    }
}
