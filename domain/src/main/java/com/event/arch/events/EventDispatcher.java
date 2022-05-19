package com.event.arch.events;

public interface EventDispatcher {

    void register(EventType eventName, String listenerName);

    void dispatch(Event event);
}
