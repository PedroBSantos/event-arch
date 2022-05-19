package com.event.arch.repositories;

import java.util.ArrayList;
import java.util.List;

import com.event.arch.entities.User;

public class UserRepositoryInMemoryImpl implements UserRepository {

    private List<User> users;

    public UserRepositoryInMemoryImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public void add(User user) {
        if (user != null)
            this.users.add(user);
    }
}
