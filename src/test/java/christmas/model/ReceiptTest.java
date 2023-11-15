package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.util.MenuType;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class ReceiptTest {

    @Test
    public void calculateTotalAmountBeforeDiscount_할인_전_총_주문_금액() {
        HashMap<String, Integer> orderMenus = new HashMap<>();
        orderMenus.put("티본스테이크", 2);
        orderMenus.put("초코케이크", 1);

        Receipt receipt = new Receipt(orderMenus, 1);

        assertThat(receipt.calculateTotalAmountBeforeDiscount())
                .isEqualTo(2 * MenuType.MAIN_T_BONE_STEAK.getPrice() + MenuType.DESSERT_CHOCO_CAKE.getPrice());
    }
}