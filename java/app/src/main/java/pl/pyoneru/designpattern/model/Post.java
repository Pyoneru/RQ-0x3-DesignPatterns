package pl.pyoneru.designpattern.model;

import pl.pyoneru.designpattern.observer.Message;

public class Post implements Message {
     private String from;
     private String text;

     public Post(String from, String text){
         this.from = from;
         this.text = text;
     }

     public String getFrom(){
         return from;
     }

     public String getText(){
         return text;
     }
}
