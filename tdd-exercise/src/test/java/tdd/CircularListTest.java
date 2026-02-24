package tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    private CircularQueue queue;
    @BeforeEach
    public void init() {
        this.queue = new CircularQueueImpl();
    }
    @Test
    public void testPushValueInQueue() {
        this.queue.add(2);
        assertEquals(2, this.queue.peek());
    }

    @Test
    public void testAddingValueWhenQueueIsFull() {
        for (int i = 1; i < 5; i++) {
            this.queue.add(i);
        }
        assertEquals(3, this.queue.size());
        assertEquals(4, this.queue.peek());
    }

    @Test
    public void testAddingTwoValueWhenQueueIsFull() {
        for (int i = 1; i < 8; i++) {
            this.queue.add(i);
        }
        assertEquals(3, this.queue.size());
        assertEquals(7, this.queue.peek());
        assertEquals("[7, 5, 6]", queue.toString());
    }

    @Test
    public void testPoppingValueFromQueue() {
        for (int i = 1; i < 8; i++) {
            this.queue.add(i);
        }
        assertEquals(7, this.queue.pop());
        assertEquals("[5, 6]", queue.toString());
    }

    @Test
    public void testPoppingValueFromEmptyQueue() {
        Assertions.assertThrows(IllegalStateException.class, () -> this.queue.pop());
    }

     @Test
    public void testPeekingValueFromEmptyQueue() {
        Assertions.assertThrows(IllegalStateException.class, () -> this.queue.peek());
    }
}
