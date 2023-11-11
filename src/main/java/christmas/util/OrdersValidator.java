package christmas.util;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrdersValidator {
    private static final String ORDERS_REGEX = "^([가-힣A-Za-z]+)-([0-9]+)(?:,([가-힣A-Za-z]+)-([0-9]+))*$";
    private static final String ORDERS_DUPLICATE_REGEX = "([\\w가-힣]+)-(\\d+)";
    private static final int ORDER_MENU_NAME = 1;
    private static final int ORDER_NUMBER_OF_MENU = 2;

    public static void validateOrders(String ordersText) {
        validateOrderFormat(ordersText);
        validateMenuExistence(ordersText);
        validateDuplicate(ordersText);
    }

    private static void validateOrderFormat(String ordersText) {
        Pattern pattern = Pattern.compile(ORDERS_REGEX);
        Matcher matcher = pattern.matcher(ordersText);
        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateMenuExistence(String ordersText) {
        List<String> menus = getMenuNames();

        Pattern pattern = Pattern.compile(ORDERS_DUPLICATE_REGEX);
        Matcher matcher = pattern.matcher(ordersText);

        while (matcher.find()) {
            String menuName = matcher.group(ORDER_MENU_NAME);

            if (!menus.contains(menuName)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void validateDuplicate(String ordersText) {
        List<String> menus = getMenuNames();
        Set<String> uniqueMenuNames = new HashSet<>();

        Pattern pattern = Pattern.compile(ORDERS_DUPLICATE_REGEX);
        Matcher matcher = pattern.matcher(ordersText);

        while (matcher.find()) {
            String menuName = matcher.group(ORDER_MENU_NAME);

            if (!uniqueMenuNames.add(menuName) || !menus.contains(menuName)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static List<String> getMenuNames() {
        List<String> menuNames = new ArrayList<>();

        for (MenuType menuType : MenuType.values()) {
            menuNames.add(menuType.getMenuName());
        }

        return menuNames;
    }
}
