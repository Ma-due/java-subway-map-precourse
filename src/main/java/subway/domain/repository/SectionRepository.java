package subway.domain.repository;

import subway.domain.entity.Section;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SectionRepository {
    private static final List<Section> sections = new ArrayList<>();

    public static List<Section> sections() {
        return Collections.unmodifiableList(sections);
    }

    public static void addSection(Section section) {
        sections.add(section);
    }

    public static void deleteSection(String line, String station) {
        Section targetSection = sections.stream()
                .filter(section -> Objects.equals(section.getLineName(), line))
                .findFirst()
                .orElseThrow(NullPointerException::new);

        targetSection.deleteStation(station);
    }
}
