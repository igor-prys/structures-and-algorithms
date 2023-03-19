package org.example.structures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomHashSetTest {
    private CustomHashSet<String> chs;

    @BeforeEach
    public void init() {
        chs = new CustomHashSet(1);
    }

    @Test
    public void shouldCheckMethodAdd() {
        chs.add("a");
        chs.add("b");
        chs.add("c");
        chs.add("d");
        chs.add("e");
        chs.add("f");
        Assertions.assertTrue(chs.contains("c"));
        Assertions.assertFalse(chs.contains("t"));
        Assertions.assertEquals(6, chs.getSize());
    }

    @Test
    public void shouldIgnoreDuplicate() {
        chs.add("a");
        chs.add("a");
        Assertions.assertEquals("a", chs.toString());
    }

    @Test
    public void shouldAllowToAddNull() {
        chs.add(null);
        chs.add("a");
        Assertions.assertEquals("null a", chs.toString());
    }

    @Test
    public void shouldCheckNullDuplicates() {
        chs.add(null);
        chs.add(null);
        Assertions.assertEquals("null", chs.toString());
    }
}
