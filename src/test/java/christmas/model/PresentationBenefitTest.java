package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.util.MenuType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PresentationBenefitTest {

    private PresentationBenefit presentationBenefit;

    @BeforeEach
    public void setUp() {
        presentationBenefit = new PresentationBenefit();
    }

    @Test
    void calculate_증정이벤트_있을때_할인() {
        int totalAmountBeforeDiscount = 130000;
        presentationBenefit.calculate(totalAmountBeforeDiscount);

        assertThat(presentationBenefit.getPresentationDiscount()).isEqualTo(-MenuType.BEVERAGE_CHAMPAGNE.getPrice());
    }

    @Test
    void calculate_증정이벤트_없을때_할인() {
        int totalAmountBeforeDiscount = 110000;
        presentationBenefit.calculate(totalAmountBeforeDiscount);

        assertThat(presentationBenefit.getPresentationDiscount()).isEqualTo(0);
    }

    @Test
    void makePresentationDiscountText_증정이벤트_있을때_문구() {
        int totalAmountBeforeDiscount = 130000;
        presentationBenefit.calculate(totalAmountBeforeDiscount);
        presentationBenefit.makePresentationDiscountText();

        assertThat(presentationBenefit.getPresentationDiscountText())
                .isEqualTo("증정 이벤트: -25,000원\r\n");
    }

    @Test
    void makePresentationDiscountText_증정이벤트_없을때_문구() {
        int totalAmountBeforeDiscount = 110000;
        presentationBenefit.calculate(totalAmountBeforeDiscount);
        presentationBenefit.makePresentationDiscountText();

        assertThat(presentationBenefit.getPresentationDiscountText())
                .isEqualTo("");
    }
}