package subway.domain.repository;

import subway.domain.entity.Station;

import java.util.*;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();
    private static final Map<String, Station> CAHCE = new HashMap<>();

    static {
        String[] initStation = {"교대역", "강남역", "역삼역", "남부터널역", "양재역", "양재시민의숲역", "매봉역"};
        Arrays.stream(initStation).map(Station::new).forEach(StationRepository::addStation);
    }

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static boolean contain(Station station) {
        return stations.contains(station);
    }
}
