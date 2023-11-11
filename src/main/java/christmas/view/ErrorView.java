package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class ErrorView {
    private static final String ERROR_VISIT_DAY = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static final String ERROR_MENU = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public String repeatInputVisitDay() {
        System.out.println(ERROR_VISIT_DAY);
        return Console.readLine();
    }

    public String repeatInputMenu() {
        System.out.println(ERROR_MENU);
        return Console.readLine();
    }
}
