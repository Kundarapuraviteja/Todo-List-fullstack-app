package com.Todo.Todobackend.Dao;

import com.Todo.Todobackend.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoDao extends JpaRepository<Todo,Integer> {

}
