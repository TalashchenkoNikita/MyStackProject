package homework;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class StackTest {

    Stack stack = new Stack(2);


    @Test
    void shouldAddElement() {
        stack.addElement(4);
        assertThat(stack.isEmpty()).isEqualTo(false);
    }

    @Test
    void shouldThrowExceptionWhenAddElement() {
        stack.addElement(4);
        stack.addElement(5);
        Throwable thrown = catchThrowable(() -> {
            stack.addElement(6);
        });
        assertThat(thrown).isInstanceOf(StackOverflowError.class);
    }

    @Test
    void shouldDeleteElement() {
        stack.addElement(4);
        stack.deleteElement();
        assertThat(stack.isEmpty()).isEqualTo(true);
    }

    @Test
    void shouldThrowExceptionWhenDeleteElement() {
        Throwable thrown = catchThrowable(() -> {
            stack.deleteElement();
        });
        assertThat(thrown).isInstanceOf(EmptyStackException.class);
    }

    @Test
    void shouldReadTop() {
        stack.addElement(4);
        assertThat(stack.readTop()).isEqualTo(4);
    }

    @Test
    void shouldCheckIsEmpty() {
        assertThat(stack.isEmpty()).isEqualTo(true);
    }

    @Test
    void shouldCheckIsFull() {
        stack.addElement(4);
        stack.addElement(5);
        assertThat(stack.isFull()).isEqualTo(true);
    }
}