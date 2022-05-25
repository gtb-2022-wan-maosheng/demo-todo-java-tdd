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
        result.add("# To be done");
        for(var task : tasks){
            result.add(task.format());
        }
        return result;
    }
}
