package ru.ifmo.collections;

import java.util.*;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {
    private static final int NULL_RETURN = -1;
    Set<Integer> NotUnique;
    Deque<Integer> deq;

    public FirstUnique(int[] numbers) {
        NotUnique = new TreeSet<>();
        deq = new LinkedList<>();
        for (int number : numbers) {
            if (deq.contains(number)) {
                NotUnique.add(number);
            } else {
                deq.addLast(number);
            }
        }
    }

    public int showFirstUnique() {
        while (deq.size() > 0 && NotUnique.contains(deq.peekFirst()))
            deq.removeFirst();
        return Optional.ofNullable(deq.peekFirst()).orElse(NULL_RETURN);
    }

    public void add(int value) {
        if (deq.contains(value)) {
            NotUnique.add(value);
        } else {
            deq.addLast(value);
        }
    }
}
