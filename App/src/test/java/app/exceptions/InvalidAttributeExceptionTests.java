package app.exceptions;

import app.exceptions.InvalidAttributeException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InvalidAttributeExceptionTests {

    @Test
    void shouldThrowDefaultMessageOnNoArgConstructor() {
        Exception exception = assertThrows(InvalidAttributeException.class, () -> {
            throw new InvalidAttributeException();
        });

        String actualMessage = exception.getMessage();

        assertNull(actualMessage);
    }

    @Test
    void shouldThrowCustomMessageOnStringArgConstructor() {
        String expectedMessage = "Custom message";
        Exception exception = assertThrows(InvalidAttributeException.class, () -> {
            throw new InvalidAttributeException(expectedMessage);
        });

        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void shouldThrowCauseOnThrowableArgConstructor() {
        Throwable cause = new Throwable("Cause");
        Exception exception = assertThrows(InvalidAttributeException.class, () -> {
            throw new InvalidAttributeException(cause);
        });

        assertEquals(cause, exception.getCause());
    }

    @Test
    void shouldThrowMessageAndCauseOnStringAndThrowableArgConstructor() {
        String expectedMessage = "Custom message";
        Throwable cause = new Throwable("Cause");
        Exception exception = assertThrows(InvalidAttributeException.class, () -> {
            throw new InvalidAttributeException(expectedMessage, cause);
        });

        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
        assertEquals(cause, exception.getCause());
    }
}

