package df.pr;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        SynchronizedList<Integer> list = new SynchronizedList<Integer>();
        SemaphoreSet<Integer> set = new SemaphoreSet<Integer>(1);

        Thread one = new Thread( ()-> {
            list.add(1);
            list.add(2);
            set.add(5);
            set.add(6);
        });

        Thread two = new Thread( ()-> {
            list.add(3);
            list.add(4);
            set.add(7);
            set.add(8);
            set.remove(6);
        });
        one.start();
        two.start();
        Thread.sleep(3000);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("\n");
        System.out.println(Arrays.toString(set.toArray()));
    }
}
