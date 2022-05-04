package br.com.meta3group.userservice.services;

import br.com.meta3group.userservice.models.User;
import br.com.meta3group.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }


    @Override
    public User loginUser(User user){
        User loggedUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        return loggedUser;
    }


    @Override
    public User updateUser(User user) {

        User beforeUpdate = getUserById(user.getId());

        if(beforeUpdate == null){
            return null;
        }

        beforeUpdate.setEmail(user.getEmail());
        beforeUpdate.setPassword(user.getPassword());

        return userRepository.save(beforeUpdate);
    }


}
