package ExpressionOP.Expressions;

import ExpressionOP.Expressions.Core.NihilExpression;

/**
 * Created by Sem on 25-Jul-17.
 */
public class ValueExpression extends NihilExpression {
    private float value;

    public ValueExpression (float val) {
        this.value = val;
    }

    @Override
    public float resolve() {
        return value;
    }
}
