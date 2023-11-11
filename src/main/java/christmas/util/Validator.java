package christmas.util;

public class Validator {
    private static final int START_DAY = 1;
    private static final int LAST_DAY = 31;

    public static void validateVisitDay(String visitDayText) {
        if (visitDayText.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (!isNumeric(visitDayText)) {
            throw new IllegalArgumentException();
        }

        if (!isVisitDayValidRange(visitDayText)) {
            throw new IllegalArgumentException();
        }

    }

    private static boolean isNumeric(String visitDayText) {
        try {
            Integer.parseInt(visitDayText);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isVisitDayValidRange(String visitDayText) {
        int visitDay = Integer.parseInt(visitDayText);
        if (visitDay >= START_DAY && visitDay <= LAST_DAY) {
            return true;
        }
        return false;
    }
}
