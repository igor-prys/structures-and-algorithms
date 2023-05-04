package org.example.structures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomStackTest {
    private CustomStack<Integer> customStack;

    @BeforeEach
    public void addElements() {
        customStack = new CustomStack<>();
        customStack.push(1);
        customStack.push(2);
        customStack.push(3);
    }

    @Test
    public void shouldCheckMethodPush() {
        customStack.push(4);
        customStack.push(5);
        Assertions.assertEquals("1 2 3 4 5", customStack.toString());
    }

    @Test
    public void shouldCheckMethodPop() {
        customStack.pop();
        Assertions.assertEquals("1 2", customStack.toString());
        Assertions.assertEquals(2, customStack.pop());
    }

    @Test
    public void shouldCheckMethodPeek() {
        Assertions.assertEquals(3, customStack.peek());
    }

    @Test
    public void shouldCheckMethodIsEmpty() {
        customStack = new CustomStack<>();
        Assertions.assertTrue(customStack.isEmpty());
    }

    @Test
    public void shouldCheckMethodIsFull() {
        customStack = new CustomStack<>(3);
        customStack.push(1);
        customStack.push(2);
        customStack.push(3);
        Assertions.assertTrue(customStack.isFull());
    }

    @Test
    public void shouldCheckExceptionInMethodPush() {
        customStack = new CustomStack<>(3);
        customStack.push(1);
        customStack.push(2);
        customStack.push(3);
        Exception e = Assertions.assertThrows(RuntimeException.class, () -> customStack.push(4));
        Assertions.assertNotNull(e);
        Assertions.assertEquals("Stack is full", e.getMessage());
    }

    @Test
    public void shouldCheckExceptionInMethodPop() {
        customStack = new CustomStack<>();
        Exception e = Assertions.assertThrows(RuntimeException.class, () -> customStack.pop());
        Assertions.assertNotNull(e);
        Assertions.assertEquals("Stack is empty", e.getMessage());
    }
}
