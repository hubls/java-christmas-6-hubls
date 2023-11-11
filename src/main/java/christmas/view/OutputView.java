package christmas.view;

import christmas.util.OrderSummary;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class OutputView {
    private static final String BENEFITS_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String OUTPUT_MENU = "%s %d개";
    private static final String KOREA_WON = "원";
    private DecimalFormat decimalFormat = new DecimalFormat("#,###");

    public void outputBenefitsMessage(int visitDay) {
        System.out.println(String.format(BENEFITS_MESSAGE, visitDay));
        System.out.println();
    }

    public void outputOrderMenus(HashMap<String, Integer> orderMenus) {
        System.out.println(OrderSummary.ORDER_MENU.getLabel());
        for (Map.Entry<String, Integer> entry : orderMenus.entrySet()) {
            String menuName = entry.getKey();
            int numberOfMenu = entry.getValue();
            System.out.println(String.format(OUTPUT_MENU, menuName, numberOfMenu));
        }
        System.out.println();
    }

    public void outputTotalAmountBeforeDiscount(int totalAmountBeforeDiscount) {
        System.out.println(OrderSummary.TOTAL_AMOUNT_BEFORE_DISCOUNT.getLabel());
        System.out.println(decimalFormat.format(totalAmountBeforeDiscount) + KOREA_WON);
        System.out.println();
    }

    public void outputGift(String gift) {
        System.out.println(OrderSummary.GIFT_MENU.getLabel());
        System.out.println(gift);
        System.out.println();
    }
}