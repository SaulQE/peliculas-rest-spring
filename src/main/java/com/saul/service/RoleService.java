package com.saul.service;

import com.saul.entity.Role;

import java.util.Collection;

public interface RoleService {
    public abstract void insert(Role role);
    public abstract void update(Role role);
    public abstract void delete(Integer roleId);
    public abstract Role findById(Integer roleId);
    public abstract Collection<Role> findAll();
    public abstract Role findByName(String name);
}
