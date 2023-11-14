package christmas.model;

import static christmas.util.MiscItems.KOREA_WON;
import static christmas.util.MiscItems.decimalFormat;
import static christmas.util.MiscItems.LINE_SEPARATOR;

public class SpecialBenefit {
    private static final String SPECIAL_DISCOUNT_MESSAGE = "특별 할인: ";
    private static final int DISCOUNT_UNIT = -1000;
    private int specialDiscount = 0;
    private String specialDiscountText = "";

    public void calculate(int visitDay) {
        if (DayType.isSpecialDay(visitDay)) {
            specialDiscount = DISCOUNT_UNIT;
        }
    }

    public void makeSpecialDiscountText() {
        if (specialDiscount != 0) {
            specialDiscountText = SPECIAL_DISCOUNT_MESSAGE + decimalFormat.format(specialDiscount) + KOREA_WON + LINE_SEPARATOR;
        }
    }

    public String getSpecialDiscountText() {
        return specialDiscountText;
    }

    public int getSpecialDiscount() {
        return specialDiscount;
    }
}
