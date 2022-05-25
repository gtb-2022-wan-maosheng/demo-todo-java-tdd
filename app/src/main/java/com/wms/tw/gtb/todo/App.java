package com.wms.tw.gtb.todo;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

    }

    public List<String> run() {
        final List<Task> tasks = loadTasks();
        final var result = new ArrayList<String>();
        result.add("# To be done");
        for(var task : tasks){
            result.add(task.format());
        }
        return result;
    }

    private List<Task> loadTasks() {
        final List<String> lines = readTaskLines();
        final List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            final var id = i + 1;
            final var line = lines.get(i);
            final var name = line;
            final var task = new Task(id, name);
            tasks.add(task);
        }
        return tasks;
    }

    private List<String> readTaskLines() {
        try {
            return Files.readAllLines(Constants.TASK_FILE_PATH);
        } catch (IOException e) {
            throw new TodoCannotReadFileException();
        }
    }
}
