package com.Todo.Todobackend.Controller;

import com.Todo.Todobackend.Entity.Todo;
import com.Todo.Todobackend.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    TodoService ts;

    //fetch all tasks
    @GetMapping("/alltasks")
    public ResponseEntity<List<Todo>> getAllQuestions(){
        return ts.getAllTasks();

    }

    //fetch task By id
    @GetMapping("/gettaskbyid/{id}")
    public ResponseEntity<Todo> getTaskById(@PathVariable int id){
        return ts.getTaskById(id);
    }

    //new task addition
    @PostMapping("/addTask")
    public ResponseEntity<String> addTask(@RequestBody Todo todo){
    return ts.addTask(todo);
    }

    //delete task
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteTask(@PathVariable int id){

        return ts.deleteTask(id);
    }


    //update a task
    @PutMapping("/update/{id}")
    public ResponseEntity<Todo> updateTask(@PathVariable int id,@RequestBody Todo todo){
        return ts.updateTask(id,todo);

    }

    @DeleteMapping("/taskcompleted/{id}")
    public  ResponseEntity<String> TaskCompleted(@PathVariable int id){
        return ts.TaskCompleted(id);
    }



}
