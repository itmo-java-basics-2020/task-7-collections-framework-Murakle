package ru.ifmo.collections;

import java.util.*;

/**
 * Represents sorted set of unique values.
 * create() returns a SortedSet instance with natural ordering. (i.e. from smallest to largest in case of integer numbers)
 * from() is used to create a SortedSet instance with given Comparator.
 * Instances of a class can be created using only these two methods above.
 * <p>
 * This class should not be abstract and should be capable of adding/removing single/multiple elements.
 * It has two more methods: getSorted() and getReversed() which return an array of set contents in forward and reverse order respectively.
 * <p>
 * NB! This class must have only map(s) as an internal data structure(s).
 *
 * @param <T> set contents type
 */
public class SortedSet<T> extends AbstractSet<T> {

    private static final Object PRESENT = new Object();

    private final Map<T, Object> contents;

    private SortedSet() {
        this.contents = new TreeMap<>();
    }

    private SortedSet(Comparator<T> comparator) {
        this.contents = new TreeMap<>(comparator);
    }


    public static <T> SortedSet<T> create() {
        return new SortedSet<>();
    }

    public static <T> SortedSet<T> from(Comparator<T> comparator) {
        return new SortedSet<>(comparator);
    }

    public List<T> getSorted() {
        return new ArrayList<>(contents.keySet());
    }

    public List<T> getReversed() {
        List<T> array = getSorted();
        Collections.reverse(array);
        return array;
    }

    @Override
    public Iterator<T> iterator() {
        return contents.keySet().iterator();
    }

    @Override
    public int size() {
        return contents.size();
    }

    @Override
    public boolean add(T value) {
        return contents.put(value, PRESENT) == null;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        boolean setChanged = false;
        for (T val : collection) {
            setChanged |= add(val);
        }
        return setChanged;
    }

    @Override
    public boolean remove(Object value) {
        return contents.remove(value, PRESENT);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean setChanged = false;
        for (Object it : c) {
            setChanged |= remove(it);
        }
        return setChanged;
    }
}
