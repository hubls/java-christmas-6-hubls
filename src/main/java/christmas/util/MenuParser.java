package christmas.util;

import java.util.HashMap;
import java.util.List;

public class MenuParser {
    private static final String COMMA = ",";
    private static final String HYPHEN = "-";
    private static final int MENU_NAME = 0;
    private static final int NUMBER_OF_MENU = 1;

    public static HashMap<String, Integer> convertHashMap(String menuText) {
        List<String> menuParsedWithComma = commaParser(menuText);
        HashMap<String, Integer> menuParsedWithHyphen = hyphenParser(menuParsedWithComma);
        return menuParsedWithHyphen;
    }

    private static List<String> commaParser(String menuText) {
        return List.of(menuText.split(COMMA));
    }

    private static HashMap<String, Integer> hyphenParser(List<String> menus) {
        HashMap<String, Integer> parsedMenu = new HashMap<>();

        for (String IndividualMenu : menus) {
            List<String> menuDetails = List.of(IndividualMenu.split(HYPHEN));

            String menuName = menuDetails.get(MENU_NAME);
            int numberOfMenu = Integer.parseInt(menuDetails.get(NUMBER_OF_MENU));

            parsedMenu.put(menuName, numberOfMenu);
        }

        return parsedMenu;
    }
}
