package org.example.structures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomArrayListTest {
    private CustomArrayList list;

    @BeforeEach
    public void createList() {
        list = new CustomArrayList(3);
        list.add("hello");
        list.add("World");
        list.add("1", "2", "3", "4", "5");
    }

    @Test
    public void shouldCheckMethodAdd() {
        Assertions.assertEquals("hello World 1 2 3 4 5", list.toString());
    }

    @Test
    public void shouldCheckMethodDeleteByIndex() {
        list.deleteByIndex(0);
        list.deleteByIndex(3);
        list.deleteByIndex(4);
        Assertions.assertEquals("World 1 2 4", list.toString());
    }

    @Test
    public void shouldCheckDeleteByValue() {
        list.deleteByValue("1");
        Assertions.assertEquals("hello World 2 3 4 5", list.toString());
    }

    @Test
    public void shouldCheckMethodContain() {
        Assertions.assertTrue(list.contain("1"));
        Assertions.assertFalse(list.contain("Gosha"));
    }

    @Test
    public void shouldCheckIterator() {
        Iterator iterator = list.createIterator();
        String result = "";
        while (iterator.hasNext()) {
            result += iterator.next() + " ";
        }
        result = result.trim();
        Assertions.assertEquals("hello World 1 2 3 4 5", result);
    }
}
