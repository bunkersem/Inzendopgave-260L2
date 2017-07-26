package app.actions;

import ExpressionOP.Operations.Operation;
import app.Core;
import app.Helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static app.Core.last;

/**
 * Created by Sem on 25-Jul-17.
 */
public class OperatorAction extends DynamicAction {
    public OperatorAction(Operation operation) {
        super(operation);
    }

    @Override
    public ArrayList<Operation> doAction(ArrayList<Operation> infixExpression) {
        if (last(infixExpression) != null && Arrays.asList(Operation.operators).contains(last(infixExpression).getType())) {
            // The operation before this one is also an operator.
            // So replace it.

            infixExpression.set(infixExpression.size() - 1, operation);
        }
        else {
            // Normal situation
            infixExpression.add(operation);
        }

        return infixExpression;
    }
}

