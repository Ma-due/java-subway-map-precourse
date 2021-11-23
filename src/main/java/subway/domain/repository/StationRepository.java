package subway.domain.repository;

import subway.domain.entity.Station;

import java.util.*;

public class StationRepository {
    private final List<Station> stations;

    public StationRepository(List<Station> stations) {
        this.stations = stations;
    }

    public void save(Station station) {
        stations.add(station);
    }

    public Optional<Station> findByName(String name) {
        return stations.stream()
                .filter(station -> station.matchesName(name))
                .findFirst();
    }

    public List<Station> findAll() {
        return Collections.unmodifiableList(stations);
    }

    public void delete(Station target) {
        stations.remove(target);
    }
}
