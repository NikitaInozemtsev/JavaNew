import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Or;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.controller.MyController;
import ru.model.Item;
import ru.model.Order;
import ru.services.ItemService;
import ru.services.OrderService;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MyControllerTest {
    @Mock
    private ItemService itemService;
    @Mock
    private OrderService orderService;
    @InjectMocks
    MyController controller;
    @Captor
    ArgumentCaptor<Item> captorItem;
    @Captor
    ArgumentCaptor<Order> captorOrder;

    @Test
    void outItem(){
        Item i = new Item();
        i.setName("Some text");
        Item i1 = new Item();
        i1.setName("Coffe");
        Mockito.when(itemService.getItems()).thenReturn(List.of(i, i1));

        Assertions.assertEquals(2, controller.outItem().getBody().size());
        Assertions.assertEquals("Some text", controller.outItem().getBody().get(0).getName());
    }
    @Test
    void createItem() {
        Item item = new Item();
        item.setName("Vitya");
        controller.createItem(item);
        Mockito.verify(itemService).insertItem(captorItem.capture());
        Item captured = captorItem.getValue();
        Assertions.assertEquals("Vitya", captured.getName());
    }
    @Test
    void deleteItem() {
        Item item = new Item();
        item.setName("Vitya");
        controller.delItem(item);
        Mockito.verify(itemService).deleteItem(captorItem.capture());
        Item captured = captorItem.getValue();
        Assertions.assertEquals("Vitya", captured.getName());
    }
    @Test
    void outOrder(){
        Order o = new Order();
        o.setOrderDate("20-01-2008");
        Order o1 = new Order();
        o1.setOrderDate("19-09-2018");
        Mockito.when(orderService.getOrders()).thenReturn(List.of(o, o1));

        Assertions.assertEquals(2, controller.outOrder().getBody().size());
        Assertions.assertEquals("20-01-2008", controller.outOrder().getBody().get(0).getOrderDate());
    }
    @Test
    void insertOrder() {
        Order order = new Order();
        order.setOrderDate("25-01-2017");
        controller.createOrder(order);
        Mockito.verify(orderService).insertOrder(captorOrder.capture());
        Order captured = captorOrder.getValue();
        Assertions.assertEquals("25-01-2017", captured.getOrderDate());
    }
    @Test
    void deleteOrder() {
        Order order = new Order();
        order.setOrderDate("25-01-2017");
        controller.delOrder(order);
        Mockito.verify(orderService).deleteOrder(captorOrder.capture());
        Order captured = captorOrder.getValue();
        Assertions.assertEquals("25-01-2017", captured.getOrderDate());
    }
}