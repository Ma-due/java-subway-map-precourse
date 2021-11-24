package subway.controller;

import subway.vo.MenuType;

import javax.print.attribute.SupportedValuesAttribute;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static subway.view.InputView.*;
import static subway.view.OutputView.*;

public class FrontController {
    private final Map<String, SubwayController> adapter = new HashMap<>();

    public SubwayController subwayController;

    public FrontController() {
        adapter.put("1", new StationController());
        adapter.put("2", new LineController());
        adapter.put("3", new SectionController());
        adapter.put("4", null);
        adapter.put("Q", null);
    }

    public void run() {
        printMainMenu();
        controllerHandle(inputOpt());

        printDetailMenu();
    }

    public void controllerHandle(String input) {
        MenuType menuType = matchesType(input);

        subwayController = adapter.get(menuType.getType());
    }

    private MenuType matchesType(String type) {
        return Arrays.stream(MenuType.values())
                .filter(menuType -> menuType.matches(type))
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }

    private boolean checkController(SubwayController subwayController) {
        return subwayController == null;
    }
}
