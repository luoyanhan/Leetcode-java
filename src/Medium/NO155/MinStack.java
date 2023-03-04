package Medium.NO155;

import java.util.ArrayDeque;
import java.util.Deque;

class MinStack {
    private Deque<Integer> dataStack;
    private Deque<Integer> minDataStack;

    public MinStack() {
        this.dataStack = new ArrayDeque<>();
        this.minDataStack = new ArrayDeque<>();
    }

    public void push(int val) {
        this.dataStack.push(val);
        int nextMin = val;
        if (!this.minDataStack.isEmpty()){
            int curMin = this.minDataStack.peek();
            nextMin = Math.min(nextMin, curMin);
        }
        this.minDataStack.push(nextMin);
    }

    public void pop() {
        this.dataStack.pop();
        this.minDataStack.pop();
    }

    public int top() {
        return this.dataStack.peek();
    }

    public int getMin() {
        return this.minDataStack.peek();
    }
}

