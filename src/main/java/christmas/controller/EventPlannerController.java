package christmas.controller;

import christmas.model.Receipt;
import christmas.util.OrdersParser;
import christmas.util.OrdersValidator;
import christmas.util.VisitDayValidator;
import christmas.view.ErrorView;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.HashMap;

public class EventPlannerController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private ErrorView errorView = new ErrorView();
    private Receipt receipt;

    public void start() {
        printStartMessage();
        int visitDay = receiveInputVisitDay();
        HashMap<String, Integer> orders = receiveOrders();

        printBenefitsMessage(visitDay);
        printOrderMenus(orders);

        initializeReceipt(orders, visitDay);
        printTotalAmountBeforeDiscount();
        printGift();
        printBenefits();
        printBenefitsAmount();
        printTotalAmountAfterDiscount();
        printBadge();
    }

    private void printStartMessage() {
        inputView.printStartMessage();
    }

    private int receiveInputVisitDay() {
        String visitDayText = inputView.inputVisitDay();

        while (true) {
            try {
                VisitDayValidator.validateVisitDay(visitDayText);
                return Integer.parseInt(visitDayText);
            } catch (IllegalArgumentException e) {
                visitDayText = errorView.repeatInputVisitDay();
            }
        }
    }

    private HashMap<String, Integer> receiveOrders() {
        String ordersText = inputView.inputOrders();

        while (true) {
            try {
                HashMap<String, Integer> orders = parseOrders(ordersText);
                return orders;
            } catch (IllegalArgumentException e) {
                ordersText = errorView.repeatInputOrders();
            }
        }
    }

    private HashMap<String, Integer> parseOrders(String ordersText) {
        OrdersValidator.validateOrders(ordersText);
        return OrdersParser.convertHashMap(ordersText);
    }

    private void printBenefitsMessage(int visitDay) {
        outputView.outputBenefitsMessage(visitDay);
    }

    private void printOrderMenus(HashMap<String, Integer> orders) {
        outputView.outputOrderMenus(orders);
    }

    private void initializeReceipt(HashMap<String, Integer> orders, int visitDay) {
        receipt = new Receipt(orders, visitDay);
    }

    private void printTotalAmountBeforeDiscount() {
        int totalAmountBeforeDiscount = receipt.calculateTotalAmountBeforeDiscount();
        outputView.outputTotalAmountBeforeDiscount(totalAmountBeforeDiscount);
    }

    private void printGift() {
        String gift = receipt.isOverStandardAmount();
        outputView.outputGift(gift);
    }

    private void printBenefits() {
        String benefits = receipt.getBenefits();
        outputView.outputBenefit(benefits);
    }

    private void printBenefitsAmount() {
        String benefitsAmount = receipt.getBenefitsAmountText();
        outputView.outputBenefitsAmount(benefitsAmount);
    }

    private void printTotalAmountAfterDiscount() {
        String totalAmountAfterDiscount = receipt.getTotalAmountBeforeDiscountText();
        outputView.outputTotalAmountAfterDiscount(totalAmountAfterDiscount);
    }

    private void printBadge() {
        String badge = receipt.getBadgeText();
        outputView.outputBadge(badge);
    }
}
