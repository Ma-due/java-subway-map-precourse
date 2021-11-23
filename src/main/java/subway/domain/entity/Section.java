package subway.domain.entity;

import java.util.LinkedList;
import java.util.List;

public class Section {
    private String lineName;
    private List<String> stations;

    private Section(String lineName, String ascendingStation, String descendingStation) {
        this.lineName = lineName;
        this.stations = new LinkedList<>();
        this.stations.add(ascendingStation);
        this.stations.add(descendingStation);
    }

    public Section of(String lineName, String ascendingStation, String descendingStation) {
        return new Section(lineName, ascendingStation, descendingStation);
    }

    public void addStation(String stationName, int index) {
        this.stations.add(index, stationName);
    }
    public void deleteStation(String stationName) {
        stations.removeIf(station -> station.equals(stationName));
    }

    public Section getSection() {
        return this;
    }

    public String getLineName() {
        return lineName;
    }

    public List<String> getStations() {
        return stations;
    }
}
