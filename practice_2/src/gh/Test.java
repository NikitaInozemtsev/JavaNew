package gh;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

//Вариант 7

public class Test {
    public static void main(String[] args) {
        List<Human> result = createList();
        Stream<Human> input = result.stream();

        /*1 задание
        input.limit(5)
                .forEach(System.out::println);*/

        /*2 задание
        input.sorted((o1, o2)->o1.getBirthDate().compareTo(o2.getBirthDate()))
        .forEach(s-> System.out.println(s.getBirthDate()));*/

        /*3 задание
        input.filter(x->x.getWeight() < 60)
                .forEach(System.out::println);*/

        /*4 задание
        input.forEach(s-> System.out.println(s.getFirstName() + " " + s.getLastName()));*/
    }
    public static List<Human> createList() {
        List<Human> res = new ArrayList<>();
        res.add(new Human(23, "Oleg", "Olegov", LocalDate.of(1998, 4, 27), 100));

        res.add(new Human(20, "Oleg1", "Kolegov", LocalDate.of(2000, 10, 11), 68));

        res.add(new Human(18, "Oleg2", "Polegov", LocalDate.of(2002, 9, 8), 84));

        res.add(new Human(38, "Oleg3", "Molegov", LocalDate.of(1983, 1, 2), 75));


        return res;
    }
}
