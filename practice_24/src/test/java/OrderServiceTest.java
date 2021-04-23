import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.model.Order;
import ru.repositories.OrderRepository;
import ru.services.OrderService;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
    @Mock
    private OrderRepository reps;
    @Captor
    ArgumentCaptor<Order> captor;

    @Test
    void getItems(){
        Order i = new Order();
        i.setOrderDate("02.02");
        Order i1 = new Order();
        i.setOrderDate("3077");
        Mockito.when(reps.findAll()).thenReturn(List.of(i, i1));
        OrderService ser = new OrderService(reps);

        Assertions.assertEquals(2, ser.getOrders().size());
    }
    @Test
    void save() {
        Order i = new Order();
        i.setOrderDate("09.03.2021");
        OrderService ser = new OrderService(reps);
        ser.insertOrder(i);
        Mockito.verify(reps).save(captor.capture());
        Order captured = captor.getValue();
        Assertions.assertEquals("09.03.2021", captured.getOrderDate());
    }
    @Test
    void delete() {
        Order i = new Order();
        i.setOrderDate("09.03.2021");
        OrderService ser = new OrderService(reps);
        ser.deleteOrder(i);
        Mockito.verify(reps).delete(captor.capture());
        Order captured = captor.getValue();
        Assertions.assertEquals("09.03.2021", captured.getOrderDate());
    }
}
