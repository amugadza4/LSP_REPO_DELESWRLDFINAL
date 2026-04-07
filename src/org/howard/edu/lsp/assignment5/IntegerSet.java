package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;

/**
 * IntegerSet models a mathematical set of integers.
 * Supports standard set operations and ensures no duplicates.
 */
public class IntegerSet {

    private ArrayList<Integer> set;

    /**
     * Constructor: Initializes an empty set.
     */
    public IntegerSet() {
        set = new ArrayList<>();
    }

    /**
     * Clears the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in the set.
     * @return size of the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Checks if this set is equal to another set.
     * @param b another IntegerSet
     * @return true if both sets contain exactly the same elements
     */
    public boolean equals(IntegerSet b) {
        ArrayList<Integer> copyA = new ArrayList<>(set);
        ArrayList<Integer> copyB = new ArrayList<>(b.set);
        Collections.sort(copyA);
        Collections.sort(copyB);
        return copyA.equals(copyB);
    }

    /**
     * Checks if the set contains a value.
     * @param value integer to check
     * @return true if the set contains value
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest element in the set.
     * @return largest integer
     * @throws IllegalStateException if set is empty
     */
    public int largest() {
        if (set.isEmpty()) {
            throw new IllegalStateException("Set is empty");
        }
        return Collections.max(set);
    }

    /**
     * Returns the smallest element in the set.
     * @return smallest integer
     * @throws IllegalStateException if set is empty
     */
    public int smallest() {
        if (set.isEmpty()) {
            throw new IllegalStateException("Set is empty");
        }
        return Collections.min(set);
    }

    /**
     * Adds an element to the set (no duplicates allowed).
     * @param item integer to add
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an element from the set.
     * @param item integer to remove
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Returns a new set that is the union of this set and another set.
     * @param intSetb another IntegerSet
     * @return new IntegerSet containing all elements from both sets
     */
    public IntegerSet union(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        result.set.addAll(this.set);
        for (int item : intSetb.set) {
            if (!result.set.contains(item)) {
                result.set.add(item);
            }
        }
        return result;
    }

    /**
     * Returns a new set that is the intersection of this set and another 
set.
     * @param intSetb another IntegerSet
     * @return new IntegerSet containing only elements common to both sets
     */
    public IntegerSet intersect(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        for (int item : this.set) {
            if (intSetb.set.contains(item)) {
                result.set.add(item);
            }
        }
        return result;
    }

    /**
     * Returns a new set containing elements in this set but not in 
another set.
     * @param intSetb another IntegerSet
     * @return new IntegerSet with elements from this set not in intSetb
     */
    public IntegerSet diff(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        for (int item : this.set) {
            if (!intSetb.set.contains(item)) {
                result.set.add(item);
            }
        }
        return result;
    }

    /**
     * Returns a new set containing elements in intSetb but not in this 
set.
     * @param intSetb another IntegerSet
     * @return new IntegerSet with elements in intSetb not in this set
     */
    public IntegerSet complement(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        for (int item : intSetb.set) {
            if (!this.set.contains(item)) {
                result.set.add(item);
            }
        }
        return result;
    }

    /**
     * Checks if the set is empty.
     * @return true if set is empty
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set in ascending order.
     * Format: [1, 2, 3]
     * @return formatted string
     */
    @Override
    public String toString() {
        ArrayList<Integer> copy = new ArrayList<>(set);
        Collections.sort(copy);
        return copy.toString();
    }
}
