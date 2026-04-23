package org.howard.edu.lsp.assignment6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegerSetTest {

    @Test
    public void testAddNormalAndDuplicate() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        assertTrue(set.contains(1));

        set.add(1);
        assertEquals(1, set.length());
    }

    @Test
    public void testRemoveNormalAndNotPresent() {
        IntegerSet set = new IntegerSet();
        set.add(1);

        set.remove(1);
        assertFalse(set.contains(1));

        set.remove(99);
        assertFalse(set.contains(99));
    }

    @Test
    public void testEqualsDifferentOrder() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();

        a.add(1);
        a.add(2);

        b.add(2);
        b.add(1);

        assertTrue(a.equals(b));
    }

    @Test
    public void testUnionWithEmpty() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();

        a.add(1);
        a.union(b);

        assertTrue(a.contains(1));
    }

    @Test
    public void testIntersectNoCommon() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();

        a.add(1);
        b.add(2);

        a.intersect(b);

        assertTrue(a.isEmpty());
    }

    @Test
    public void testDiffIdenticalSets() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();

        a.add(1);
        b.add(1);

        a.diff(b);

        assertTrue(a.isEmpty());
    }

    @Test
    public void testComplementDisjoint() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();

        a.add(1);
        b.add(2);

        a.complement(b);

        assertTrue(a.contains(2));
    }

    @Test
    public void testContainsNotPresent() {
        IntegerSet set = new IntegerSet();
        set.add(1);

        assertFalse(set.contains(2));
    }

    @Test
    public void testIsEmpty() {
        IntegerSet set = new IntegerSet();
        assertTrue(set.isEmpty());

        set.add(1);
        assertFalse(set.isEmpty());
    }

    @Test
    public void testToStringEmpty() {
        IntegerSet set = new IntegerSet();
        assertEquals("[]", set.toString());
    }

    @Test
    public void testLargestAndSmallest() {
        IntegerSet set = new IntegerSet();
        set.add(5);

        assertEquals(5, set.largest());
        assertEquals(5, set.smallest());
    }

    @Test
    public void testLargestSmallestEmpty() {
        IntegerSet set = new IntegerSet();

        assertThrows(RuntimeException.class, set::largest);
        assertThrows(RuntimeException.class, set::smallest);
    }
}
