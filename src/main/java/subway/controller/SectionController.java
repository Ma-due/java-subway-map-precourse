package subway.controller;

import subway.domain.entity.Line;
import subway.domain.entity.Station;
import subway.service.LineService;
import subway.service.StationService;

import static subway.view.InputView.*;

public class SectionController implements SubwayController {
    private final StationService stationService;
    private final LineService lineService;

    public SectionController(StationService stationService, LineService lineService) {
        this.stationService = stationService;
        this.lineService = lineService;
    }

    @Override
    public void register() {
        Line targetLine = lineService.findByName(inputName());
        Station targetStation = stationService.findByName(inputName());
        String index = inputIndex();

        lineService.addSection(targetLine, Integer.parseInt(index), targetStation);
    }

    @Override
    public void delete() {
        Line targetLine = lineService.findByName(inputName());
        Station targetStation = stationService.findByName(inputName());

        lineService.deleteSection(targetLine, targetStation);
    }

    @Override
    public void find() {

    }

    @Override
    public void back() {

    }
}
