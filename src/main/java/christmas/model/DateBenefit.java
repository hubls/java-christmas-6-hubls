package christmas.model;

import christmas.util.MenuType;

import java.util.HashMap;

import static christmas.model.DayType.WEEKDAY;
import static christmas.model.DayType.WEEKEND;
import static christmas.util.Unit.*;

public class DateBenefit {
    private static final String WEEKDAY_DISCOUNT_MESSAGE = "평일 할인: ";
    private static final String WEEKEND_DISCOUNT_MESSAGE = "주말 할인: ";
    private static final int DISCOUNT_UNIT = 2023;
    private int dateDiscount = 0;
    private String dateDiscountText = "";


    public void calculate(int visitDay, HashMap<String, Integer> orders) {
        if (DayType.getDayType(visitDay) == WEEKDAY) {
            calculateWeekdayDiscount(orders);
        }

        if (DayType.getDayType(visitDay) == WEEKEND) {
            calculateWeekendDiscount(orders);
        }
    }

    private void calculateWeekdayDiscount(HashMap<String, Integer> orders) {
        for (String menuName : orders.keySet()) {
            MenuType menuType = getMenuTypeByName(menuName);

            if (menuType != null && menuType.name().startsWith("DESSERT_")) {
                int quantity = orders.get(menuName);
                this.dateDiscount -= quantity * DISCOUNT_UNIT;
            }
        }
    }

    private void calculateWeekendDiscount(HashMap<String, Integer> orders) {
        for (String menuName : orders.keySet()) {
            MenuType menuType = getMenuTypeByName(menuName);

            if (menuType != null && menuType.name().startsWith("MAIN_")) {
                int quantity = orders.get(menuName);
                this.dateDiscount -= quantity * DISCOUNT_UNIT;
            }
        }
    }

    private MenuType getMenuTypeByName(String menuName) {
        for (MenuType menuType : MenuType.values()) {
            if (menuType.getMenuName().equals(menuName)) {
                return menuType;
            }
        }
        return null;
    }

    public void makeDateDiscountText(int visitDay) {
        if (dateDiscount != 0 && DayType.getDayType(visitDay) == WEEKDAY) {
            dateDiscountText = WEEKDAY_DISCOUNT_MESSAGE + decimalFormat.format(dateDiscount) + KOREA_WON + LINE_SEPARATOR;
        }

        if (dateDiscount != 0 && DayType.getDayType(visitDay) == WEEKEND) {
            dateDiscountText = WEEKEND_DISCOUNT_MESSAGE + decimalFormat.format(dateDiscount) + KOREA_WON + LINE_SEPARATOR;
        }
    }

    public String getDateDiscountText() {
        return dateDiscountText;
    }
    public int getDateDiscount() {
        return dateDiscount;
    }
}
