package com.wms.tw.gtb.todo;

public class TaskMarshaller {
    public TaskMarshaller() {
    }

    static String marshal(Task task) {
        return "+ " + task.getName();
    }

    static Task unmarshal(int id, String line) {
        final var fields = line.split(" ", 2);
        final var name = fields[1];
        boolean isCompleted = fields[0].equals("x");
        return new Task(id, name, isCompleted);
    }
}
