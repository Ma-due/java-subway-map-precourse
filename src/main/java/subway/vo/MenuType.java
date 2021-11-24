package subway.vo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public enum MenuType {
    STATION("1", "역 관리",
            Arrays.asList(DetailMenuType.REGISTER, DetailMenuType.DELETE, DetailMenuType.READ, DetailMenuType.BACK)),
    LINE("2", "노선 관리",
            Arrays.asList(DetailMenuType.REGISTER, DetailMenuType.DELETE, DetailMenuType.READ, DetailMenuType.BACK)),
    SECTION("3", "구간 관리",
            Arrays.asList(DetailMenuType.REGISTER, DetailMenuType.DELETE, DetailMenuType.BACK)),
    MAP("4", "지하철 노선도 출력", Collections.emptyList()),
    QUIT("Q", "종료", Collections.emptyList());

    private final String type;
    private final String value;
    private final List<DetailMenuType> detailMenuTypes;

    MenuType(String type, String value, List<DetailMenuType> detailMenuTypes) {
        this.type = type;
        this.value = value;
        this.detailMenuTypes = detailMenuTypes;
    }

    public boolean matches(String type) {
        return Objects.equals(this.type, type);
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public List<DetailMenuType> getDetailMenuTypes() {
        return detailMenuTypes;
    }
}
