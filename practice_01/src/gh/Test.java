package gh;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

class Test {
    public static void main(String[] args) {
        Consumer str = x -> {
            StringBuilder s = new StringBuilder((String) x);
            for (int i = 0; i < s.length(); i++) {
                if((i + 1) % 3 == 0) {
                    s.setCharAt(i, Character.toUpperCase(s.charAt(i)));
                }
            }
            System.out.println(s);
        };

        Function str1 = x1 -> {
            Student[] res = (Student[]) x1;
            Map<String , List<Student>> result = new HashMap<>();

            for (int i = 0; i  < res.length; i++) {
                result.put(res[i].getGroup(), new ArrayList<>());
            }

            for (int i = 0; i  < res.length; i++) {
                result.get(res[i].getGroup()).add(res[i]);
            }

            return result;
        };

        //str.accept("OkoNeBruh");

        Student[] mas = new Student[5];
        mas[0] = new Student("Oleg", "23");
        mas[1] = new Student("Oleg2", "23");
        mas[2] = new Student("Oleg3", "2");
        mas[3] = new Student("Oleg4", "1");
        mas[4] = new Student("Oleg5", "10");

        Map<String , List<Student>> resu = (Map<String, List<Student>>) str1.apply(mas);
        System.out.println(resu.toString());
}
}


class Student {
    String name;
    String group;

    public Student(String name, String group) {
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }
}