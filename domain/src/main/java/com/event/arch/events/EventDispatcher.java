package com.event.arch.events;

public interface EventDispatcher {

    void register(String eventName, String listenerName);

    void dispatch(Event event);
}
