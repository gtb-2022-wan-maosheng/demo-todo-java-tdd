package com.wms.tw.gtb.todo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class App {
    public static void main(String[] args) {

    }

    public List<String> run() {
        try {
            return Files.readAllLines(Path.of("C:\\Users\\maoshengw\\.todo\\tasks"));
        } catch (IOException e) {
            throw new TodoCannotReadFileException();
        }
    }
}
