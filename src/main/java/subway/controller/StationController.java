package subway.controller;

import subway.domain.entity.Station;
import subway.service.StationService;
import subway.view.OutputView;

import java.util.List;

import static subway.view.InputView.*;

public class StationController implements SubwayController{

    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @Override
    public void register() {
        stationService.addStation(inputName());
    }

    @Override
    public void delete() {
        stationService.deleteStation(inputName());
    }

    @Override
    public void lookup() {
        List<Station> stationList = stationService.findAllStation();
        OutputView.printStationList(stationList);
    }

    @Override
    public void back() {
    }

    @Override
    public void subwayMapInfo() {
    }
}
