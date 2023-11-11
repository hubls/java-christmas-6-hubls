package christmas.model;

import christmas.util.MenuType;

import java.util.HashMap;
import java.util.Map;

public class Receipt {
    private static final int STANDARD_AMOUNT = 120000;
    private static final String NUMBER_OF_GIFT = " 1개";
    private final HashMap<String, Integer> orderMenus;
    private final int totalAmountBeforeDiscount;

    public Receipt(HashMap<String, Integer> orderMenus) {
        this.orderMenus = orderMenus;
        this.totalAmountBeforeDiscount = calculateTotalAmountBeforeDiscount();
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
}
