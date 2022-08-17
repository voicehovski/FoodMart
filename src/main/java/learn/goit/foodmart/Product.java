package learn.goit.foodmart;

public class Product {
    private char id;
    private int price;
    private int specPriceMinCount;
    private int specPrice;

    public Product(char id, int price, int specPriceMinCount, int specPrice) {
        this.id = id;
        this.price = price;
        this.specPriceMinCount = specPriceMinCount;
        this.specPrice = specPrice;
    }

    public boolean is ( char id ) {
        return this .id == id;
    }

    public boolean hasSpecialPrice () {
        return specPrice == -1;
    }

    public int getPrice (){
        return price;
    }

    public int getSpecPrice() {
        return specPrice;
    }

    public int getSpecPriceCount() {
        return specPriceMinCount;
    }
}
