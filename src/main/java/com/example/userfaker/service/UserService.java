package com.example.userfaker.service;

import com.example.userfaker.model.User;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final Faker faker = new Faker();

    public User generateUser() {
        return new User(
                faker.name().fullName(),
                faker.internet().emailAddress(),
                faker.address().fullAddress()
        );
    }

    public List<User> generateUsers(int count) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            users.add(generateUser());
        }
        return users;
    }
}
