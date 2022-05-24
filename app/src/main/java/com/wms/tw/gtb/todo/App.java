package com.wms.tw.gtb.todo;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

    }

    public List<String> run() {
        final List<String> lines = readTaskLines();
        final var result = new ArrayList<String>();
        result.add("# To be done");
        result.addAll(lines);
        return result;
    }

    private List<String> readTaskLines() {
        try {
            return Files.readAllLines(Constants.TASK_FILE_PATH);
        } catch (IOException e) {
            throw new TodoCannotReadFileException();
        }
    }
}
