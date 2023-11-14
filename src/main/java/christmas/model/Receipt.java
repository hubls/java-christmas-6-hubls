package christmas.model;

import christmas.util.MenuType;

import java.util.HashMap;
import java.util.Map;

import static christmas.util.Unit.LINE_SEPARATOR;
import static christmas.util.Unit.NOTHING;

public class Receipt {
    private static final int STANDARD_AMOUNT = 120000;
    private static final int DISCOUNT_STANDARD_AMOUNT = 10000;
    private static final String NUMBER_OF_GIFT = " 1개";
    private final HashMap<String, Integer> orderMenus;
    private final int totalAmountBeforeDiscount;
    private final int visitDay;
    private Benefits benefits = new Benefits();

    public Receipt(HashMap<String, Integer> orderMenus, int visitDay) {
        this.orderMenus = orderMenus;
        this.totalAmountBeforeDiscount = calculateTotalAmountBeforeDiscount();
        this.visitDay = visitDay;
    }

    public int calculateTotalAmountBeforeDiscount() {
        int totalAmount = 0;

        for (Map.Entry<String, Integer> entry : orderMenus.entrySet()) {
            String menuName = entry.getKey();
            int numberOfMenu = entry.getValue();

            int menuPrice = getMenuPrice(menuName);
            totalAmount += menuPrice * numberOfMenu;
        }

        return totalAmount;
    }

    private int getMenuPrice(String menuName) {
        for (MenuType menuType : MenuType.values()) {
            if (menuType.getMenuName().equals(menuName)) {
                return menuType.getPrice();
            }
        }
        throw new IllegalArgumentException();
    }

    public String isOverStandardAmount() {
        if (totalAmountBeforeDiscount >= STANDARD_AMOUNT) {
            return MenuType.BEVERAGE_CHAMPAGNE.getMenuName() + NUMBER_OF_GIFT;
        }

        return MenuType.NOTHING.getMenuName();
    }

    public String getBenefits() {
        if (totalAmountBeforeDiscount < DISCOUNT_STANDARD_AMOUNT) {
            return NOTHING + LINE_SEPARATOR;
        }

        benefits.calculate(orderMenus, visitDay, totalAmountBeforeDiscount);
        benefits.makeDiscountsText(visitDay);

        return benefits.getDiscountsText();
    }

    public String getBenefitsAmountText() {
        benefits.calculateBenefitsAmount();
        return benefits.getBenefitsAmountText();
    }
}
