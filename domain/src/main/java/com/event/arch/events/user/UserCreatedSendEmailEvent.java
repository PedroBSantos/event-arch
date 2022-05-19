package com.event.arch.events.user;

import java.time.Instant;

import com.event.arch.events.Event;

public class UserCreatedSendEmailEvent extends Event {

    private final String email;

    public UserCreatedSendEmailEvent(Instant instant, String email) {
        super(instant);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
