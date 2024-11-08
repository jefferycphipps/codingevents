package org.launchcode.codingevents.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;


@Entity
public class EventCategory extends AbstractEntity{



    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, message = "Name must be 3 characters long")
    private String name;

    public EventCategory(){}

    public EventCategory(@Size(min = 3, message = "Name must be 3 characters long") String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }


}
