package subway;

import java.util.List;

public class SectionDto {
    private String lineInfo;
    private List<String> sectionInfo;

    public SectionDto(String lineInfo, List<String> sectionInfo) {
        this.lineInfo = lineInfo;
        this.sectionInfo = sectionInfo;
    }

    public String getLineInfo() {
        return lineInfo;
    }

    public List<String> getSectionInfo() {
        return sectionInfo;
    }
}
