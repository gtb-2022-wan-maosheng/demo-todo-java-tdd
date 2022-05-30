package com.wms.tw.gtb.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class AddCommandTest {

    private MyTaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository = new MyTaskRepository();
    }

    @Test
    void shoule_compose_task_using_multiple_words() {
        final var command = new AddCommand(taskRepository, "add", "fizz", "buzz");
        command.execute();
        Assertions.assertEquals("fizz buzz", taskRepository.getTaskName());
    }

    @Test
    void shoule_use_empty_when_no_args_provided() {
        final var command = new AddCommand(taskRepository, "add");
        command.execute();
        Assertions.assertEquals("", taskRepository.getTaskName());
    }

    private static class MyTaskRepository extends TaskRepository {
        private Task task;

        @Override
        List<String> create(Task task) {
            this.task = task;
            return List.of();
        }

        public String getTaskName() {
            return this.task.getName();
        }
    }
}
