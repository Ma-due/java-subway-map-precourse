package subway.domain.entity;

public class Line {
    private final String name;
    private final Section section;

    public Line(String name, Section section) {
        this.name = name;
        this.section = section;
    }

    public void addSection(int index, Station station) {
        section.addStation(index, station);
    }

    public String getName() {
        return name;
    }

    public Section getSection() {
        return section;
    }

    public boolean matchesName(String name) {
        return this.name.equals(name);
    }

    public void deleteAllSection() {
        section.deleteAllSection();
    }
}
