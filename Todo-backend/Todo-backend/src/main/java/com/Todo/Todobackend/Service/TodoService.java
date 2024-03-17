package com.Todo.Todobackend.Service;

import com.Todo.Todobackend.Controller.CompletedTaskController;
import com.Todo.Todobackend.Dao.TodoDao;
import com.Todo.Todobackend.Entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Optionals;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    TodoDao td;

    @Autowired
    CompletedTaskController cts;
    public ResponseEntity<List<Todo>> getAllTasks() {
        try {
            return new ResponseEntity<>(td.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }


    public ResponseEntity<String> addTask(Todo todo) {
        td.save(todo);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }


    public ResponseEntity<HttpStatus> deleteTask(int id) {
        Todo t=td.findById(id)
                        .orElseThrow(()-> new ResourceAccessException("Task not exist: "+id));
        td.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Todo> getTaskById(int id) {
       Todo t=td.findById(id)
               .orElseThrow(()->new ResourceAccessException("Task not found: "+id));
       return ResponseEntity.ok(t);


    }

    public ResponseEntity<Todo> updateTask(int id,Todo todo) {
        Todo t=td.findById(id).
                orElseThrow(()->new ResourceAccessException("Task not exists with id"+id));
        t.setTaskDesc(todo.getTaskDesc());
        t.setTaskDate(todo.getTaskDate());
        t.setTaskName(todo.getTaskName());
        td.save(t);
        return ResponseEntity.ok(t);
    }


    public ResponseEntity<String> TaskCompleted(int id) {
        cts.TaskCompleted(id);
        td.deleteById(id);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }


}
