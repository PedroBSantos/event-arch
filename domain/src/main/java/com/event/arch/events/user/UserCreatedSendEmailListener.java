package com.event.arch.events.user;

import java.util.logging.Logger;

import com.event.arch.events.EventListener;

public class UserCreatedSendEmailListener implements EventListener<UserCreatedSendEmailEvent> {

    @Override
    public void handle(UserCreatedSendEmailEvent userCreatedSendEmailEvent) {
        Logger.getGlobal().info("In UserCreatedSendEmailListener handle method");
    }
}
