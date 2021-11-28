package subway.view;

import subway.vo.DetailMenuType;
import subway.vo.MenuType;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_MANAGEMENT_FUNCTION_NOTICE = "\n## 원하는 기능을 선택하세요.";
    private static final String INPUT_NAME_MESSAGE_FORMAT = "\n## %s할 %s 이름을 입력하세요.";
    private static final String UPWARD_LAST_STATION_NAME_NOTICE = "\n## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String DOWNWARD_LAST_STATION_NAME_NOTICE = "\n## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String SECTION_REGISTRATION_LINE_NAME_NOTICE = "\n## 노선을 입력하세요.";
    private static final String SECTION_REGISTRATION_STATION_NAME_NOTICE = "\n## 역이름을 입력하세요.";
    private static final String SECTION_REGISTRATION_ORDER_NUMBER_NOTICE = "\n## 순서를 입력하세요.";
    private static final String SECTION_DELETION_LINE_NAME_NOTICE = "\n## 삭제할 구간의 노선을 입력하세요.";
    private static final String SECTION_DELETION_STATION_NAME_NOTICE = "\n## 삭제할 구간의 역을 입력하세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputOpt() {
        System.out.println(INPUT_MANAGEMENT_FUNCTION_NOTICE);
        return scanner.nextLine();
    }

    public static String inputName() {
        return scanner.nextLine();
    }

    public static String inputIndex() {
        return scanner.nextLine();
    }
}
