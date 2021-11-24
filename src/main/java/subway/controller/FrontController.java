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

    public FrontController() {
        adapter.put(MenuType.STATION, new StationController());
        adapter.put(MenuType.LINE, new LineController());
        adapter.put(MenuType.SECTION, new SectionController());
        adapter.put(MenuType.MAP, null);
        adapter.put(MenuType.QUIT, null);
    }

    public SubwayController sendController(SubwayController subwayController) {
        return subwayController;
    }

    public boolean run() {
        printMainMenu();
        MenuType menuType = controllerHandle(inputOpt());

        if (menuType == MenuType.QUIT) return false;

        printDetailMenu(menuType);
        DetailMenuType detailMenuType = matchesDetailType(inputOpt());

        execute(detailMenuType);

        return true;
    }

    private void execute(DetailMenuType detailMenuType) {
        if (detailMenuType == DetailMenuType.REGISTER) subwayController.register();
        if (detailMenuType == DetailMenuType.DELETE) subwayController.delete();
        if (detailMenuType == DetailMenuType.READ) subwayController.find();

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