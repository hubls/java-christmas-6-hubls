package christmas.view;

import java.util.HashMap;
import java.util.Map;

public class OutputView {
    private static final String BENEFITS_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDERS_MENU = "<주문 메뉴>";
    private static final String OUTPUT_MENU = "%s %d개";

    public void outputBenefitsMessage(int visitDay) {
        System.out.println(String.format(BENEFITS_MESSAGE, visitDay));
        System.out.println();
    }

    public void outputOrderMenus(HashMap<String, Integer> orderMenus) {
        System.out.println(ORDERS_MENU);
        for (Map.Entry<String, Integer> entry : orderMenus.entrySet()) {
            String menuName = entry.getKey();
            int numberOfMenu = entry.getValue();
            System.out.println(String.format(OUTPUT_MENU, menuName, numberOfMenu));
        }
    }
}
