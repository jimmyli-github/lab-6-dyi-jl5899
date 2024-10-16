package rit.cs;

/**
 * Represents the expressions that involve multiplications
 */
public class MulExpression implements Expression {
    /** the left node */
    private Expression left;
    /** the right node */
    private Expression right;

    /**
     * The MulExpression constructor
     * @param left the left node
     * @param right the right node
     */
    public MulExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Multiplies the values of the left and right nodes
     * @return the sum of the left and right nodes
     */
    public int evaluate() {
        return left.evaluate() * right.evaluate();
    }

    /**
     * Returns the multiplication string of the left and right nodes
     * @return the multiplication string of the left and right nodes
     */
    public String emit() {
        return "(" + left.emit() + " * " + right.emit() + ")";
    }
}
