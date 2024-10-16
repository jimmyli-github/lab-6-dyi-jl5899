package rit.stu;

/**
 * An exception class for problems that can arise while running DYI.
 *
 * @author RIT CS
 */
public class DerpException extends Exception {
    /**
     * Construct the exception.
     * @param msg a message
     */
    public DerpException(String msg) {
        super(msg);
    }
}
