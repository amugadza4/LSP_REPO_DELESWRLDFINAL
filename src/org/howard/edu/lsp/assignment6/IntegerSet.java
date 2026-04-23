package org.howard.edu.lsp.assignment6;

import java.util.ArrayList;
import java.util.Collections;

public class IntegerSet {
    private ArrayList<Integer> set;

    public IntegerSet() {
        set = new ArrayList<Integer>();
    }

    public void clear() {
        set.clear();
    }

    public int length() {
        return set.size();
    }

    public boolean equals(IntegerSet b) {
        if (this.length() != b.length()) {
            return false;
        }
        return this.set.containsAll(b.set) && b.set.containsAll(this.set);
    }

    public boolean contains(int value) {
        return set.contains(value);
    }

    public int largest() {
        if (set.isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return Collections.max(set);
    }

    public int smallest() {
        if (set.isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return Collections.min(set);
    }

    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    public void union(IntegerSet intSetb) {
        for (int value : intSetb.set) {
            if (!set.contains(value)) {
                set.add(value);
            }
        }
    }

    public void intersect(IntegerSet intSetb) {
        set.retainAll(intSetb.set);
    }

    public void diff(IntegerSet intSetb) {
        set.removeAll(intSetb.set);
    }

    public void complement(IntegerSet intSetb) {
        ArrayList<Integer> result = new ArrayList<>(intSetb.set);
        result.removeAll(this.set);
        this.set = result;
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    public String toString() {
        return set.toString();
    }
}
