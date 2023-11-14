package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ChristmasBenefitTest {
    private ChristmasBenefit christmasBenefit;

    @BeforeEach
    public void setUp() {
        christmasBenefit = new ChristmasBenefit();
    }

    @Test
    public void calculate_유효하지_않은_방문일_할인() {
        christmasBenefit.calculate(26);
        assertThat(christmasBenefit.getChristmasDiscount()).isEqualTo(0);
    }

    @Test
    public void calculate_유효한_방문일_할인() {
        christmasBenefit.calculate(5);
        assertThat(christmasBenefit.getChristmasDiscount()).isEqualTo(-1400);
    }

    @Test
    public void makeChristmasDiscountText_할인_없음_문구() {
        christmasBenefit.calculate(26);
        christmasBenefit.makeChristmasDiscountText();
        assertThat(christmasBenefit.getChristmasDiscountText()).isEqualTo("");
    }

    @Test
    public void makeChristmasDiscountText_할인_있음_문구() {
        christmasBenefit.calculate(3);
        christmasBenefit.makeChristmasDiscountText();
        assertThat(christmasBenefit.getChristmasDiscountText()).isEqualTo("크리스마스 디데이 할인: -1,200원\r\n");
    }
}