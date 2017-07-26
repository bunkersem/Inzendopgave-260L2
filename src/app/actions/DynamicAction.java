package app.actions;

import ExpressionOP.Operations.Operation;
import app.Helpers;

import java.util.ArrayList;

/**
 * Created by Sem on 25-Jul-17.
 */
public abstract class DynamicAction extends Action {
    protected Operation operation;

    public DynamicAction(Operation operation) {
        this.operation = operation;
    }

    @Override
    public String getName() {
        return Helpers.getOperationName(operation);
    }

    @Override
    public ArrayList<Operation> doAction(ArrayList<Operation> infixExpression) {
        infixExpression.add(operation);
        return infixExpression;
    }
}
