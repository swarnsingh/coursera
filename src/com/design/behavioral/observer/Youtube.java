package com.design.behavioral.observer;

/**
 * @author Swarn Singh.
 */
public class Youtube {
    private String name;
    private Channel channel;

    public static void main(String[] args) {
        Channel channel = new Channel("Design Pattern");
        Subscriber subscriber1 = new Subscriber("Swarn Singh");
        Subscriber subscriber2 = new Subscriber("Bhupendra Singh");
        Subscriber subscriber3 = new Subscriber("Inder Singh");
        Subscriber subscriber4 = new Subscriber("Vijay Sharma");
        Subscriber subscriber5 = new Subscriber("Ankit Singh");

        channel.subscribe(subscriber1);
        channel.subscribe(subscriber2);
        channel.subscribe(subscriber3);
        channel.subscribe(subscriber4);
        channel.subscribe(subscriber5);

        channel.unSubscribe(subscriber5);

        subscriber1.subscribeChannel(channel);
        subscriber2.subscribeChannel(channel);
        subscriber3.subscribeChannel(channel);
        subscriber4.subscribeChannel(channel);
        subscriber5.subscribeChannel(channel);

        channel.upload("Observer Design Pattern");
    }
}
