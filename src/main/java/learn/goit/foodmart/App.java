package learn.goit.foodmart;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        System.out.println(new App().buy("ADDDACCABA"));
        System.out.println(new App().buy("ABCDABA"));
        System.out.println(new App().buy("A"));
        System.out.println(new App().buy("AA"));
        System.out.println(new App().buy("AAA"));
        System.out.println(new App().buy("AAAA"));
        System.out.println(new App().buy("AAAAA"));
        System.out.println(new App().buy("AAAAAA"));
        System.out.println(new App().buy("AAAAAAA"));
        // Здесь будет предусмотренное исключение, поскольку артикула X в базе нет
        //System.out.println(new App().buy("ABCDABAX"));
        System.out.println(new App().buy(""));
    }

    public double buy (String productIds) {
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

        return total/100.0;
    }
}
