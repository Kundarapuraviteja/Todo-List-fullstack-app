package com.Todo.Todobackend.Dao;

import com.Todo.Todobackend.Entity.CompletedTasks;
import com.Todo.Todobackend.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompletedDao extends JpaRepository<CompletedTasks,Integer> {

}
