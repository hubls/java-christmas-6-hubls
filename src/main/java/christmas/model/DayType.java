package christmas.model;

import java.util.List;

public enum DayType {
    WEEKDAY, WEEKEND, SPECIAL_DAY;

    private static final List<Integer> specialDays = List.of(3, 10, 17, 24, 25, 31);

    public static DayType getDayType(int dayOfMonth) {
        if ((dayOfMonth == 1 || dayOfMonth == 2 || dayOfMonth == 8 || dayOfMonth == 9 || dayOfMonth == 15 ||
                dayOfMonth == 16 || dayOfMonth == 22 || dayOfMonth == 23 || dayOfMonth == 29 || dayOfMonth == 30)) {
            return DayType.WEEKEND;
        }

        return DayType.WEEKDAY;
    }

    public static boolean isSpecialDay(int dayOfMonth) {
        return specialDays.contains(dayOfMonth);
    }
}

