package christmas.util;

import java.util.HashMap;
import java.util.List;

public class OrdersParser {
    private static final String COMMA = ",";
    private static final String HYPHEN = "-";
    private static final int MENU_NAME = 0;
    private static final int NUMBER_OF_MENU = 1;

    public static HashMap<String, Integer> convertHashMap(String ordersText) {
        List<String> ordersParsedWithComma = commaParser(ordersText);
        HashMap<String, Integer> ordersParsedWithHyphen = hyphenParser(ordersParsedWithComma);
        return ordersParsedWithHyphen;
    }

    private static List<String> commaParser(String ordersText) {
        return List.of(ordersText.split(COMMA));
    }

    private static HashMap<String, Integer> hyphenParser(List<String> orders) {
        HashMap<String, Integer> parsedOrders = new HashMap<>();

        for (String order : orders) {
            List<String> orderDetails = List.of(order.split(HYPHEN));

            String menuName = orderDetails.get(MENU_NAME);
            int numberOfMenu = Integer.parseInt(orderDetails.get(NUMBER_OF_MENU));

            parsedOrders.put(menuName, numberOfMenu);
        }

        return parsedOrders;
    }
}
