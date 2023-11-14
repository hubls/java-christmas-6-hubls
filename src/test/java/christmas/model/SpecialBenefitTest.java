package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SpecialBenefitTest {
    private SpecialBenefit specialBenefit;

    @BeforeEach
    public void setUp() {
        specialBenefit = new SpecialBenefit();
    }

    @Test
    public void calculate_특별_날짜인_경우_할인() {
        int specialDay = 3;
        specialBenefit.calculate(specialDay);
        assertThat(specialBenefit.getSpecialDiscount()).isEqualTo(-1000);
    }

    @Test
    public void calculate_특별_날짜가_아닌_경우_할인() {
        int nonSpecialDay = 5;
        specialBenefit.calculate(nonSpecialDay);
        assertThat(specialBenefit.getSpecialDiscount()).isEqualTo(0);
    }

    @Test
    public void makeSpecialDiscountText_특별_날짜인_경우_문구() {
        int specialDay = 10;
        specialBenefit.calculate(specialDay);
        specialBenefit.makeSpecialDiscountText();
        assertThat(specialBenefit.getSpecialDiscountText()).isEqualTo("특별 할인: -1,000원\r\n");
    }

    @Test
    public void makeSpecialDiscountText_특별_날짜가_아닌_경우_문구() {
        int nonSpecialDay = 6;
        specialBenefit.calculate(nonSpecialDay);
        specialBenefit.makeSpecialDiscountText();
        assertThat(specialBenefit.getSpecialDiscountText()).isEqualTo("");
    }
}