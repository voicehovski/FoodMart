package learn.goit.foodmart;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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

    private Cart createCartWithMissingProduct () {
        Cart cart = new Cart(dataSource);
        cart.add('A');
        cart.add('A');
        cart.add('B');
        cart.add('D');
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
    void testGetCallsDataSourceReadOneTimeForEveryArgument(){
        Cart cart = createCart();

        when(dataSource.read(anyChar()))
                .thenReturn(new Product ('A', 15, 3, 30))
                .thenReturn(new Product ('B', 15, 3, 30))
                .thenReturn(new Product ('C', 15, 3, 30));

        cart.get();

        verify(dataSource, times(3)).read(anyChar());
    }

    @Test
    void testGetThrowsExceptionWhenProductEqNullForExampleIfWrongId(){
        Cart cart = createCartWithMissingProduct();

        when(dataSource.read('A'))
                .thenReturn(new Product ('A', 15, 3, 30));
        when(dataSource.read('B'))
                .thenReturn(new Product ('B', 15, 3, 30));
        //when(dataSource.read('D'))
                //.thenReturn(null);

                //.thenThrow(RuntimeException.class);

        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> cart.get(),
                "cart.get() should throw exception but it doesn`t!"
        );

        assertTrue(thrown.getMessage().contains("Unknown product"));
    }

    @Test
    void testGetCallsDataSourceReadThreeTime(){
        Cart cart = createCart();

        when(dataSource.read(anyChar()))
                .thenReturn(new Product ('A', 15, 3, 30))
                .thenReturn(new Product ('B', 15, 3, 30))
                .thenReturn(new Product ('C', 15, 3, 30));

        cart.get();

        verify(dataSource).read('A');
        verify(dataSource, times(1)).read('B');
        verify(dataSource, times(1)).read('C');

        //verify(dataSource, times(3)).read(any());
        //doNothing().when(dataSource).read(any());
    }
}