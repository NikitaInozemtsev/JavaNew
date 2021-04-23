import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.model.Item;
import ru.repositories.ItemRepository;
import ru.services.ItemService;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {
    @Mock
    private ItemRepository reps;
    @Captor
    ArgumentCaptor<Item> captor;

    @Test
    void getItems(){
        Item i = new Item();
        i.setName("Okone");
        Item i1 = new Item();
        i.setName("Coffe");
        Mockito.when(reps.findAll()).thenReturn(List.of(i, i1));
        ItemService ser = new ItemService(reps);

        Assertions.assertEquals(2, ser.getItems().size());
    }
    @Test
    void save() {
        Item item = new Item();
        item.setName("Vitya");
        ItemService ser = new ItemService(reps);
        ser.insertItem(item);
        Mockito.verify(reps).save(captor.capture());
        Item captured = captor.getValue();
        Assertions.assertEquals("Vitya", captured.getName());
    }
    @Test
    void delete() {
        Item item = new Item();
        item.setName("Vitya");
        ItemService ser = new ItemService(reps);
        ser.deleteItem(item);
        Mockito.verify(reps).delete(captor.capture());
        Item captured = captor.getValue();
        Assertions.assertEquals("Vitya", captured.getName());
    }
}
