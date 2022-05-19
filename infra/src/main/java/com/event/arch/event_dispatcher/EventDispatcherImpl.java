package com.event.arch.event_dispatcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.event.arch.events.Event;
import com.event.arch.events.EventDispatcher;
import com.event.arch.events.EventListener;
import com.event.arch.events.EventType;

public class EventDispatcherImpl implements EventDispatcher {

    private final Map<EventType, List<EventListener<Event>>> eventMapping;

    public EventDispatcherImpl() {
        this.eventMapping = new HashMap<>();
    }

    @Override
    public void register(EventType eventName, String listenerName) {
        try {
            var listenerClass = (Class<EventListener<Event>>) Class.forName(listenerName);
            var eventListener = listenerClass.getConstructor().newInstance();
            var eventListeners = this.eventMapping.get(eventName);
            if (eventListeners != null) {
                if (eventListeners.stream().anyMatch(evl -> evl.getClass().getName().equals(listenerName)))
                    return;
                eventListeners.add(eventListener);
                return;
            }
            eventListeners = new ArrayList<EventListener<Event>>();
            eventListeners.add(eventListener);
            this.eventMapping.put(eventName, eventListeners);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void dispatch(Event event) {
        if (!this.eventMapping.containsKey(event.getEventType()))
            throw new RuntimeException("No listener registred for event: " + event.getEventType());
        var eventListeners = this.eventMapping.get(event.getEventType());
        eventListeners.forEach(eventListener -> eventListener.handle(event));
    }
}
