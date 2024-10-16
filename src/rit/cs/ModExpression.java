package rit.cs;

/**
 * Represents the expressions that involve mod
 */
public class ModExpression implements Expression {
    /** the left node */
    private Expression left;
    /** the right node */
    private Expression right;

    /**
     * The ModExpression constructor
     * @param left the left node
     * @param right the right node
     */
    public ModExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Mods the values of the left and right nodes
     * @return the sum of the left and right nodes
     */
    public int evaluate() {
        return left.evaluate() % right.evaluate();
    }

    /**
     * Returns the mod string of the left and right nodes
     * @return the mod string of the left and right nodes
     */
    public String emit() {
        return "(" + left.emit() + " % " + right.emit() + ")";
    }
}