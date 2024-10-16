package rit.cs;

/**
 * Represents the expressions that involve division
 */
public class DivExpression implements Expression {
    /** the left node */
    private Expression left;
    /** the right node */
    private Expression right;

    /**
     * The DivExpression constructor
     * @param left the left node
     * @param right the right node
     */
    public DivExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Divides the values of the left and right nodes
     * @return the sum of the left and right nodes
     */
    public int evaluate() {
        return left.evaluate() / right.evaluate();
    }

    /**
     * Returns the division string of the left and right nodes
     * @return the division string of the left and right nodes
     */
    public String emit() {
        return "(" + left.emit() + " / " + right.emit() + ")";
    }
}
