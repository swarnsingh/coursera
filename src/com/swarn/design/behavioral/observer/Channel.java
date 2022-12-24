package com.swarn.design.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Swarn Singh.
 */
public class Channel {
    private final List<Subscriber> subscribers = new ArrayList<>();
    private String title;
    private final String name;

    public Channel(String name) {
        this.name = name;
    }

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unSubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(String title) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(title);
        }
    }

    public void upload(String title) {
        this.title = title;
        notifySubscribers(title);
    }
}
