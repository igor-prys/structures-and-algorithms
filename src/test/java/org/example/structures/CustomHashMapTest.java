package org.example.structures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomHashMapTest {
    private CustomHashMap<String, Integer> chs;

    @BeforeEach
    public void init() {
        chs = new CustomHashMap<>();
    }

    @Test
    public void shouldCheckMethodAdd() {
        chs.add("a", 1);
        chs.add("b", 2);
        chs.add("c", 3);
        Assertions.assertEquals(3, chs.getSize());
    }

    @Test
    public void shouldHandleDuplicate() {
        chs.add("a", 1);
        chs.add("a", 3);
        Assertions.assertEquals("a: 3;", chs.toString());
    }

    @Test
    public void shouldGetValueByKey() {
        chs.add("a", 1);
        chs.add("b", 2);
        chs.add("c", 3);
        chs.add(null, 4);
        Assertions.assertEquals(3, chs.get("c"));
        Assertions.assertEquals(null, chs.get("q"));
        Assertions.assertEquals(4, chs.get(null));
    }

    @Test
    public void shouldCheckContainsKey() {
        chs.add("a", 1);
        chs.add("b", 2);
        Assertions.assertTrue(chs.containsKey("a"));
        Assertions.assertFalse(chs.containsKey("v"));
    }
}
