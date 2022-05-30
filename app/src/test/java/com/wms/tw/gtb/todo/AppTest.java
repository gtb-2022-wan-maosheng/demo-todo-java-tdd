package com.wms.tw.gtb.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

class AppTest {

    private App app;

    @BeforeEach
    void setUp() {
        writeDataFile(List.of(
                "+ Task 01",
                "+ Task 02",
                "x Task 03",
                "x Task 04"));
        app = new App();
    }


    @Nested
    class ListCommand {
        @Nested
        class WhenThereAreExistingTasks {
            @Test
            void shoule_list_exsiting_tasks() {
                // Given -> Arrange
                // When -> Act
                final var result = app.run();
                // Then -> Assert
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
                //Given -> Arrange
                //When -> Act
                app.run("add", "foobar");
                //Then -> Assert
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

        @Nested
        class WhenMultipleWordProvided{
            @Test
            void shoule_use_all_worlds_as_name() {
                //Given -> Arrange
                //When -> Act
                app.run("add", "fizz", "buzz");
                //Then -> Assert
                final var result = new App().run();
                Assertions.assertEquals(List.of(
                                "# To be done",
                                "1 Task 01",
                                "2 Task 02",
                                "5 fizz buzz",
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
