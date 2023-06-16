package com.priyanshusharan.Service;

import com.priyanshusharan.Entity.Event;
import com.priyanshusharan.Entity.Log;
import com.priyanshusharan.Entity.Task;
import com.priyanshusharan.storage.LogStorage;
import com.priyanshusharan.storage.Storage;
import com.priyanshusharan.storage.TaskStorage;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Builder
public class TodoService implements ITodoService {
    TaskStorage<Integer,Task> task;
    LogStorage<LocalDateTime, Log> log;
    Set<Integer> completedTask;
    Set<Integer> pendingTask;

    public TodoService(TaskStorage<Integer, Task> task, LogStorage<LocalDateTime, Log> log, Set<Integer> completedTask, Set<Integer> pendingTask) {
        this.task = task;
        this.log = log;
        this.completedTask = completedTask;
        this.pendingTask = pendingTask;
    }

    @Override
    public void markTaskCompleted(Integer taskId) {
        this.pendingTask.remove(taskId);
        this.completedTask.add(taskId);

        Task task = this.getTask(taskId);
        task.setIsCompleted(true);
        this.modifyTask(task);

        Log log = Log.builder()
                .dateTime(LocalDateTime.now())
                .event(Event.TASK_COMPLETED)
                .taskId(taskId)
                .build();
        this.log.add(log.getDateTime(),log);
    }

    @Override
    public void addTask(Task task) {

        task.setId(this.task.getKey()+1);
        this.task.add(this.task.getKey()+1,task);
        this.pendingTask.add(task.getId());

        Log log = Log.builder()
                .dateTime(LocalDateTime.now())
                .event(Event.ADD_TASK)
                .taskId(task.getId())
                .build();
        this.log.add(log.getDateTime(),log);
    }

    @Override
    public Task getTask(Integer taskId) {
        return this.task.get(taskId);
    }

    @Override
    public void modifyTask(Task task) {
        this.task.update(task.getId(),task);
        Log log = Log.builder()
                .event(Event.MODIFY_TASK)
                .taskId(task.getId())
                .build();
        this.log.add(LocalDateTime.now(),log);
    }

    @Override
    public void removeTask(Integer taskId) {
        this.task.remove(taskId);
        this.completedTask.remove(taskId);
        this.pendingTask.remove(taskId);
        Log log = Log.builder()
                .event(Event.REMOVE_TASK)
                .taskId(taskId)
                .build();
        this.log.add(LocalDateTime.now(),log);
    }

    @Override
    public void getStatisics(LocalDateTime from, LocalDateTime to) {

        int added=0;
        int completed=0;
        for(Map.Entry<LocalDateTime,Log> e:log.getData().entrySet()) {
            if(e.getKey().isAfter(from) && e.getKey().isBefore(to)) {
                if(e.getValue().getEvent().equals(Event.ADD_TASK)) added++;
                if(e.getValue().getEvent().equals(Event.TASK_COMPLETED)) completed++;
            }
        }

        int spilled = added-completed;
        System.out.println("stats");
        System.out.println("Added : " + added);
        System.out.println("Completed : "  + completed);
        System.out.println("Spill over  : " + spilled);
    }

    public void getDetails() {
        System.out.println();
        System.out.println("taskMap");
        System.out.println(task);

        System.out.println();
        System.out.println("logMap");
        System.out.println(log);

        System.out.println();
        System.out.println("completedTask");
        System.out.println(completedTask);

        System.out.println();
        System.out.println("pendingTask");
        System.out.println(pendingTask);
    }
}
