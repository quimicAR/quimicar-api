package br.com.quimicar.api.security;

public enum Permissions {
    ELEMENT_WRITE("element:write"), // CREATE, UPDATE and DELETE
    ELEMENT_READ("element:read");

    private final String permission;

    Permissions(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
