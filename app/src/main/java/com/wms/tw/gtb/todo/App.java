package com.wms.tw.gtb.todo;

import java.util.ArrayList;
import java.util.List;

public class App {

    private final TaskRepository taskRepository = new TaskRepository();

    public static void main(String[] args) {

    }

    public List<String> run() {
        final List<Task> tasks = taskRepository.loadTasks();
        final var result = new ArrayList<String>();
        result.addAll(Section.tbd().format(tasks));
        result.addAll(Section.completed().format(tasks));
        return result;
    }

}
