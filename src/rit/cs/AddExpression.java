package rit.cs;

/**
 * Represents the expressions that involve addition
 */
public class AddExpression implements Expression {
    /** the left node */
    private Expression left;
    /** the right node */
    private Expression right;

    /**
     * The AddExpression constructor
     * @param left the left node
     * @param right the right node
     */
    public AddExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Adds the values of the left and right nodes
     * @return the sum of the left and right nodes
     */
    public int evaluate() {
        return left.evaluate() + right.evaluate();
    }

    /**
     * Returns the addition string of the left and right nodes
     * @return the addition string of the left and right nodes
     */
    public String emit() {
        return "(" + left.emit() + " + " + right.emit() + ")";
    }
}
