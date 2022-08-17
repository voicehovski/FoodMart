package learn.goit.foodmart;

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
        return items.entrySet().stream()
                .map(entry -> new OrderItem(dataSource.read(entry.getKey()),entry.getValue()))
                .collect(Collectors.toList());
    }

    public Map<Character,Integer> getMap () {
        return items;
    }
}
