package homework;

import homework.exceptions.MyStackIsEmptyException;
import homework.exceptions.MyStackOverflowException;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.InstanceOfAssertFactories.OPTIONAL;

class StackTest {

    Stack stack = new Stack(2);


    @Test
    void shouldAddElement() throws MyStackOverflowException {
        stack.addElement(4);
        assertThat(stack.isEmpty()).isEqualTo(false);
    }

    @Test
    void shouldThrowExceptionWhenAddElement() throws MyStackOverflowException {
        stack.addElement(4);
        stack.addElement(5);
        Throwable thrown = catchThrowable(() -> {
            stack.addElement(6);
        });
        assertThat(thrown).isInstanceOf(StackOverflowError.class);
    }

    @Test
    void shouldDeleteElement() throws MyStackOverflowException, MyStackIsEmptyException {
        stack.addElement(4);
        stack.deleteElement();
        assertThat(stack.isEmpty()).isEqualTo(true);
    }

    @Test
    void shouldDeleteOptionalElement() throws MyStackOverflowException, MyStackIsEmptyException {
        stack.addElement(4);
        stack.deleteOptionalElement();
        assertThat(stack.isEmpty()).isEqualTo(true);
    }

    @Test
    void shouldBeOptionalElement() throws MyStackOverflowException, MyStackIsEmptyException {
        stack.addElement(4);
        assertThat(stack.deleteOptionalElement()).isInstanceOf(Optional.class);
    }

    @Test
    void shouldThrowExceptionWhenDeleteElement() {
        Throwable thrown = catchThrowable(() -> {
            stack.deleteElement();
        });
        assertThat(thrown).isInstanceOf(EmptyStackException.class);
    }

    @Test
    void shouldReadTop() throws MyStackOverflowException {
        stack.addElement(4);
        assertThat(stack.readTop()).isEqualTo(4);
    }

    @Test
    void shouldCheckIsEmpty() {
        assertThat(stack.isEmpty()).isEqualTo(true);
    }

    @Test
    void shouldCheckIsFull() throws MyStackOverflowException {
        stack.addElement(4);
        stack.addElement(5);
        assertThat(stack.isFull()).isEqualTo(true);
    }


}