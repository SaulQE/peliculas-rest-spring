package com.saul.service;

import com.saul.entity.Role;
import com.saul.entity.User;
import com.saul.repository.RoleRepository;
import com.saul.repository.UserRepository;
import com.saul.util.Values;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService
{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional
    public void insert(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public void insertUserDefault(User user)
    {
        var basicRole = roleRepository.findByName(Values.BASIC.name());

        var userFromDb = userRepository.findByUsername(user.getUsername());
        if (userFromDb.isPresent()){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        //Encriptar password
        String bCrypt = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(bCrypt);
        //Asignar rol por defecto
        user.setRoles(Set.of(basicRole));

        userRepository.save(user);
    }
}
