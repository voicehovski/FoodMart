package learn.goit.foodmart;

public class DataSource {
    private Product [] data = {
        new Product('A',125,3,300),
                new Product('B',425,0,0),
                new Product('C',100,6,500),
                new Product('D',75,0,0),
    };

    public Product read (char id) {
        for (Product p : data) {
            if (p.is(id)) {
                return p;
            }
        }
        return null;
    }
    public Product[] read () {
        return data;
    }
}
