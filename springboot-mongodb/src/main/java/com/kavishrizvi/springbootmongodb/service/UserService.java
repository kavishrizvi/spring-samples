package com.kavishrizvi.springbootmongodb.service;

import com.kavishrizvi.springbootmongodb.entity.User;
import com.kavishrizvi.springbootmongodb.exceptions.ProductNotFound;
import com.kavishrizvi.springbootmongodb.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try {
            users = repository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("No Users Found");
        }
        return users;

    }

    public User getUserById(ObjectId id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFound(id.toString()));

    }

    public void createUser(User request) throws RuntimeException {
        try {
            request.setCreatedAt();
            repository.save(request);
        }catch (Exception e) {
            throw new RuntimeException("Unable to commit, initiating rollback");
        }
    }

    public void deleteUserById(ObjectId id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUser(String userName, User user) {
        User userInDb = getUserByUserName(userName);
        if (userInDb != null) {
            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            createUser(userInDb);
        }
    }

    public User getUserByUserName(String userName) {
        return repository.findByUserName(userName);
    }

}
