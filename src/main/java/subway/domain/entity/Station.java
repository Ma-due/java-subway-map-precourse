package subway.domain.entity;

public class Station {
    private static final boolean NOT_REGISTRATION = false;
    private static final boolean REGISTRATION = true;

    private final String name;
    private boolean registrationOpt = NOT_REGISTRATION;

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
        if (registrationOpt == NOT_REGISTRATION) {
            registrationOpt = REGISTRATION;
        }
    }

    public void cancelRegistrationStation() {
        if (registrationOpt == REGISTRATION) {
            registrationOpt = NOT_REGISTRATION;
        }
    }

}
