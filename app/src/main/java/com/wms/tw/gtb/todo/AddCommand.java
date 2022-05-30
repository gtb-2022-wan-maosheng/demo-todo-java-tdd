package com.wms.tw.gtb.todo;

import java.util.List;

public class AddCommand {
    private final String[] args;
    final TaskRepository taskRepository;

    public AddCommand(TaskRepository taskRepository, String... args) {
        this.args = args;
        this.taskRepository = taskRepository;
    }

    List<String> execute() {
        final var taskName = String.join(" ", args);
        taskRepository.create(new Task(0, taskName, false));
        return List.of();
    }

}
