package org.launchcode.codingevents.models;

public class Event {

    private String name;
    private String description;

    public Event(){

    };

    public Event(String name, String discription) {
        this.name = name;
        this.description = discription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return name;
    }
}
