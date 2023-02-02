package org.example.structures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JavaAlikeHashSetTest {
    private JavaAlikeHashSet jhs;

    @BeforeEach
    public void before() {
        jhs = new JavaAlikeHashSet();
    }

    @Test
    public void shouldCheckMethodAdd() {
        jhs.add("a");
        jhs.add("b");
        jhs.add("c");
        jhs.add("d");
        jhs.add("e");
        jhs.add("f");
        Assertions.assertTrue(jhs.contains("c"));
        Assertions.assertFalse(jhs.contains("t"));
        Assertions.assertEquals(6, jhs.getSize());
    }

    @Test
    public void shouldIgnoreDuplicate() {
        jhs.add("a");
        jhs.add("a");
        Assertions.assertEquals("a", jhs.toString());
    }

//    @Test
//    public void shouldAllowToAddNull() {
//        jhs.add(null);
//        jhs.add("a");
//        Assertions.assertEquals("null a", jhs.toString());
//    }
}
