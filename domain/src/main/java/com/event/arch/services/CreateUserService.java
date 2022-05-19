package com.event.arch.services;

import java.time.Instant;
import java.util.UUID;

import com.event.arch.entities.User;
import com.event.arch.events.EventDispatcher;
import com.event.arch.events.user.UserCreatedEvent;
import com.event.arch.repositories.UserRepository;

public class CreateUserService {

    private final EventDispatcher eventDispatcher;
    private final UserRepository userRepository;

    public CreateUserService(EventDispatcher eventDispatcher, UserRepository userRepository) {
        this.eventDispatcher = eventDispatcher;
        this.userRepository = userRepository;
    }

    public void createUser(String username, String email, String password) {
        var user = new User(UUID.randomUUID(), username, password, email);
        this.userRepository.add(user);
        var userCreatedEvent = new UserCreatedEvent(Instant.now(), username, email);
        this.eventDispatcher.dispatch(userCreatedEvent);
    }
}
