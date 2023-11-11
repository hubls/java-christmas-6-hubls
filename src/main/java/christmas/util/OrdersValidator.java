package christmas.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrdersValidator {

    public static void validateOrders(String ordersText) {
        validateOrderFormat(ordersText);
    }

    private static void validateOrderFormat(String ordersText) {
        // <문자열1>-<숫자1>,<문자열2>-<숫자2>,...,<문자열n>-<숫자n> 검증
        Pattern pattern = Pattern.compile("^([가-힣A-Za-z]+)-([0-9]+)(?:,([가-힣A-Za-z]+)-([0-9]+))*$");
        Matcher matcher = pattern.matcher(ordersText);
        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }
    }


}
