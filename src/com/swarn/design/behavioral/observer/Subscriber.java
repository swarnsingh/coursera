package com.swarn.design.behavioral.observer;

/**
 * @author Swarn Singh.
 */
public class Subscriber {

    private final String name;
    private Channel channel;

    public Subscriber(String name) {
        this.name = name;
    }

    public void update(String title) {
        System.out.println("Hello " + name + ", new video is uploaded: " + title);
    }

    public void subscribeChannel(Channel channel) {
        this.channel = channel;
    }
}
