package com.Todo.Todobackend.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
@Entity
@Table(name="completedTasks")
 public class CompletedTasks{

    @Id
    int id;
    String taskName;
    String taskDesc;
    String taskDate;

   public CompletedTasks(){

    }
    CompletedTasks(Todo todo){
        this.id=todo.getTaskId();
        this.taskName=todo.getTaskName();
        this.taskDate=todo.getTaskDate();
        this.taskDesc=todo.getTaskDesc();
    }



     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

     public String getTaskName() {
         return taskName;
     }

     public void setTaskName(String taskName) {
         this.taskName = taskName;
     }

     public String getTaskDesc() {
         return taskDesc;
     }

     public void setTaskDesc(String taskDesc) {
         this.taskDesc = taskDesc;
     }

     public String getTaskDate() {
         return taskDate;
     }

     public void setTaskDate(String taskDate) {
         this.taskDate = taskDate;
     }
 }
