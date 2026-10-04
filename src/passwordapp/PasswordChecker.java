package passwordapp;

/**
 * Validates a password and finds its largest block of identical characters.
 */
public class PasswordChecker {
    private final String password;

    /**
     * Creates a checker after validating the password.
     * @param password the password to check
     * @throws IllegalArgumentException if it has a space or is not 8 to 12 characters
     */
    public PasswordChecker(String password) {
        if (password == null || password.length() < 8 || password.length() > 12) {
            throw new IllegalArgumentException("Password must be 8 to 12 characters.");
        }
        if (password.contains(" ")) {
            throw new IllegalArgumentException("Password cannot contain spaces.");
        }
        this.password = password;
    }

    /**
     * Finds the longest run of adjacent identical characters (case sensitive).
     * @return the length of the largest block
     */
    public int largestBlock() {
        int max = 1;
        int run = 1;
        for (int i = 1; i < password.length(); i++) {
            if (password.charAt(i) == password.charAt(i - 1)) {
                run++;
            } else {
                run = 1;
            }
            max = Math.max(max, run);
        }
        return max;
    }

    /**
     * Builds the message shown to the user.
     * @return the result message
     */
    public String getMessage() {
        int max = largestBlock();
        String msg = "The largest block in the password is " + max + ". ";
        if (max <= 2) {
            return msg + "This is a decent password.";
        }
        return msg + "This password can be made stronger by reducing this block by "
                + (max - 2) + ".";
    }
}