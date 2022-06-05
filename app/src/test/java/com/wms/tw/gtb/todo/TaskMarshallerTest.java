package com.wms.tw.gtb.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class TaskMarshallerTest {

    private TaskMarshaller taskMarshaller;

    @BeforeEach
    void setUp() {
        taskMarshaller = new TaskMarshaller();
    }

    @Test
    void should_parse_completed_property_for_task() {
        final var isCompleted = taskMarshaller.unmarshal(1, "+ foobar").isCompleted();
        assertFalse(isCompleted);
    }

    @Test
    void should_support_name_with_multiple_whitespaces() {
        final var task = taskMarshaller.unmarshal(1, "+     foo    bar  ");
        Assertions.assertEquals("    foo    bar  ", task.getName());
    }
}
