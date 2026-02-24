package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {
    private MinMaxStack stack;

    @BeforeEach
    public void init() {
        this.stack = new MinMaxStackImpl();
    }
    @Test
    public void testFirstPushSetsMaxAndMin() {
        this.stack.push(1);
        assertEquals(1, this.stack.getMax());
        assertEquals(1, this.stack.getMin());
    }

    @Test
    public void testIfMaxIsPopped() {
        for (int i = 0; i < 3; i++) {
            this.stack.push(i);
        }
        assertEquals(2, this.stack.pop());
        assertEquals(1, this.stack.getMax());
    }

    @Test
    public void testIfMinIsPopped() {
        for (int i = 3; i > 0; i--) {
            this.stack.push(i);
        }
        assertEquals(1, this.stack.pop());
        assertEquals(2, this.stack.getMin());
    }

    @Test
    public void testNewMaxValuePush() {
        int value = 10;
        this.stack.push(value);
        assertEquals(value, this.stack.getMax());
        this.stack.push(value*value);
        assertEquals(value*value, this.stack.getMax());
    }

    @Test
    public void testPoppingFromEmptyStack() {
        assertThrows(IllegalStateException.class, this.stack::pop);
    }

    @Test
    public void testPeekingFromEmptyStack() {
        assertThrows(IllegalStateException.class, this.stack::peek);
    }

    @Test
    public void testGettingMaxFromEmptyStack() {
        assertThrows(IllegalStateException.class, this.stack::getMax);
    }

    @Test
    public void testGettingMinFromEmptyStack() {
        assertThrows(IllegalStateException.class, this.stack::getMin);
    }
}