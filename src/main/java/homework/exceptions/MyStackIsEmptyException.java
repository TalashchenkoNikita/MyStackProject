package homework.exceptions;

public class MyStackIsEmptyException extends Exception{
    @Override
    public String getMessage() {
        return "Stack is empty";
    }
}
