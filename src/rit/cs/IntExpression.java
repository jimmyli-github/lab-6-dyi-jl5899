package rit.cs;

/**
 * Represents the integer in the expression
 */
public class IntExpression implements Expression {
    /** the value of the node */
    private int value;

    /**
     * The IntExpression constructor
     * @param value the value of the node
     */
    public IntExpression(int value) {
        this.value = value;
    }

    /**
     * Returns the value of the node
     * @return the value of the node
     */
    public int evaluate() {
        return value;
    }

    /**
     * Returns the value string of the node
     * @return the value string of the node
     */
    public String emit() {
        return String.valueOf(value);
    }
}
