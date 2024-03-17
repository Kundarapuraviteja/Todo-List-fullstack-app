package com.Todo.Todobackend.Service;

import com.Todo.Todobackend.Dao.CompletedDao;
import com.Todo.Todobackend.Dao.TodoDao;
import com.Todo.Todobackend.Entity.CompletedTasks;
import com.Todo.Todobackend.Entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompletedTaskService {

    @Autowired
    CompletedDao cd;

    @Autowired
    TodoDao td;

    public ResponseEntity<String> taskCompleted(int id) {

        try {
            CompletedTasks c=new CompletedTasks();
            Optional<Todo> t=td.findById(id);
            c.setId(t.get().getTaskId());
            c.setTaskDesc(t.get().getTaskDesc());
            c.setTaskDate(t.get().getTaskDate());
            c.setTaskName(t.get().getTaskName());
            cd.save(c);
            td.deleteById(id);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("failed no id found",HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<List<CompletedTasks>> getAllTasks() {
        try {
            return new ResponseEntity<>(cd.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }




    public ResponseEntity<String> deleteAllTasks() {
        List<CompletedTasks> list=cd.findAll();
        for(CompletedTasks c:list){
            cd.deleteById(c.getId());
        }
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }
}
