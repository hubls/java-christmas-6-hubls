package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class DateBenefitTest {
    private DateBenefit dateBenefit;
    private static final int DISCOUNT_UNIT = 2023;
    private HashMap<String, Integer> orders;

    @BeforeEach
    public void setUp() {
        dateBenefit = new DateBenefit();

        orders = new HashMap<>();
        orders.put("초코케이크", 2);
        orders.put("티본스테이크", 1);
    }

    @Test
    public void calculate_평일_방문_할인() {
        int weekDay = 3;
        dateBenefit.calculate(weekDay, orders);

        assertThat(dateBenefit.getDateDiscount()).isEqualTo(-2 * DISCOUNT_UNIT);
    }

    @Test
    public void calculate_주말_방문_할인() {
        int weekend = 2;
        dateBenefit.calculate(weekend, orders);

        assertThat(dateBenefit.getDateDiscount()).isEqualTo(-1 * DISCOUNT_UNIT);
    }

    @Test
    public void makeDateDiscountText_평일_날짜인_경우_할인_문구() {
        int weekDay = 3;
        dateBenefit.calculate(weekDay, orders);
        dateBenefit.makeDateDiscountText(weekDay);

        assertThat(dateBenefit.getDateDiscountText()).isEqualTo("평일 할인: -4,046원\r\n");
    }

    @Test
    public void makeDateDiscountText_주말_날짜인_경우_할인_문구() {
        int weekend = 2;
        dateBenefit.calculate(weekend, orders);
        dateBenefit.makeDateDiscountText(weekend);

        assertThat(dateBenefit.getDateDiscountText()).isEqualTo("주말 할인: -2,023원\r\n");
    }

    @Test
    public void makeDateDiscountText_아무것도_할인_없는_경우_할인() {
        DateBenefit dateBenefit = new DateBenefit();

        HashMap<String, Integer> orders = new HashMap<>();
        orders.put("시저샐러드", 2);
        orders.put("타파스", 1);

        int weekDay = 3;
        dateBenefit.calculate(weekDay, orders);

        assertThat(dateBenefit.getDateDiscount()).isEqualTo(0);
    }


    @Test
    public void makeDateDiscountText_아무것도_할인_없는_경우_문구() {
        DateBenefit dateBenefit = new DateBenefit();

        HashMap<String, Integer> orders = new HashMap<>();
        orders.put("시저샐러드", 2);
        orders.put("타파스", 1);

        int weekend = 2;
        dateBenefit.calculate(weekend, orders);
        dateBenefit.makeDateDiscountText(weekend);

        assertThat(dateBenefit.getDateDiscountText()).isEqualTo("");
    }
}