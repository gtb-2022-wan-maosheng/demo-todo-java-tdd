package com.wms.tw.gtb.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

class AppTest {

    @BeforeEach
    void setUp() {
        writeDataFile(List.of(
                "+ Task 01",
                "+ Task 02",
                "x Task 03",
                "x Task 04"));
    }


    @Nested
    class ListCommand {
        @Nested
        class WhenThereAreExistingTasks {
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
        }
    }
    @Nested
    class AddCommand {
        @Nested
        class WhenSingleWordProvided{
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
    }

    private void writeDataFile(List<String> lines) {
        try (var bufferedWriter = Files.newBufferedWriter(Constants.TASK_FILE_PATH)) {
            for (String line : lines) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getCause());
        }
    }
}
