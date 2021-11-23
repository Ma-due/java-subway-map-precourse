package subway.domain.entity;

public class Station {
    private static final int DEFAULT_REGISTRATION_COUNT = 0;
    private static final int MININUM_STATION_NAME_LENGTH = 2;

    private final String name;
    private int registrationCount = DEFAULT_REGISTRATION_COUNT;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean matchesName(String name) {
        return this.name.equals(name);
    }

    public void registrationStation() {
        this.registrationCount++;
    }

    public void cancelRegistrationStation() {
        if (this.registrationCount > DEFAULT_REGISTRATION_COUNT) {
            this.registrationCount--;
        }
    }

    public boolean isRegistrated() {
        return this.registrationCount > DEFAULT_REGISTRATION_COUNT;
    }

}
