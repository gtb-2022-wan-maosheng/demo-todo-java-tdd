package com.wms.tw.gtb.todo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class AddCommandTest {

    private TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository = mock(TaskRepository.class);
    }

    @Test
    void shoule_compose_task_using_multiple_words() {
        final var command = createCommandFrom("add", "fizz", "buzz");
        command.execute();
        verify(taskRepository).create(new Task(0, "fizz buzz", false));
    }

    @Test
    void shoule_use_empty_when_no_args_provided() {
        final var command = createCommandFrom("add");
        command.execute();
        verify(taskRepository).create(new Task(0, "", false));
    }

    private AddCommand createCommandFrom(String... args) {
        return new AddCommand(taskRepository, args);
    }

}
