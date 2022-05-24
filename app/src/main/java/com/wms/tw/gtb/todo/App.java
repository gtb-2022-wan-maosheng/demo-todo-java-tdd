package com.wms.tw.gtb.todo;

import java.io.IOException;
import java.nio.file.Files;

import java.util.List;

public class App {

    public static void main(String[] args) {

    }

    public List<String> run() {
        try {
            return Files.readAllLines(Constants.TASK_FILE_PATH);
        } catch (IOException e) {
            throw new TodoCannotReadFileException();
        }
    }
}
