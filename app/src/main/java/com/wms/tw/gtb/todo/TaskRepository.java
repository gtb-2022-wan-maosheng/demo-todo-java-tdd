package com.wms.tw.gtb.todo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    List<Task> loadTasks() {
        final List<String> lines = readTaskLines();
        final List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            tasks.add(TaskFactory.createTask(i + 1, lines.get(i)));
        }
        return tasks;
    }

    List<String> readTaskLines() {
        try {
            return Files.readAllLines(Constants.TASK_FILE_PATH);
        } catch (IOException e) {
            throw new TodoException();
        }
    }

    List<String> create(Task task) {
        final var taskName = task.getName();
        try (var bufferedWriter = Files.newBufferedWriter(Constants.TASK_FILE_PATH, StandardOpenOption.APPEND)) {
            bufferedWriter.write("+ " + taskName);
            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new TodoException();
        }
        return List.of();
    }
}
