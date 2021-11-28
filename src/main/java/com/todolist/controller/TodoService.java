package com.todolist.controller;

import com.todolist.model.Todo;
import com.todolist.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    @Transactional
    public void kaydet(Todo todo){
        this.todoRepository.save(todo);
    }

    @Transactional(readOnly = true)
    public List<Todo> getAllTodo(){
        return this.todoRepository.findAll();
    }
}
