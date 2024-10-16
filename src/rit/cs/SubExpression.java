package rit.cs;

/**
 * Represents the expressions that involve subtraction
 */
public class SubExpression implements Expression {
    /** the left node */
    private Expression left;
    /** the right node */
    private Expression right;

    /**
     * The SubExpression constructor
     * @param left the left node
     * @param right the right node
     */
    public SubExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Subtracts the values of the left and right nodes
     * @return the sum of the left and right nodes
     */
    public int evaluate() {
        return left.evaluate() - right.evaluate();
    }

    /**
     * Returns the subtraction string of the left and right nodes
     * @return the subtraction string of the left and right nodes
     */
    public String emit() {
        return "(" + left.emit() + " - " + right.emit() + ")";
    }
}
