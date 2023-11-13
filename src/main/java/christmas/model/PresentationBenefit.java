package christmas.model;

import christmas.util.MenuType;

import static christmas.util.Unit.*;

public class PresentationBenefit {
    private static final String PRESENTATION_BENEFIT_MESSAGE = "증정 이벤트: ";
    private int presentationDiscount = 0;
    private String presentationDiscountText = "";

    public void calculate(int totalAmountBeforeDiscount) {
        if (totalAmountBeforeDiscount > 120000) {
            presentationDiscount = -1 * MenuType.BEVERAGE_CHAMPAGNE.getPrice();
        }
    }

    public void makePresentationDiscountText() {
        presentationDiscountText = PRESENTATION_BENEFIT_MESSAGE + decimalFormat.format(presentationDiscount) + KOREA_WON + LINE_SEPARATOR;
    }

    public String getPresentationDiscountText() {
        return presentationDiscountText;
    }

    public int getPresentationDiscount() {
        return presentationDiscount;
    }
}
