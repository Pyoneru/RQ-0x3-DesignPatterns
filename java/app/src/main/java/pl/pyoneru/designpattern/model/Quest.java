package pl.pyoneru.designpattern.model;

import pl.pyoneru.designpattern.observer.Message;

public class Quest implements Message {
    private int number;
    private String title;
    private String description;

    public Quest(int number, String title, String description){
        this.number = number;
        this.title = title;
        this.description = description;
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public boolean equals(Object o){
        if(o instanceof Quest){
            Quest p = (Quest) o;
            return p.number == number && 
            p.title.equals(title) && 
            p.description.equals(description);
        }
        return false;
    }
}
