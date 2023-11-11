package christmas.util;

public enum OrderSummary {
    ORDER_MENU("<주문 메뉴>"),
    TOTAL_AMOUNT_BEFORE_DISCOUNT("<할인 전 총주문 금액>"),
    GIFT_MENU("<증정 메뉴>"),
    BENEFIT_DETAILS("<혜택 내역>"),
    TOTAL_BENEFIT_AMOUNT("<총혜택 금액>"),
    FINAL_PAYMENT_AMOUNT("<할인 후 예상 결제 금액>"),
    DECEMBER_EVENT_BADGE("<12월 이벤트 배지>");

    private final String label;

    OrderSummary(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
