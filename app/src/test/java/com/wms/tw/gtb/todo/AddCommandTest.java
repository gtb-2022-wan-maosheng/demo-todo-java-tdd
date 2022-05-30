package com.wms.tw.gtb.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class AddCommandTest {
    @Test
    void shoule_compose_task_using_multiple_words() {
        final var taskRepository = new TaskRepository(){
            private Task task;

            @Override
            List<String> create(Task task) {
                this.task = task;
                return List.of();
            }

            public String getTaskName() {
                return this.task.getName();
            }
        };

        final var command = new AddCommand(taskRepository, "add", "fizz", "buzz");
        command.execute();
        final var taskName = taskRepository.getTaskName();
        Assertions.assertEquals("fizz buzz", taskName);
    }
}
