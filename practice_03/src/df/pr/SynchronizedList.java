package df.pr;

import java.util.*;

public class SynchronizedList<E> implements List<E> {

    private List<E> sList = new ArrayList<E>();

    @Override
    public synchronized int size() {
        return sList.size();
    }

    @Override
    public synchronized boolean isEmpty() {
        return sList.isEmpty();
    }

    @Override
    public synchronized boolean contains(Object o) {
        return sList.contains(o);
    }

    @Override
    public synchronized boolean add(E e) {
        return sList.add(e);
    }

    @Override
    public synchronized boolean remove(Object o) {
        return sList.remove(o);
    }

    @Override
    public synchronized E get(int index) {
        return sList.get(index);
    }

    @Override
    public synchronized void add(int index, E element) {
        sList.add(index, element);
    }

    @Override
    public synchronized Iterator<E> iterator() {
        return null;
    }

    @Override
    public synchronized Object[] toArray() {
        return new Object[0];
    }

    @Override
    public synchronized <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public synchronized boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public synchronized boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public synchronized boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public synchronized boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public synchronized boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public synchronized void clear() {

    }

    @Override
    public synchronized E set(int index, E element) {
        return null;
    }

    @Override
    public synchronized E remove(int index) {
        return null;
    }

    @Override
    public synchronized int indexOf(Object o) {
        return sList.indexOf(o);
    }

    @Override
    public synchronized int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public synchronized ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public synchronized ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public synchronized List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
