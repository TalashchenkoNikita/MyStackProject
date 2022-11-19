package homework;

import homework.exceptions.MyStackIsEmptyException;
import homework.exceptions.MyStackOverflowException;

public interface Stackable {

    public void addElement(int element) throws MyStackOverflowException;

    public int deleteElement() throws MyStackIsEmptyException;

    public int readTop();

    public boolean isEmpty();

    public boolean isFull();

}
