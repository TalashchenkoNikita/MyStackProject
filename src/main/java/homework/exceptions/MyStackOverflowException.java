package homework.exceptions;

public class MyStackOverflowException extends Exception{
    @Override
    public String getMessage() {
        return "Stack overflow";
    }
}
