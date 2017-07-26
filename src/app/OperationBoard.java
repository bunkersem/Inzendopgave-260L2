package app;

import ExpressionOP.Operations.Operation;
import app.actions.Action;

import java.util.ArrayList;

/**
 * Created by Sem on 24-Jul-17.
 */
public class OperationBoard {
    private Action[][] operations;
    private ArrayList<Operation> currentExpression = new ArrayList<>();

    public OperationBoard(Action[][] operations) {
        this.operations = operations;
    }

    public Action[][] getAction() {
        return operations;
    }

    public ArrayList<Operation> getCurrentExpression() {
        return currentExpression;
    }

    public void evaluateAction(Action action){
        currentExpression = action.doAction(currentExpression);

    }

    public String getStringifiedExpression() {
        return currentExpression
                .stream()
                .map(o -> Helpers.getOperationName(o))
                .reduce("", (acc, s) -> acc + s);
    }

}

