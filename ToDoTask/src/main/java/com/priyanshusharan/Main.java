package com.priyanshusharan;

import com.priyanshusharan.Entity.Task;
import com.priyanshusharan.Service.ITodoService;
import com.priyanshusharan.Service.ToDoServiceFactory;
import com.priyanshusharan.Service.TodoService;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ITodoService todo = ToDoServiceFactory.getTodoService();

        Task task1 = Task.builder()
                .tags(List.of("P1"))
                .heading("Task heading 1")
                .note("Task note 1")
                .isCompleted(false)
                .build();

        Task task2 = Task.builder()
                .tags(List.of("P2"))
                .heading("Task heading 2")
                .note("Task note 2")
                .isCompleted(false)
                .build();


        todo.addTask(task1);
        todo.addTask(task2);
        todo.getDetails();

        todo.markTaskCompleted(task1.getId());
        System.out.println(todo.getTask(1));
        todo.getDetails();


        LocalDateTime from = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
        LocalDateTime to = LocalDateTime.now().plusDays(1).withHour(0).withMinute(0).withSecond(0);
        todo.getStatisics(from,to);
    }
}