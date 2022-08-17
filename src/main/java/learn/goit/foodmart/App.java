package learn.goit.foodmart;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        System.out.println(new App().buy("ADDDACCABA"));
    }

    public int buy (String productIds) {
        Cart cart = new Cart ();
        for (char id : productIds.toCharArray()) {
            cart .add ( id );
        }

        int total = 0;
        for ( OrderItem item : cart .get() ){
            Product product = item.getProduct();
            CostCalculator calculator = CostCalculator.create(product);
            total += calculator .calc(product, item.getCount());
        }

        return total;
        //Arrays.stream(cart.get())
        //        .map(orderItem -> CostCalculator.create(orderItem.getProduct(),orderItem.getCount()))
        //        .reduce()
    }
}
