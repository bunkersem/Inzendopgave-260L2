package ExpressionOP.Expressions.Core;

/**
 * Created by Sem on 25-Jul-17.
 */
public abstract class BinaryExpression extends Expression {

    protected Expression child1;
    protected Expression child2;

    public BinaryExpression (Expression child1, Expression child2) {
        this.child1 = child1;
        this.child2 = child2;
    }
}
