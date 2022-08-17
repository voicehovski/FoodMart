package learn.goit.foodmart;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        System.out.println(new App().buy("ADDDACCABA"));
        System.out.println(new App().buy("ABCDABA"));
        // Здесь будет предусмотренное исключение, поскольку артикула X в базе нет
        //System.out.println(new App().buy("ABCDABAX"));
        System.out.println(new App().buy(""));
    }

    public int buy (String productIds) {
        Cart cart = new Cart (new DataSource());
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
    }
}
