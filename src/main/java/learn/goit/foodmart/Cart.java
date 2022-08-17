package learn.goit.foodmart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cart {
    private Map<Character,Integer> items = new HashMap<>();
    private DataSource dataSource;

    public Cart(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void add (char id) {
        if (items.containsKey(id)) {
            items.put(id, items.get(id)+1);
        } else {
            items.put(id,1);
        }
    }

    public List<OrderItem> get () {
        List<OrderItem> orderItems = new ArrayList<>();
        for (Map.Entry<Character,Integer> entry : items.entrySet()) {
            Product product = dataSource.read(entry.getKey());
            if (product == null) {
                throw new RuntimeException("Unknown product [" + entry.getKey() + "]");
            }
            orderItems.add (new OrderItem(product, entry.getValue()));
        }
        return orderItems;
    }

    public Map<Character,Integer> getMap () {
        return items;
    }
}
