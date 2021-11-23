package subway.domain.entity;

import java.util.List;

public class Line {
    private final String name;
    private final Section section = new Section();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Section getSection() {
        return section;
    }

    public List<String> getSectionList() {
        return section.getStations();
    }
}
