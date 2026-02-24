package tdd;

import java.util.Stack;

public class MinMaxStackImpl implements MinMaxStack {
    private final Stack<Integer> stack = new Stack<>();
    private int max = Integer.MIN_VALUE;
    private int min = Integer.MAX_VALUE;
    @Override
    public void push(int value) {
        if (this.max < value) {
            this.max = value;
        }
        if (this.min > value) {
            this.min = value;
        }
        this.stack.push(value);
    }

    @Override
    public int pop() {
        if (this.stack.isEmpty()) {
            throw new IllegalStateException();
        }
        if (this.stack.peek() == this.max) {
            int newMax = Integer.MIN_VALUE;
            for (int i = 0; i < this.stack.size()-1; i++) {
                if (newMax < this.stack.get(i)) {
                    newMax = this.stack.get(i);
                }
            }
            this.max = newMax;
        }
        if (this.stack.peek() == this.min) {
            int newMin = Integer.MAX_VALUE;
            for (int i = 0; i < this.stack.size()-1; i++) {
                if (newMin > this.stack.get(i)) {
                    newMin = this.stack.get(i);
                }
            }
            this.min = newMin;
        }
        return this.stack.pop();
    }

    @Override
    public int peek() {
        if (this.stack.isEmpty()) {
            throw new IllegalStateException();
        }
        return this.stack.peek();
    }

    @Override
    public int getMin() {
        if (this.stack.isEmpty()) {
            throw new IllegalStateException();
        }
        return this.min;
    }

    @Override
    public int getMax() {
        if (this.stack.isEmpty()) {
            throw new IllegalStateException();
        }
        return this.max;
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public int size() {
        return this.stack.size();
    }
}
