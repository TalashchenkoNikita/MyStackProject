package homework;

import java.util.EmptyStackException;

class Stack implements Stackable {
    private int mSize;
    private int[] stackArray;
    private int top;

    public Stack(int m) {
        this.mSize = m;
        stackArray = new int[mSize];
        top = -1;
    }

    public void addElement(int element) throws StackOverflowError {
        if (top >= mSize - 1) {
            throw new StackOverflowError();
        }
        stackArray[++top] = element;
    }

    public int deleteElement() throws EmptyStackException {
        if (top == -1) {
            throw new EmptyStackException();
        }
        return stackArray[top--];
    }

    public int readTop() {
        return stackArray[top];

    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == mSize - 1);
    }
}
