package com.event.arch.events.user;

import java.time.Instant;

import com.event.arch.events.Event;
import com.event.arch.events.EventType;

public final class UserCreatedEvent extends Event {

    private final String username;
    private final String email;

    public UserCreatedEvent(Instant instant, String username, String email) {
        super(instant, EventType.USER_CREATED);
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
