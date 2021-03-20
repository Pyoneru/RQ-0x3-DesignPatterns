package pl.pyoneru.designpattern.model;

import pl.pyoneru.designpattern.observer.Message;
import pl.pyoneru.designpattern.observer.Subscriber;

public class User implements Subscriber {

    private String username;

    public User(String username){
        this.username = username;
    }

    @Override
    public void update(Message message) {
        if(message instanceof Post){
            Post post = (Post) message;
            System.out.println(post.getFrom() + ">" + username);
            System.out.println(post.getText());
            System.out.println();
        }
        
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof User){
            User u = (User) o;
            return u.username.equals(username);
        }
        return false;
    }
}
