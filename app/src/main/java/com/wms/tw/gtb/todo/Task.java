package com.wms.tw.gtb.todo;

public class Task {
    private final int id;
    private final String name;
    private final boolean isCompleted;

    public Task(int id, String name, boolean isCompleted) {
        this.id = id;
        this.name = name;
        this.isCompleted = isCompleted;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return this.isCompleted;
    }

    String format() {
        return String.format("%d %s", getId(), getName());
    }
}