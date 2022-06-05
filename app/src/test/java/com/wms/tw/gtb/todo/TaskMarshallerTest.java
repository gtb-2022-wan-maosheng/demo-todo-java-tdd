package com.wms.tw.gtb.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class TaskMarshallerTest {
    @Test
    void should_parse_completed_property_for_task() {
        final var isCompleted = TaskMarshaller.unmarshal(1, "+ foobar").isCompleted();
        assertFalse(isCompleted);
    }

    @Test
    void should_support_name_with_multiple_whitespaces() {
        final var task = TaskMarshaller.unmarshal(1, "+     foo    bar  ");
        Assertions.assertEquals("    foo    bar  ", task.getName());
    }
}
