package rit.cs;

/**
 * Represents the variables in the expression
 */
public class VariableExpression implements Expression {
    /** the variable in the node */
    private String identifier;
    /** the value of the variable */
    private int value;

    /**
     * The VariableExpression constructor
     * @param identifier the variable in the node
     * @param value the value of the variable
     */
    public VariableExpression(String identifier, int value) {
        this.identifier = identifier;
        this.value = value;
    }

    /**
     * Returns the value of the variable
     * @return the value of the variable
     */
    public int evaluate() {
        return value;
    }

    /**
     * the variable in the node
     * @return the variable in the node
     */
    public String emit() {
        return identifier;
    }
}
