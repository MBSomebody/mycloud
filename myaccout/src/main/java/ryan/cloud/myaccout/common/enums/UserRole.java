package ryan.cloud.myaccout.common.enums;

public enum UserRole {
    ROLE_USER("USER"),
    ROLE_ADMIN("ADMIN");

    UserRole(String role) {
        this.role = role;
    }

    private String role;

    public String getRole() {
        return role;
    }
}
