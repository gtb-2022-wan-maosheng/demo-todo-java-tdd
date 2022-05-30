package com.wms.tw.gtb.todo;

import java.util.List;

public class App {

    public static void main(String[] args) {
        new App().run().forEach(System.out::println);
    }

    public List<String> run(String... args) {
        if (args.length > 0 && args[0].equals("add")) {
            return new AddCommand(new TaskRepository(), args).execute();
        }
        return new ListCommand().run();
    }

}
