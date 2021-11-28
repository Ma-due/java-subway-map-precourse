package subway.view;

import subway.domain.entity.Line;
import subway.domain.entity.Station;
import subway.vo.MenuType;

import java.util.List;

public class OutputView {
    private static final String MAIN_DISPLAY =
            "\n## 메인 화면\n1. 역 관리\n2. 노선 관리\n3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료";
    private static final String STATION_MANAGEMENT_DISPLAY =
            "\n## 역 관리 화면\n1. 역 등록\n2. 역 삭제\n3. 역 조회\nB. 돌아가기";
    private static final String LINE_MANAGEMENT_DISPLAY =
            "\n## 노선 관리 화면\n1. 노선 등록\n2. 노선 삭제\n3. 노선 조회\nB. 돌아가기";
    private static final String SECTION_MANAGEMENT_DISPLAY =
            "\n## 구간 관리 화면\n1. 구간 등록\n2. 구간 삭제\nB. 돌아가기";
    private static final String EMPTY_DATA_MESSAGE = "등록된 데이터가 없어 출력이 불가능합니다.";
    private static final String SUBWAY_MAP_PRINT_HEADER = "\n## 지하철 노선도";
    private static final String SUBWAY_MAP_DELIMITER = "\n[INFO] ---";
    private static final String NAMES_PRINT_HEADER_FORMAT = "\n## %s 목록";
    private static final String INFORMATION_SUCCESS_MESSAGE_FORMAT = "\n[INFO] 지하철 %s이 %s되었습니다.\n";
    private static final String INFORMATION_SECTION_SUCCESS_MESSAGE_FORMAT = "\n[INFO] 구간이 %s되었습니다.\n";
    private static final String INFORMATION_MESSAGE_FORMAT = "\n[INFO] %s";
    private static final String ERROR_MESSAGE_FORMAT = "\n[ERROR] %s\n";

    public static void printMainMenu() {
        System.out.println(MAIN_DISPLAY);
    }

    public static void printDetailMenu(MenuType menuType) {
        String detailDisplay = findDetailType(menuType);
        System.out.println(detailDisplay);
    }

    private static String findDetailType(MenuType menuType) {
        if (menuType == MenuType.STATION) return STATION_MANAGEMENT_DISPLAY;
        if (menuType == MenuType.LINE) return LINE_MANAGEMENT_DISPLAY;
        return SECTION_MANAGEMENT_DISPLAY;
    }

    public static void printStationList(List<Station> stationList) {
        for (Station station : stationList) {
            System.out.printf(INFORMATION_MESSAGE_FORMAT, station);
        }
    }

    public static void printSubwayMap(List<Line> mapInfo) {
        System.out.println(SUBWAY_MAP_PRINT_HEADER);
        mapInfo.forEach(OutputView::printLineInfo);
    }

    private static void printLineInfo(Line line) {
        System.out.printf(INFORMATION_MESSAGE_FORMAT, line.getName());
        System.out.println(SUBWAY_MAP_DELIMITER);

        List<Station> stations = line.getSection().getStations();

        for (Station station : stations) {
            System.out.printf(INFORMATION_MESSAGE_FORMAT, station);
        }
    }
}
