package subway.controller;

import subway.domain.entity.Line;

import java.util.List;

public interface SubwayController {
    public void register();

    public void delete();

    public void lookup();

    public void back();

    public void subwayMapInfo();
}
