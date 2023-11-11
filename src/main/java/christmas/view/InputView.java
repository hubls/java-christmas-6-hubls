package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.util.Validator;

public class InputView {
    private static final String START = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String VISIT_DAY = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    public void printStartMessage() {
        System.out.println(START);
    }

    public String inputVisitDay() {
        System.out.println(VISIT_DAY);
        return Console.readLine();
    }
}
