package subway.service;

import subway.domain.entity.Station;
import subway.domain.repository.StationRepository;

import java.util.List;
import java.util.Optional;

public class StationService {
    private final StationRepository stationRepository;

    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public void addStation(String name) {
        stationRepository.findByName(name)
                .ifPresent(station -> {
                    throw new IllegalArgumentException();
                });

        Station station = new Station(name);
        stationRepository.save(station);
    }

    public void deleteStation(String name) {
        Station target = findByName(name);
        stationRepository.delete(target);
    }

    public List<Station> findAllStation() {
        return stationRepository.findAll();
    }

    private Station findByName(String name) {
        return stationRepository.findByName(name).orElseThrow(IllegalArgumentException::new);
    }
}
