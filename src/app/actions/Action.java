package app.actions;

import ExpressionOP.Operations.Operation;
import java.util.ArrayList;

/**
 * Created by Sem on 25-Jul-17.
 */
public abstract class Action {
    public abstract String getName();
    public abstract ArrayList<Operation> doAction(ArrayList<Operation> infixExpression);
}

