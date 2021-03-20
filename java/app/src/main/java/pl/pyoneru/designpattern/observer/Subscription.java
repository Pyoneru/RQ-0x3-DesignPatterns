package pl.pyoneru.designpattern.observer;

public interface Subscription {
    
    void addSubscriber(Subscriber subscriber);
    void removeSubscriber(Subscriber subscriber);
    void notifySubscribers();
}
