package com.saul.util;

public enum Values {
    ADMIN(1L),
    BASIC(2L),
    DBA(3L);

    long roleId;

    Values(long roleId) {
        this.roleId = roleId;
    }

    public long getRoleId() {
        return roleId;
    }

}
