package ExpressionOP.Expressions.Core;

/**
 * Created by Sem on 25-Jul-17.
 */
public abstract class MonoExpression extends Expression {
    protected Expression child;

    public MonoExpression (Expression child) {
        this.child = child;
    }
}
