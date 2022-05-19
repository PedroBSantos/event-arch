package com.event.arch.events.user;

import java.util.logging.Logger;

import com.event.arch.events.EventListener;

public class UserCreatedSendEmailListener implements EventListener<UserCreatedEvent> {

    @Override
    public void handle(UserCreatedEvent userCreatedEvent) {
        Logger.getGlobal().info("In UserCreatedSendEmailListener handle method");
    }
}
