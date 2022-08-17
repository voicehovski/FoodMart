package learn.goit.foodmart;

public class OrderItem {
    private Product product;
    private int count;

    public OrderItem(Product product, int count) {
        this.product = product;
        this.count = count;
    }

    public Product getProduct () {return product;}
    public int getCount () {return count;}
}
