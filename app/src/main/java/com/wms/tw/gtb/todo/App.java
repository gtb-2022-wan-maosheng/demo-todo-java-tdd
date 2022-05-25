package com.wms.tw.gtb.todo;

import java.util.List;

public class App {

    private final ListCommand listCommand = new ListCommand();

    public static void main(String[] args) {

    }

    public List<String> run() {
        return listCommand.run();
    }

}
