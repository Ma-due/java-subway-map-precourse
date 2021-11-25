package subway.service;

import subway.domain.entity.Line;
import subway.domain.entity.Section;
import subway.domain.entity.Station;
import subway.domain.repository.LineRepository;

import java.util.List;

public class LineService {
    private final LineRepository lineRepository;

    public LineService(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    public void addLine(String name, Station firstStation, Station lastStation) {
        lineRepository.findByName(name)
                .ifPresent(line -> {
                    throw new NullPointerException();
                });

        Line line = new Line(name, Section.of(firstStation, lastStation));

        lineRepository.save(line);
    }

    public void addSection(Line line, int index, Station station) {
        line.addSection(index, station);
    }

    public void deleteLine(String name) {
        Line line = findByName(name);
        line.deleteAllSection();
        lineRepository.delete(line);
    }

    public void deleteSection(Line line, Station station) {
        Line target = lineRepository.find(line);
        Section section = target.getSection();
        section.removeStation(station);
    }

    public Line findByName(String name) {
        return lineRepository.findByName(name).orElseThrow(NullPointerException::new);
    }

    public List<Line> findAllLine() {
        return lineRepository.findAll();
    }

}
