package app.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComplaintNotFoundExceptionTest {

    @Test
    void shouldThrowDefaultMessageOnNoArgConstructor() {
        Exception exception = assertThrows(ComplaintNotFoundException.class, () -> {
            throw new ComplaintNotFoundException();
        });

        String actualMessage = exception.getMessage();

        assertNull(actualMessage);
    }

        @Test
        void shouldThrowCustomMessageOnStringArgConstructor() {
            String expectedMessage = "Custom message";
            Exception exception = assertThrows(ComplaintNotFoundException.class, () -> {
                throw new ComplaintNotFoundException(expectedMessage);
            });

            String actualMessage = exception.getMessage();

            assertTrue(actualMessage.contains(expectedMessage));
        }

        @Test
        void shouldThrowCauseOnThrowableArgConstructor() {
            Throwable cause = new Throwable("Cause");
            Exception exception = assertThrows(ComplaintNotFoundException.class, () -> {
                throw new ComplaintNotFoundException(cause);
            });

            assertEquals(cause, exception.getCause());
        }

        @Test
        void shouldThrowMessageAndCauseOnStringAndThrowableArgConstructor() {
            String expectedMessage = "Custom message";
            Throwable cause = new Throwable("Cause");
            Exception exception = assertThrows(ComplaintNotFoundException.class, () -> {
                throw new ComplaintNotFoundException(expectedMessage, cause);
            });

            String actualMessage = exception.getMessage();

            assertTrue(actualMessage.contains(expectedMessage));
            assertEquals(cause, exception.getCause());
        }
}
