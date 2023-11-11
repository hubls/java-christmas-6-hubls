package christmas.controller;

import christmas.util.MenuParser;
import christmas.util.Validator;
import christmas.view.ErrorView;
import christmas.view.InputView;

import java.util.HashMap;
import java.util.List;

public class EventPlannerController {
    private InputView inputView = new InputView();
    private ErrorView errorView = new ErrorView();

    public void start() {
        inputView.printStartMessage();
        int visitDay = receiveInputVisitDay();
        HashMap<String, Integer> menu = receiveMenu();
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

    private HashMap<String, Integer> receiveMenu() {
        String menuText = inputView.inputMenu();

        while (true) {
            try {
                HashMap<String, Integer> menus = parseMenu(menuText);
                return menus;
            } catch (IllegalArgumentException e) {
                menuText = errorView.repeatInputMenu();
            }
        }
    }

    private HashMap<String, Integer> parseMenu(String menuText) {
        return MenuParser.convertHashMap(menuText);
    }
}
