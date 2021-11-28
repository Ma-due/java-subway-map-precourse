package subway.controller;

import subway.domain.entity.Line;
import subway.domain.entity.Station;
import subway.service.LineService;
import subway.service.StationService;

import java.util.List;

import static subway.view.InputView.*;
import static subway.view.OutputView.*;

public class LineController implements SubwayController{
    private final LineService lineService;
    private final StationService stationService;

    public LineController(LineService lineService, StationService stationService) {
        this.lineService = lineService;
        this.stationService = stationService;
    }

    @Override
    public void register() {
        Station firstStation = stationService.findByName(inputName());
        Station lastStation = stationService.findByName(inputName());
        lineService.addLine(inputName(), firstStation, lastStation);
    }

    @Override
    public void delete() {
        lineService.deleteLine(inputName());
    }

    @Override
    public void lookup() {
        List<Line> lineList = lineService.findAllLine();
    }

    @Override
    public void back() {

    }

    @Override
    public void subwayMapInfo() {
        printSubwayMap(lineService.findAllLine());
    }
}
