package passwordapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Tests for PasswordChecker.
 */
class PasswordCheckerTest {

    @Test
    void decentPassword() {
        assertEquals(2, new PasswordChecker("7hooplaa").largestBlock());
    }

    @Test
    void longBlock() {
        PasswordChecker pc = new PasswordChecker("xyyyyyyy2");
        assertEquals(7, pc.largestBlock());
        assertTrue(pc.getMessage().contains("reducing this block by 5"));
    }

    @Test
    void caseSensitive() {
        assertEquals(1, new PasswordChecker("aAaAaAaA").largestBlock());
    }

    @Test
    void tooShort() {
        assertThrows(IllegalArgumentException.class, () -> new PasswordChecker("abc"));
    }

    @Test
    void tooLong() {
        assertThrows(IllegalArgumentException.class, () -> new PasswordChecker("abcdefghijklm"));
    }

    @Test
    void containsSpace() {
        assertThrows(IllegalArgumentException.class, () -> new PasswordChecker("abcd efgh"));
    }
}