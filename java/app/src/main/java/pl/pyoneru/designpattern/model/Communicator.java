package pl.pyoneru.designpattern.model;

import java.util.ArrayList;
import java.util.List;

import pl.pyoneru.designpattern.observer.*;

public class Communicator implements Subscriber, Subscription {

    private String name;
    private String serverName;
    private String channel;
    private List<User> users;
    private Post post;

    public Communicator(String name, String serverName, String channel){
        this.name = name;
        this.serverName = serverName;
        this.channel = channel;
        this.users = new ArrayList<>();
    }


    @Override
    public void update(Message message) {
        System.out.println("Preparing message for " + name + "...");
        if(message instanceof Quest){
            Quest quest = (Quest) message;
            post = new Post(getFrom(), getText(quest));
            System.out.println("Sending message...");
            notifySubscribers();
        }else{
            System.err.println("Failed..");
        }
    }

    private String getFrom(){
        return  name + "[" + serverName + ":" + channel + "]";
    }

    private String getText(Quest quest){
        return "RQ 0x" + quest.getNumber() + " " + quest.getTitle() + "\n" + quest.getDescription();
    }


    @Override
    public void addSubscriber(Subscriber subscriber) {
        if(subscriber instanceof User){
            users.add((User)subscriber);
        }else{
            System.err.println("Subscriber is not a instance of user");
        }
        
    }


    @Override
    public void removeSubscriber(Subscriber subscriber) {
        if(subscriber instanceof User){
            users.add((User)subscriber);
        }else{
            System.err.println("Subscriber is not a instance of user");
        }
        
    }


    @Override
    public void notifySubscribers() {
        for (var user : users) {
            user.update(post);
        }
        
    }
    
}
