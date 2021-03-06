package com.wms.tw.gtb.todo;

import java.util.Objects;

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

    @Override
    public String toString() {
        return id + " " + isCompleted + " " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && isCompleted == task.isCompleted && name.equals(task.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isCompleted);
    }
}
