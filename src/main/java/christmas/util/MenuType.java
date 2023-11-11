package christmas.util;

import java.util.ArrayList;
import java.util.List;

public enum MenuType {
    APPETIZER_PINE_MUSHROOM_SOUP("양송이수프", 6_000),
    APPETIZER_TAPAS("타파스", 5_500),
    APPETIZER_CAESAR_SALAD("시저샐러드", 8_000),

    MAIN_T_BONE_STEAK("티본스테이크", 55_000),
    MAIN_BBQ_RIBS("바비큐립", 54_000),
    MAIN_SEAFOOD_PASTA("해산물파스타", 35_000),
    MAIN_CHRISTMAS_PASTA("크리스마스파스타", 25_000),

    DESSERT_CHOCO_CAKE("초코케이크", 15_000),
    DESSERT_ICE_CREAM("아이스크림", 50_00),

    BEVERAGE_ZERO_COLA("제로콜라", 3_000),
    BEVERAGE_RED_WINE("레드와인", 60_000),
    BEVERAGE_CHAMPAGNE("샴페인", 25_000),

    NOTHING("없음", 0);

    private final String menuName;
    private final int price;

    MenuType(String menuName, int price) {
        this.menuName = menuName;
        this.price = price;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getPrice() {
        return price;
    }

    public static List<String> getBeverageMenuNames() {
        List<String> beverageMenuNames = new ArrayList<>();

        for (MenuType menuType : MenuType.values()) {
            if (menuType.name().startsWith("BEVERAGE_")) {
                beverageMenuNames.add(menuType.getMenuName());
            }
        }

        return beverageMenuNames;
    }
}
