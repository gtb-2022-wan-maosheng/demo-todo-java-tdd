package com.wms.tw.gtb.todo;

import java.util.ArrayList;
import java.util.List;

public class ListCommand {
    final TaskRepository taskRepository = new TaskRepository();

    ArrayList<String> run() {
        final List<Task> tasks = taskRepository.loadTasks();
        final var result = new ArrayList<String>();
        result.addAll(Section.tbd().format(tasks));
        result.addAll(Section.completed().format(tasks));
        return result;
    }
}