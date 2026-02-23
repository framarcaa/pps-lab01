package tdd;

import java.util.Stack;

public class MinMaxStackImpl implements MinMaxStack {
    private Stack<Integer> stack = new Stack<>();
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
        if (this.stack.peek() == this.max) {
            int newMax = Integer.MIN_VALUE;
            for (int i = 0; i < this.stack.size()-1; i++) {
                if (newMax < this.stack.get(i)) {
                    newMax = this.stack.get(i);
                }
            }
            this.max = newMax;
        }
        return this.stack.pop();
    }

    @Override
    public int peek() {
        return this.stack.peek();
    }

    @Override
    public int getMin() {
        return this.min;
    }

    @Override
    public int getMax() {
        return this.max;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
