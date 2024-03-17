package com.Todo.Todobackend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="todo")
public class Todo {

    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    int taskId;
    String TaskName;
    String TaskDesc;
    String TaskDate;

    public Todo(){

    }

    public Todo(int taskId, String taskName, String taskDesc, String taskDate) {
        this.taskId = taskId;
        TaskName = taskName;
        TaskDesc = taskDesc;
        TaskDate = taskDate;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return TaskName;
    }

    public void setTaskName(String taskName) {
        TaskName = taskName;
    }

    public String getTaskDesc() {
        return TaskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        TaskDesc = taskDesc;
    }

    public String getTaskDate() {
        return TaskDate;
    }

    public void setTaskDate(String taskDate) {
        TaskDate = taskDate;
    }
}
