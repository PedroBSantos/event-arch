package com.event.arch.events.user;

import java.time.Instant;

import com.event.arch.events.Event;

public final class UserCreatedEvent extends Event {

    private final String username;
    private final String email;

    public UserCreatedEvent(Instant instant, String username, String email) {
        super(instant);
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
