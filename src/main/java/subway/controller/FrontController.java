package subway.controller;

import subway.vo.DetailMenuType;
import subway.vo.MenuType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static subway.view.InputView.*;
import static subway.view.OutputView.*;

public class FrontController {
    private final Map<MenuType, SubwayController> adapter = new HashMap<>();

    public SubwayController subwayController;

    public FrontController(StationController stationController,
                           LineController lineController,
                           SectionController sectionController) {
        adapter.put(MenuType.STATION, stationController);
        adapter.put(MenuType.LINE, lineController);
        adapter.put(MenuType.SECTION, sectionController);
        adapter.put(MenuType.MAP, lineController);
        adapter.put(MenuType.QUIT, null);
    }

    public boolean run() {
        printMainMenu();
        MenuType menuType = controllerHandle(inputOpt());

        if (menuType == MenuType.MAP) {

            return true;
        }
        if (menuType == MenuType.QUIT) return false;

        printDetailMenu(menuType);
        DetailMenuType detailMenuType = matchesDetailType(inputOpt());

        execute(detailMenuType);

        return true;
    }

    private void execute(DetailMenuType detailMenuType) {
        if (detailMenuType == DetailMenuType.REGISTER) subwayController.register();
        if (detailMenuType == DetailMenuType.DELETE) subwayController.delete();
        if (detailMenuType == DetailMenuType.READ) subwayController.lookup();

        subwayController.back();

    }

    public MenuType controllerHandle(String input) {
        MenuType menuType = matchesType(input);
        subwayController = adapter.get(menuType);

        return menuType;
    }

    private MenuType matchesType(String type) {
        return Arrays.stream(MenuType.values())
                .filter(menuType -> menuType.matches(type))
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }

    private DetailMenuType matchesDetailType(String type) {
        return Arrays.stream(DetailMenuType.values())
                .filter(detailMenuType -> detailMenuType.matches(type))
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }
}