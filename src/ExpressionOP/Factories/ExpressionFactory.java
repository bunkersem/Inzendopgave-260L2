package ExpressionOP.Factories;

import ExpressionOP.Expressions.*;
import ExpressionOP.Expressions.Core.Expression;
import ExpressionOP.Operations.Operation;
import ExpressionOP.Operations.OperationType;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by Sem on 25-Jul-17.
 */
public class ExpressionFactory {
    public static Expression createExpression(Operation operation) {
        return createExpression(operation, null, null);
    }
    public static Expression createExpression(Operation operation, Expression child) {
        return createExpression(operation, child, null);
    }
    public static Expression createExpression(Operation operation, Expression child1, Expression child2) {
        switch (operation.getType()) {

            case DIVISION:
                return new DivisionExpression(child1, child2);
            case MULTIPLICATION:
                return new MultiplicationExpression<>(child1, child2);
            case SUBTRACTION:
                return new SubtractionExpression(child1, child2);
            case SUMMATION:
                return new SummationExpression(child1, child2);
            case VALUE:
                return new ValueExpression(operation.getVal());
            default:
                throw new NotImplementedException();
        }
    }
}
