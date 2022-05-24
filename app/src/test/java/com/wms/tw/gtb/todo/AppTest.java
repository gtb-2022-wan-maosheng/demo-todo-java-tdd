package com.wms.tw.gtb.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class AppTest {

    @Test
    void shoule_list_exsiting_tasks() {
        final var result = new App().run();
        Assertions.assertEquals(List.of("Task 01", "Task 02"), result);
    }
}
