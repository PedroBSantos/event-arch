package com.event.arch.events;

import java.time.Instant;

public abstract class Event {

    private final Instant instant;

    public Event(Instant instant) {
        this.instant = instant;
    }

    public final Instant getInstant() {
        return instant;
    }

    public String getName() {
        return this.getClass().getName();
    }
}
