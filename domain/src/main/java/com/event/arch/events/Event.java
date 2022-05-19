package com.event.arch.events;

import java.time.Instant;

public abstract class Event {

    private final Instant instant;
    private final EventType eventType;

    public Event(Instant instant, EventType eventType) {
        this.instant = instant;
        this.eventType = eventType;
    }

    public final Instant getInstant() {
        return instant;
    }

    public EventType getEventType() {
        return eventType;
    }
}
