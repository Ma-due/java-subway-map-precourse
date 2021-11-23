package subway.domain.repository;

import subway.domain.entity.Line;
import subway.domain.entity.Section;
import subway.domain.entity.Station;

import java.util.*;

public class LineRepository {
    private final List<Line> lines;

    public LineRepository(List<Line> lines) {
        this.lines = lines;
    }

    public void save(Line line) {
        lines.add(line);
    }

    public Optional<Line> findByName(String name) {
        return lines.stream()
                .filter(line -> line.matchesName(name))
                .findFirst();
    }

    public List<Line> findAll() {
        return Collections.unmodifiableList(lines);
    }

    public boolean delete(Line target) {
        return lines.removeIf(line -> line.equals(target));
    }
}
