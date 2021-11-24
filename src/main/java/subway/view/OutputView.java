package subway.view;

import subway.controller.LineController;
import subway.controller.SectionController;
import subway.controller.StationController;
import subway.vo.MenuType;

public class OutputView {
    public static void printMainMenu() {
        System.out.println("## 메인화면");
        MenuType[] values = MenuType.values();
        for (MenuType value : values) {
            System.out.println(value.getType() + ". " + value.getValue());
        }

        emptyLine();
        System.out.println("## 원하는 기능을 선택하세요.");
        emptyLine();
    }

    private static void emptyLine() {
        System.out.println();
    }

    public static void printDetailMenu(StationController stationController) {
        System.out.println("## 역 관리 화면");
    }

    public static void printDetailMenu(LineController lineController) {
        System.out.println("## 노선 관리 화면");
    }

    public static void printDetailMenu(SectionController sectionController) {
        System.out.println("## 구간 관리 화면");
    }
}
