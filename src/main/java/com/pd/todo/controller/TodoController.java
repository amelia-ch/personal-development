package com.pd.todo.controller;

import com.pd.todo.dto.ResponseDTO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pd.todo.entity.TodoEntity;
import com.pd.todo.repository.TodoRepository;
import com.pd.todo.services.TodoService;
import javax.annotation.security.RolesAllowed;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @Autowired
    TodoRepository todoRepository;
    
    @Autowired
    TodoService todoService;

    @GetMapping("/getAllTodo")
    @RolesAllowed({ "admin", "guest" })
    public ResponseDTO getAll() {
        return todoService.findAll();
    }

    @GetMapping("/getById/{id}")
    @RolesAllowed({ "admin", "guest" })
    public ResponseDTO getById(@PathVariable Long id) {
        return todoService.findOneById(id);
    }

    @PutMapping("/updateTodo")
    @RolesAllowed("admin")
    public ResponseDTO updateTodo(@RequestBody TodoEntity todoEntity) {
        return todoService.post(todoEntity);
    }

    @PostMapping("/postTodo")
    @RolesAllowed("admin")
    public ResponseDTO postTodo(@RequestBody TodoEntity todo) {
        return todoService.post(todo);
    }

    @PostMapping("/deleteTodo/{id}")
    @RolesAllowed("admin")
    public ResponseDTO deleteTodo(@PathVariable Long id) {
         return todoService.deleteOne(id);
        
    }

}
