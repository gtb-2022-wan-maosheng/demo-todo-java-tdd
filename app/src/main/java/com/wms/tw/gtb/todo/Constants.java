package com.wms.tw.gtb.todo;

import java.nio.file.Path;

public class  Constants {
    public Constants() {
    }
    
    public static final String USER_HOME_PATH = System.getProperty("user.home");
    public static final String TODO_CONFIG_ROOT = ".todo";
    public static final String TASKS_FILENAME = "tasks";

    public static final Path TASK_FILE_PATH = Path.of(USER_HOME_PATH, TODO_CONFIG_ROOT, TASKS_FILENAME);
}