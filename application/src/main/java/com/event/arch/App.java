package com.event.arch;

import com.event.arch.event_dispatcher.EventDispatcherImpl;
import com.event.arch.events.user.UserCreatedEvent;
import com.event.arch.events.user.UserCreatedListener;
import com.event.arch.events.user.UserCreatedSendEmailEvent;
import com.event.arch.events.user.UserCreatedSendEmailListener;
import com.event.arch.repositories.UserRepositoryInMemoryImpl;
import com.event.arch.services.CreateUserService;

public class App {

    public static void main(String[] args) {
        var userRepository = new UserRepositoryInMemoryImpl();
        var eventDispatcher = new EventDispatcherImpl();
        var userCreatedEventClassName = UserCreatedEvent.class.getName();
        var userCreatedListenerClassName = UserCreatedListener.class.getName();
        var userCreatedSendEmailEventClassName = UserCreatedSendEmailEvent.class.getName();
        var userCreatedSendEmailListenerClassName = UserCreatedSendEmailListener.class.getName();
        eventDispatcher.register(userCreatedEventClassName, userCreatedListenerClassName);
        eventDispatcher.register(userCreatedSendEmailEventClassName, userCreatedSendEmailListenerClassName);
        var createUserService = new CreateUserService(eventDispatcher, userRepository);
        createUserService.createUser("Pedro", "email@email.com", "password");
    }
}
