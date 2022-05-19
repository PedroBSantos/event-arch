package com.event.arch.events;

public interface EventListener<E extends Event> {

    void handle(E event);
}
