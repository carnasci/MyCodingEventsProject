package org.launchcode.codingevents.models;

import jakarta.validation.constraints.*;

import java.util.Date;
import java.util.Objects;

public class Event {
    @NotBlank(message = "Name is required!")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters.")
    private String name;
    @Size(max = 500, message = "Description too long!")
    private String description;
    @NotBlank(message = "Must enter a location!")
    private String location;
    @AssertTrue(message = "Atendee must register!")
    private boolean registration;
    @Positive(message = "Number of atendees must be one or more!")
    private int atendees;
    @Future(message = "Must be a date in the future!")
    private Date date;
    @NotBlank(message = "Contact Email is required!")
    @Email(message = "Invalid email. Please try again!")
    private String contactEmail;
    private int id;
    private static int nextId = 1;

    public Event(String name, String description, String contactEmail) {
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.id = nextId;
        nextId++;
    }

    public Event() {}

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

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
