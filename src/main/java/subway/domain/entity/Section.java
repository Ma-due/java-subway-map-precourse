package subway.domain.entity;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Section {
    private final List<String> stations = new LinkedList<>();

    public void addStation(List<String> stationList) {
        stations.addAll(stationList);
    }

    public void addStation(String station, int index) {
        stations.add(index, station);
    }

    public void removeStation(String station) {
        stations.remove(station);
    }

    public List<String> getStations () {
        return Collections.unmodifiableList(stations);
    }
}
