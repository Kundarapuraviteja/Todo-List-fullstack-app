package com.Todo.Todobackend.Controller;

import com.Todo.Todobackend.Entity.CompletedTasks;
import com.Todo.Todobackend.Entity.Todo;
import com.Todo.Todobackend.Service.CompletedTaskService;
import com.Todo.Todobackend.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/completed")
public class CompletedTaskController {
    @Autowired
    CompletedTaskService cts;

    @PostMapping("/setcomplete/{id}")
    public ResponseEntity<String> TaskCompleted(@PathVariable int id){
        return cts.taskCompleted(id);
    }

    @GetMapping("/allcompletedtasks")
    public ResponseEntity<List<CompletedTasks>> getAllCompletedTaks(){
        return cts.getAllTasks();
    }



    @DeleteMapping("/deletealltasks")
    public ResponseEntity<String> deleteAllTasks(){
        return cts.deleteAllTasks();
    }

}
