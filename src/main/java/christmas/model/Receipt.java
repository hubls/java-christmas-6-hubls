package christmas.model;

import christmas.util.MenuType;

import java.util.HashMap;
import java.util.Map;

public class Receipt {
    private final HashMap<String, Integer> orderMenus;

    public Receipt(HashMap<String, Integer> orderMenus) {
        this.orderMenus = orderMenus;
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
}
