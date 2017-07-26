package app.actions;

import ExpressionOP.Operations.Operation;

import java.util.ArrayList;

/**
 * Created by Sem on 25-Jul-17.
 */
public class ClearAction extends Action{

    @Override
    public ArrayList<Operation> doAction(final ArrayList<Operation> infixExpression) {
        return new ArrayList<>();
    }

    @Override
    public String getName() {
        return "C";
    }
}
