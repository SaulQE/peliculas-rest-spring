package com.saul.service;

import com.saul.entity.User;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

    public abstract void insert(User user);
    public abstract void update(User user);
    public abstract void delete(Integer userId);
    public abstract User findById(Integer userId);
    public abstract Collection<User> findAll();
    public abstract Optional<User> findByUsername(String username);
    public abstract void insertUserDefault(User user);

}
