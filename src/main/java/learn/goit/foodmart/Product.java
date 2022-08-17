package learn.goit.foodmart;

public class Product {
    private char id;
    private int price;
    private int specPriceCount;
    private int specPrice;

    public Product(char id, int price, int specPriceCount, int specPrice) {
        this.id = id;
        this.price = price;
        this.specPriceCount = specPriceCount;
        this.specPrice = specPrice;
    }

    public boolean is ( char id ) {
        return this .id == id;
    }

    public boolean hasSpecialPrice () {
        return specPriceCount > 0 && specPrice > 0;
    }

    public int getPrice (){
        return price;
    }

    public int getSpecPrice() {
        return specPrice;
    }

    public int getSpecPriceCount() {
        return specPriceCount;
    }
}
