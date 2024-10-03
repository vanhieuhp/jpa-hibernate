package hieu.nv.jpa.user.entity;

import lombok.Getter;

@Getter
public enum UserShortType {

    ADMIN("A"),
    USER("U"),
    GUEST("G");
    private final String code;

    UserShortType(String code) {
        this.code = code;
    }

    public static UserShortType fromCode(String code) {
        for (UserShortType userType : UserShortType.values()) {
            if (userType.getCode().equals(code)) {
                return userType;
            }
        }
        throw new IllegalArgumentException("Unknown code: " + code);
    }
}
