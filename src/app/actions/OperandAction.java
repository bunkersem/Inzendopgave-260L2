package app.actions;

import ExpressionOP.Factories.OperationFactory;
import ExpressionOP.Operations.Operation;
import ExpressionOP.Operations.OperationType;
import static app.Core.*;
import static app.Helpers.getOperationName;

import app.Helpers;

import java.util.ArrayList;

/**
 * Created by Sem on 25-Jul-17.
 */
public class OperandAction extends DynamicAction {
    public OperandAction(Operation operation) {
        super(operation);
    }

    @Override
    public ArrayList<Operation> doAction(ArrayList<Operation> infixExpression) {
        if (last(infixExpression) != null && last(infixExpression).getType() == OperationType.VALUE )
        {
            float concatenated = Float.parseFloat ( getOperationName( last(infixExpression)) + getOperationName( operation) );
            Operation concatedValueOperand = OperationFactory.createOperand(concatenated);
            infixExpression.set(infixExpression.size() - 1, concatedValueOperand);
        }
        else {
            infixExpression = super.doAction(infixExpression);
        }
        return infixExpression;
    }
}

