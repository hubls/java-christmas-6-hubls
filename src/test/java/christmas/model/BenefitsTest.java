package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class BenefitsTest {
    private Benefits benefits;

    @BeforeEach
    public void setUp() {
        benefits = new Benefits();
    }

    @Test
    public void calculate_총_혜택금액_문구() {
        HashMap<String, Integer> orders = new HashMap<>();
        orders.put("아이스크림", 2);

        int totalAmountBeforeDiscount = 5000 * 2;

        int visitDay = 6;

        benefits.calculate(orders, visitDay, totalAmountBeforeDiscount);
        benefits.calculateBenefitsAmount();

        assertThat(benefits.getBenefitsAmountText()).isEqualTo("-5,546원");
    }

    @Test
    public void getBadgeText_배지_없음_출력() {
        benefits.calculateBenefitsAmount();

        assertThat(benefits.getBadgeText()).isEqualTo(Badge.NOTHING.getName());
    }

    @Test
    public void getBadgeText_배지_별_출력() {
        HashMap<String, Integer> orders = new HashMap<>();
        orders.put("아이스크림", 2);

        int totalAmountBeforeDiscount = 5000 * 2;

        int visitDay = 6;

        benefits.calculate(orders, visitDay, totalAmountBeforeDiscount);
        benefits.calculateBenefitsAmount();

        assertThat(benefits.getBadgeText()).isEqualTo(Badge.STAR.getName());
    }

    @Test
    public void getBadgeText_배지_트리_출력() {
        HashMap<String, Integer> orders = new HashMap<>();
        orders.put("아이스크림", 5);

        int totalAmountBeforeDiscount = 5000 * 5;

        int visitDay = 6;

        benefits.calculate(orders, visitDay, totalAmountBeforeDiscount);
        benefits.calculateBenefitsAmount();

        assertThat(benefits.getBadgeText()).isEqualTo(Badge.TREE.getName());
    }

    @Test
    public void getBadgeText_배지_산타_출력() {
        HashMap<String, Integer> orders = new HashMap<>();
        orders.put("아이스크림", 10);

        int totalAmountBeforeDiscount = 5000 * 10;

        int visitDay = 6;

        benefits.calculate(orders, visitDay, totalAmountBeforeDiscount);
        benefits.calculateBenefitsAmount();

        assertThat(benefits.getBadgeText()).isEqualTo(Badge.SANTA.getName());
    }
}