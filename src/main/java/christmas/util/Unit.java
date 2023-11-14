package christmas.util;

import java.text.DecimalFormat;

public class Unit {
    public static final String KOREA_WON = "원";
    public static final DecimalFormat decimalFormat = new DecimalFormat("#,###");
    public static final String NOTHING = "없음";
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static final int STANDARD_AMOUNT = 120000;
    public static final int DISCOUNT_STANDARD_AMOUNT = 10000;
    public static final String NUMBER_OF_GIFT = " 1개";
    private Unit() {

    }
}
