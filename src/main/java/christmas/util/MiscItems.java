package christmas.util;

import java.text.DecimalFormat;

public class MiscItems {
    public static final String KOREA_WON = "원";
    public static final DecimalFormat decimalFormat = new DecimalFormat("#,###");
    public static final String NOTHING = "없음";
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static final int STANDARD_AMOUNT = 120000;
    public static final int DISCOUNT_STANDARD_AMOUNT = 10000;
    public static final String NUMBER_OF_GIFT = " 1개";
    public static final String BENEFITS_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    public static final String OUTPUT_MENU = "%s %d개";
    private MiscItems() {

    }
}
