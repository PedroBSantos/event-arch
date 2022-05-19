package com.event.arch.listeners;

import java.util.logging.Logger;

import com.event.arch.events.EventListener;
import com.event.arch.events.user.UserCreatedEvent;

public class UserCreatedListener implements EventListener<UserCreatedEvent> {

    @Override
    public void handle(UserCreatedEvent userCreatedEvent) {
        Logger.getGlobal().info("In UserCreatedListener handle method");
    }
}
