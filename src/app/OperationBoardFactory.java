package app;

import ExpressionOP.Factories.OperationFactory;
import app.actions.*;

/**
 * Created by Sem on 24-Jul-17.
 */
public class OperationBoardFactory {
    public OperationBoard createOperationBoard() {
        return new OperationBoard(createOperations());
    }
    Action[][] createOperations(){
        Action[][] actions = new Action[4][4];
        actions[0][0] = new OperandAction(OperationFactory.createOperand(7));
        actions[0][1] = new OperandAction(OperationFactory.createOperand(8));
        actions[0][2] = new OperandAction(OperationFactory.createOperand (9));
        actions[0][3] = new OperatorAction(OperationFactory.createDivisionOperator());

        actions[1][0] = new OperandAction(OperationFactory.createOperand(4));
        actions[1][1] = new OperandAction(OperationFactory.createOperand (5));
        actions[1][2] = new OperandAction(OperationFactory.createOperand(6));
        actions[1][3] = new OperatorAction(OperationFactory.createMultiplicationOperator());

        actions[2][0] = new OperandAction(OperationFactory.createOperand (1));
        actions[2][1] = new OperandAction(OperationFactory.createOperand (2));
        actions[2][2] = new OperandAction(OperationFactory.createOperand(3));
        actions[2][3] = new OperatorAction(OperationFactory.createSummationOperator());

        actions[3][0] = new OperandAction(OperationFactory.createOperand (0));
        actions[3][1] = new ClearAction();
        actions[3][2] = new ResultAction();
        actions[3][3] = new OperatorAction(OperationFactory.createSubtractionOperator());

        return actions;
    }
}

