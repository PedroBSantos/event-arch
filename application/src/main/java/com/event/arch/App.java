package com.event.arch;

import com.event.arch.event_dispatcher.EventDispatcherImpl;
import com.event.arch.events.EventType;
import com.event.arch.events.user.UserCreatedListener;
import com.event.arch.events.user.UserCreatedSendEmailListener;
import com.event.arch.repositories.UserRepositoryInMemoryImpl;
import com.event.arch.services.CreateUserService;

public class App {

    public static void main(String[] args) {
        var userRepository = new UserRepositoryInMemoryImpl();
        var eventDispatcher = new EventDispatcherImpl();
        var userCreatedListenerClassName = UserCreatedListener.class.getName();
        var userCreatedSendEmailListenerClassName = UserCreatedSendEmailListener.class.getName();
        eventDispatcher.register(EventType.USER_CREATED, userCreatedListenerClassName);
        eventDispatcher.register(EventType.USER_CREATED, userCreatedSendEmailListenerClassName);
        var createUserService = new CreateUserService(eventDispatcher, userRepository);
        createUserService.createUser("User", "user@email.com", "password");
    }
}
