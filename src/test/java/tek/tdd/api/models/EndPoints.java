package tek.tdd.api.models;
public enum EndPoints {
    TOKEN("/api/token"),
    GET_PRIMARY_ACCOUNT("/api/accounts/get-primary-account"),
    GET_ALL_PLAN_CODE("/api/plans/get-all-plan-code"),
    GET_ACCOUNT("/api/accounts/get-account"),
    ADD_PRIMARY_ACCOUNT("/api/accounts/add-primary-account"),
    USER_PROFILE("/api/user/profile");


    private final String value;

    EndPoints(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}