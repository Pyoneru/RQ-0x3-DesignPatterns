package pl.pyoneru.designpattern.model;

import java.util.ArrayList;
import java.util.List;

import pl.pyoneru.designpattern.observer.Subscriber;
import pl.pyoneru.designpattern.observer.Subscription;

public class REcoDeQuest implements Subscription {

    private List<Subscriber> subscribers;
    private Quest quest;

    public REcoDeQuest(){
        this.subscribers = new ArrayList<>();
    }

    public Quest getQuest(){
        return quest;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
        
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
        
    }

    @Override
    public void notifySubscribers() {
        for(var sub : subscribers){
            sub.update(quest);
        }
        
    }
    
}
