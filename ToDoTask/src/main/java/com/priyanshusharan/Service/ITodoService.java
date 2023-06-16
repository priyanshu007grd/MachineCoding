package com.priyanshusharan.Service;

import com.priyanshusharan.Entity.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface ITodoService {

    void markTaskCompleted(Integer taskId);
    void addTask(Task task);
    Task getTask(Integer taskId);
    void modifyTask(Task task);
    void removeTask(Integer taskId);

    //List<Task> listTask();
    void getStatisics(LocalDateTime from, LocalDateTime to);
    //void getActivityLog();

    void getDetails();

}
