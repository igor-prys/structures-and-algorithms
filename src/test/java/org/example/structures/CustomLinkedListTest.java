package org.example.structures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CustomLinkedListTest {
    private CustomLinkedList<Integer> ll;

    @BeforeEach
    public void shouldCreateLinkedList() {
        ll = new CustomLinkedList<Integer>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(5);
    }

    @Test
    public void shouldAddElementByIndexFirst() {
        ll.addByIndex(0, 0);
        Assertions.assertEquals("[0, 1, 2, 3, 5]", ll.toString());
    }

    @Test
    public void shouldAddElementByIndexMiddle() {
        ll.addByIndex(3, 4);
        Assertions.assertEquals("[1, 2, 3, 4, 5]", ll.toString());
    }

    @Test
    public void shouldAddElementByIndexEnd() {
        ll.addByIndex(4, 6);
        Assertions.assertEquals("[1, 2, 3, 5, 6]", ll.toString());
    }

    @Test
    public void shouldCheckExceptionByMethodAddElement() {
        Exception ex = Assertions.assertThrows(LinkedListException.class, () -> ll.addByIndex(10, 10));
        Assertions.assertNotNull(ex);
        Assertions.assertEquals("Sorry, index bigger than size", ex.getMessage());
    }

    @Test
    public void shouldCheckGetValue() {
        ll = new CustomLinkedList<Integer>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        Assertions.assertEquals(4, ll.getValue(3));
        Assertions.assertEquals(1, ll.getValue(0));
        Assertions.assertEquals(3, ll.getValue(2));
    }

    @Test
    public void shouldCheckExceptionForGetValue() {
        Exception ex = Assertions.assertThrows(LinkedListException.class, () -> ll.getValue(4));
        Assertions.assertNotNull(ex);
        Assertions.assertEquals("Sorry, incorrect index", ex.getMessage());
    }

    @Test
    public void shouldCheckRemoveMethod() {
        ll = new CustomLinkedList<Integer>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.removeElement(2);
        Assertions.assertEquals("[1, 2, 4]", ll.toString());
        ll.removeElement(2);
        Assertions.assertEquals("[1, 2]", ll.toString());
        ll.removeElement(0);
        Assertions.assertEquals("[2]", ll.toString());
    }

    @Test
    public void shouldCheckExceptionRemoveMethod() {
        ll = new CustomLinkedList<Integer>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        Exception ex = Assertions.assertThrows(LinkedListException.class, () -> ll.removeElement(4));
        Assertions.assertNotNull(ex);
        Assertions.assertEquals("Sorry, incorrect index", ex.getMessage());
    }

    @Test
    public void shouldCheckIterator() {
        String result = "";
        for (Integer num : ll) {
            result += num + " ";
        }
        result = result.trim();
        Assertions.assertEquals("1 2 3 5", result);
    }
}
