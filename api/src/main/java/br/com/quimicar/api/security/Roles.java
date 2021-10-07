package br.com.quimicar.api.security;

import com.google.common.collect.Sets;

import java.util.Set;

public enum Roles {
    USER(Sets.newHashSet(Permissions.ELEMENT_READ)),
    ADMIN(Sets.newHashSet(Permissions.ELEMENT_READ, Permissions.ELEMENT_WRITE));

    private final Set<Permissions> permissions;

    Roles(Set<Permissions> permissions) {
        this.permissions = permissions;
    }

    public Set<Permissions> getPermissions() {
        return permissions;
    }
}
