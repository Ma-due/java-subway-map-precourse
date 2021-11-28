package subway.controller;

import subway.domain.entity.Line;
import subway.domain.entity.Station;
import subway.service.LineService;
import subway.service.StationService;

import static subway.view.InputView.*;

public class SectionController implements SubwayController {
    private final LineService lineService;
    private final StationService stationService;

    public SectionController(LineService lineService, StationService stationService) {
        this.lineService = lineService;
        this.stationService = stationService;
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
    public void lookup() {

    }

    @Override
    public void back() {

    }

    @Override
    public void subwayMapInfo() {

    }
}
