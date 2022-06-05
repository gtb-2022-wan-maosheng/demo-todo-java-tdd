package com.wms.tw.gtb.todo;

public class TaskMarshaller {

    String marshal(Task task) {
        return "+ " + task.getName();
    }

    Task unmarshal(int id, String line) {
        final var fields = line.split(" ", 2);
        final var name = fields[1];
        boolean isCompleted = fields[0].equals("x");
        return new Task(id, name, isCompleted);
    }
}
