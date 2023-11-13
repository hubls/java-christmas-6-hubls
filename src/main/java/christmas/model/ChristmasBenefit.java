package christmas.model;

import static christmas.util.Unit.*;

public class ChristmasBenefit {
    private static final int START_DAY = 1;
    private static final int LAST_DAY = 25;
    private static final String CHRISTMAS_DISCOUNT_MESSAGE = "크리스마스 디데이 할인: ";
    private int christmasDiscount = 0;
    private String christmasDiscountText = "";

    public void calculate(int visitDay) {
        if (visitDay > LAST_DAY) {
            return;
        }

        christmasDiscount = -1000;
        for (int day = START_DAY; day < visitDay; day++) {
            christmasDiscount += -100;
        }
    }

    public void makeChristmasDiscountText() {
        if (christmasDiscount != 0) {
            christmasDiscountText = CHRISTMAS_DISCOUNT_MESSAGE + decimalFormat.format(christmasDiscount) + KOREA_WON + LINE_SEPARATOR;
        }
    }

    public String getChristmasDiscountText() {
        return christmasDiscountText;
    }

    public int getChristmasDiscount() {
        return christmasDiscount;
    }
}
