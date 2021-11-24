package subway.vo;

import java.util.Objects;

public enum DetailMenuType {
    REGISTER("1", "등록"),
    DELETE("2", "삭제"),
    READ("3", "조회"),
    BACK("B", "돌아가기");

    private final String type;
    private final String message;

    DetailMenuType(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public boolean matches(String type) {
        return Objects.equals(this.type, type);
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
