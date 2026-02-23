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
        this.stack.push(1);
        this.stack.push(10);
        this.stack.push(100);
        this.stack.pop();
        assertEquals(10, this.stack.getMax());
    }
}