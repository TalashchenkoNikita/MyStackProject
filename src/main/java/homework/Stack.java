package homework;

import homework.exceptions.MyStackIsEmptyException;
import homework.exceptions.MyStackOverflowException;

import java.util.Optional;

class Stack implements Stackable {
    private int mSize;
    private int[] stackArray;
    private int top;

    public Stack(int m) {
        this.mSize = m;
        stackArray = new int[mSize];
        top = -1;
    }

    public void addElement(int element) throws MyStackOverflowException {
        if (top >= mSize - 1) {
            throw new MyStackOverflowException();
        }
        stackArray[++top] = element;
    }

    public int deleteElement() throws MyStackIsEmptyException {
        if (top == -1) {
            throw new MyStackIsEmptyException();
        }
        return stackArray[top--];
    }

    public Optional<Integer> deleteOptionalElement() throws MyStackIsEmptyException {
        if (top == -1) {
            throw new MyStackIsEmptyException();
        }
        return Optional.of(stackArray[top--]);
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
