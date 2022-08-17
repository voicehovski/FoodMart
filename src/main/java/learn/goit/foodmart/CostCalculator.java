package learn.goit.foodmart;

/*Product field?*/
public interface CostCalculator {
    public static CostCalculator create (Product product) {
        if (product .hasSpecialPrice ()) {
            return new SpecialCostCalculator (product.getSpecPriceCount());
        } else {
            return new SimpleCostCalculator ();
        }
    }
    public int calc (Product product, int count);
}
