package subway.vo;

public enum DetailMenuType {
    REGISTER("1", "등록"),
    DELETE("2", "삭제"),
    READ("3", "조회"),
    BACK("B", "돌아가기");

    private final String type;
    private final String message;

    DetailMenuType(String number, String message) {
        this.type = number;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
