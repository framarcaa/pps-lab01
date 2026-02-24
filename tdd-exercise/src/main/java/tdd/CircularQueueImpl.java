package tdd;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CircularQueueImpl implements CircularQueue {
    private final Queue<Integer> timeQueue =  new LinkedList<>();
    private final ArrayList<Integer> queue = new ArrayList<>();
    public final int CAPACITY = 3;
    @Override
    public void add(int value) {
        if (this.queue.size() < CAPACITY) {
            this.timeQueue.add(value);
            this.queue.add(value);
        } else {
            int index = this.queue.indexOf(this.timeQueue.remove());
            this.queue.set(index, value);
            this.timeQueue.add(value);
        }
    }

    @Override
    public int peek() {
        if (queue.isEmpty()) {
            throw new IllegalStateException();
        }
        return this.queue.get(0);
    }

    @Override
    public int size() {
        return this.queue.size();
    }

    @Override
    public int pop() {
        if (queue.isEmpty()) {
            throw new IllegalStateException();
        }
        this.timeQueue.remove();
        return this.queue.remove(0);
    }

    @Override
    public String toString() {
        return queue.toString(); // se usi una List interna
    }
}
