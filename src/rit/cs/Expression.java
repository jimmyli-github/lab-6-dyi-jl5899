package rit.cs;

/**
 * Represents an expression
 */
public interface Expression {
    /**
     * Evaluates the left and right node with the given operator
     * @return the value using the operator
     */
    public int evaluate();

    /**
     * Returns the string value of the expression
     * @return the string value of the expression
     */
    public String emit();
}
