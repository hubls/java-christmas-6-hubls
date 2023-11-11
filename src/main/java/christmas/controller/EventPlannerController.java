package christmas.controller;

import christmas.util.Validator;
import christmas.view.ErrorView;
import christmas.view.InputView;

public class EventPlannerController {
    private InputView inputView = new InputView();
    private ErrorView errorView = new ErrorView();

    public void start() {
        inputView.printStartMessage();
        int visitDay = receiveInputVisitDay();
    }

    private int receiveInputVisitDay() {
        String visitDayText = inputView.inputVisitDay();

        while (true) {
            try {
                Validator.validateVisitDay(visitDayText);
                return Integer.parseInt(visitDayText);
            } catch (IllegalArgumentException e) {
                visitDayText = errorView.repeatInputVisitDay();
            }
        }
    }


}
