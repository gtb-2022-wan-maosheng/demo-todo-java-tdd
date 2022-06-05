package com.wms.tw.gtb.todo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskMarshallerTest {

    private TaskMarshaller taskMarshaller;

    @BeforeEach
    void setUp() {
        taskMarshaller = new TaskMarshaller();
    }

    @ParameterizedTest
    @MethodSource("lines_and_tasks")
    void should_marshal_to_plain_text(String line, Task task) {
        assertEquals(line, taskMarshaller.marshal(task));
    }

    public static Stream<Arguments> lines_and_tasks() {
        return Stream.of(
                Arguments.of("+ foobar", new Task(1, "foobar", false)),
                Arguments.of("+     foo    bar  ", new Task(1, "    foo    bar  ", false))

        );
    }
}
