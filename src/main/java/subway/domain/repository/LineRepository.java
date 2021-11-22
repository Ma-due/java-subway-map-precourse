package subway.domain.repository;

import subway.domain.entity.Line;

import java.util.*;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();
    private static final Map<String, Line> CAHCE = new HashMap<>();

    static {
        String[] initLines = {"2호선", "3호선", "신분당선"};
        Arrays.stream(initLines).map(Line::new).forEach(LineRepository::addLine);
    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static boolean contain(Line line) {
        return lines.contains(line);
    }
}
