package com.example.model;

public class Task {
	private int id;
    private String description;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() { return id; }
    public String getDescription() { return description; }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task [ID=" + id + ", Description=" + description + "]";
    }

}
