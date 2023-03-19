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
        list.add("6");
        list.add("7","8","9");
        Assertions.assertEquals("hello World 1 2 3 4 5 6 7 8 9", list.toString());
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
        Assertions.assertTrue(list.contains("1"));
        Assertions.assertFalse(list.contains("Gosha"));
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

    @Test
    public void shouldCheckNull() {
        list = new CustomArrayList();
        list.add("1", "2", null, "3", "4");
        Assertions.assertTrue(list.contains(null));
        Assertions.assertEquals("1 2 null 3 4", list.toString());
    }
    @Test
    public void shouldCheckInsert(){
        list.insert(2,"0");
        list.insert(0,"x");
        list.insert(9,"9");
        Assertions.assertEquals("x hello World 0 1 2 3 4 5 9",list.toString());
    }
    @Test
    public void shouldCheckSizeIncreasingForInsert(){
        list=new CustomArrayList(3);
        list.add("1");
        list.add("2");
        list.add("3");
        list.insert(3,"0");
        Assertions.assertEquals("1 2 3 0",list.toString());
    }

}
