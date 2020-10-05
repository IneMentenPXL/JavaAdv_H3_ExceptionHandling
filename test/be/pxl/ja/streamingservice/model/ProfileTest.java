package be.pxl.ja.streamingservice.model;

import be.pxl.ja.streamingservice.exception.InvalidDateException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfileTest {
    @Test
    public void throwsInvalidDateExceptionWhenDateOfBirthInFuture() {
        Profile profile = new Profile("Ine Menten");
        InvalidDateException exception = assertThrows(InvalidDateException.class, () -> {
            profile.setDateOfBirth(LocalDate.now().plusDays(2));
        });
        assertTrue(exception.getMessage().contains("past"));
    }
}
