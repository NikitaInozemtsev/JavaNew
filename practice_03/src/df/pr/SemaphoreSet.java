package df.pr;

import java.util.*;
import java.util.concurrent.Semaphore;

public class SemaphoreSet<E> implements Set<E> {
    private  Semaphore s;
    private Set<E> set;

    public SemaphoreSet(int num) {
        this.s = new Semaphore(num);
        this.set = new HashSet<>();
    }

    @Override
    public int size() {
        try {
            s.acquire();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        int temp = set.size();
        s.release();
        return temp;
    }

    @Override
    public boolean isEmpty() {
        try {
            s.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean temp = set.isEmpty();
        s.release();
        return temp;
    }

    @Override
    public boolean contains(Object o) {
        try {
            s.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        s.release();
        return set.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return set.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        try {
            s.acquire();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
            return false;
        }
        boolean temp = set.add(e);
        s.release();
        return temp;
    }

    @Override
    public boolean remove(Object o) {
        try {
            s.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean temp = set.remove(o);
        s.release();
        return temp;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
