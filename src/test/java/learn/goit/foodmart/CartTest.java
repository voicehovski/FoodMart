package learn.goit.foodmart;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CartTest {

    @Mock
    DataSource dataSource;

    private Cart createCart () {
        Cart cart = new Cart(dataSource);
        cart.add('A');
        cart.add('A');
        cart.add('B');
        cart.add('C');
        cart.add('B');
        cart.add('B');

        return cart;
    }

    @Test
    void addShouldBuildNiceInnerMap() {
        Cart cart = createCart();

        Map<Character, Integer> expected = new HashMap<>();
        expected.put('A',2);
        expected.put('B',3);
        expected.put('C',1);

        Map<Character,Integer> actual = cart.getMap();

        assertEquals(actual, expected);
    }

    @Test
    void test1(){
        Cart cart = createCart();
        cart.get();

        verify(dataSource, times(1)).read('A');
        verify(dataSource, times(1)).read('B');
        verify(dataSource, times(1)).read('C');
        //verify(dataSource, times(3)).read()
    }
}