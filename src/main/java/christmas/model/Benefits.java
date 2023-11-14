package christmas.model;

import java.util.HashMap;

import static christmas.util.Unit.KOREA_WON;
import static christmas.util.Unit.decimalFormat;

public class Benefits {
    ChristmasBenefit christmasBenefit = new ChristmasBenefit();
    DateBenefit dateBenefit = new DateBenefit();
    SpecialBenefit specialBenefit = new SpecialBenefit();
    PresentationBenefit presentationBenefit = new PresentationBenefit();
    private int benefitsAmount = 0;


    public void calculate(HashMap<String, Integer> orders, int visitDay, int totalAmountBeforeDiscount) {
        christmasBenefit.calculate(visitDay);
        dateBenefit.calculate(visitDay, orders);
        specialBenefit.calculate(visitDay);
        presentationBenefit.calculate(totalAmountBeforeDiscount);
    }

    public void makeDiscountsText(int visitDay) {
        christmasBenefit.makeChristmasDiscountText();
        dateBenefit.makeDateDiscountText(visitDay);
        specialBenefit.makeSpecialDiscountText();
        presentationBenefit.makePresentationDiscountText();
    }

    public String getDiscountsText() {
        return christmasBenefit.getChristmasDiscountText()
                + dateBenefit.getDateDiscountText()
                + specialBenefit.getSpecialDiscountText()
                + presentationBenefit.getPresentationDiscountText();
    }

    public void calculateBenefitsAmount() {
        benefitsAmount = christmasBenefit.getChristmasDiscount()
                + dateBenefit.getDateDiscount()
                + specialBenefit.getSpecialDiscount()
                + presentationBenefit.getPresentationDiscount();
    }

    public String getBenefitsAmountText() {
        return decimalFormat.format(benefitsAmount) + KOREA_WON;
    }

    public String getTotalAmountAfterDiscountText(int totalAmountBeforeDiscount) {
        int totalAmountAfterDiscount = 0;

        if (presentationBenefit.getPresentationDiscount() == 0) {
            totalAmountAfterDiscount = totalAmountBeforeDiscount + benefitsAmount;
        }

        if (presentationBenefit.getPresentationDiscount() != 0) {
            totalAmountAfterDiscount = totalAmountBeforeDiscount + benefitsAmount - presentationBenefit.getPresentationDiscount();
        }

        return decimalFormat.format(totalAmountAfterDiscount) + KOREA_WON;
    }
}
