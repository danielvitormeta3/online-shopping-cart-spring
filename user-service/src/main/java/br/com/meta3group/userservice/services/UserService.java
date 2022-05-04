package br.com.meta3group.userservice.services;

import br.com.meta3group.userservice.models.User;

import java.util.List;

public interface UserService {
    public User getUserById(Long id);
    public User createUser(User user);
    public User loginUser(User user);
    public User updateUser(User user);
}