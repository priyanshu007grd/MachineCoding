package com.priyanshusharan.Service;

import com.priyanshusharan.Entity.Log;
import com.priyanshusharan.Entity.Task;
import com.priyanshusharan.storage.LogStorage;
import com.priyanshusharan.storage.TaskStorage;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class ToDoServiceFactory {

    public static TodoService getTodoService() {

        TaskStorage<Integer,Task> task = new TaskStorage<Integer, Task>(0);
        LogStorage<LocalDateTime, Log> log = new LogStorage<>();
        Set<Integer> completedTask = new HashSet<>();
        Set<Integer> pendingTask = new HashSet<>();

        return TodoService.builder()
                .task(task)
                .log(log)
                .completedTask(completedTask)
                .pendingTask(pendingTask)
                .build();
    }
}
