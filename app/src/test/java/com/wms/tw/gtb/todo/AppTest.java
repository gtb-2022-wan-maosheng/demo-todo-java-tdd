package com.wms.tw.gtb.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class AppTest {

    @Test
    void shoule_list_exsiting_tasks() {
        final var result = new App().run();
        Assertions.assertEquals(List.of(
                "# To be done",
                "1 Task 01",
                "2 Task 02",
                "# Completed",
                "3 Task 03",
                "4 Task 04"),
                result);

    }

    @Test
    void shoule_add_task_with_single_world_as_name() {
        new App().run("add", "foobar");
        final var result = new App().run();
        Assertions.assertEquals(List.of(
                "# To be done",
                "1 Task 01",
                "2 Task 02",
                "5 foobar",
                "# Completed",
                "3 Task 03",
                "4 Task 04"),
                result);

    }
}
