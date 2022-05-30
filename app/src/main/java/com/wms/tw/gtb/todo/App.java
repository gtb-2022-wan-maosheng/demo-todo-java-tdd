package com.wms.tw.gtb.todo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class App {

    private final ListCommand listCommand = new ListCommand();

    public static void main(String[] args) {
        new App().run().forEach(System.out::println);
    }

    public List<String> run(String... args) {
        if (args.length > 0 && args[0].equals("add")){
            try (var bufferedWriter = Files.newBufferedWriter(Constants.TASK_FILE_PATH, StandardOpenOption.APPEND)) {
                final var taskName = args[1];
                bufferedWriter.write("+ " + taskName);
                bufferedWriter.newLine();
            } catch (IOException e) {
                throw new TodoCannotReadFileException();
            }
            return List.of();
        }
        return listCommand.run();
    }

}
