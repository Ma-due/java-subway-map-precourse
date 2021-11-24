package subway.domain.entity;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Section {
    private final List<Station> stations;

    private Section(List<Station> stations) {
        this.stations = stations;
    }

    public static Section of(Station firstStation, Station lastStation) {
        List<Station> stations = Stream.of(firstStation, lastStation)
                .collect(Collectors.toList());

        return new Section(stations);
    }

    public void addStation(int index, Station station) {
        stations.add(index, station);
    }

    public void removeStation(Station target) {
        stations.remove(target);
    }

    public List<Station> getStations() {
        return Collections.unmodifiableList(stations);
    }

    public void deleteAllSection() {
        stations.forEach(Station::cancelRegistrationStation);
    }
}
