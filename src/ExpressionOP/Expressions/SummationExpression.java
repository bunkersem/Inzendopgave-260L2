package ExpressionOP.Expressions;

import ExpressionOP.Expressions.Core.BinaryExpression;
import ExpressionOP.Expressions.Core.Expression;

/**
 * Created by Sem on 25-Jul-17.
 */
public class SummationExpression extends BinaryExpression {

    public SummationExpression(Expression child1, Expression child2) {
        super(child1, child2);
    }

    @Override
    public float resolve() {
        return child1.resolve() + child2.resolve();
    }
}
