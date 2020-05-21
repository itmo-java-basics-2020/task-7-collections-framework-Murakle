package ru.ifmo.collections;

import java.util.*;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {
    private PriorityQueue<Integer> firstKNumbers;

    public KthLargest(int k, int[] numbers) {
        firstKNumbers = new PriorityQueue<>();
        for (int number : numbers) {
            firstKNumbers.add(number);
        }
        while (firstKNumbers.size() > k)
            firstKNumbers.remove();
    }

    public int add(int val) {
        firstKNumbers.add(val);
        firstKNumbers.remove();
        //noinspection ConstantConditions
        return firstKNumbers.peek();
    }
}