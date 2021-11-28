package com.todolist.controller;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.todolist.model.Todo;
import com.todolist.repository.TodoRepository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TodoService.class})
@ExtendWith(SpringExtension.class)
class TodoServiceTest {
    @MockBean
    private TodoRepository todoRepository;

    @Autowired
    private TodoService todoService;

    @Test
    void testKaydet() {
        Todo todo = new Todo();
        todo.setId(123L);
        todo.setAciklama("Aciklama");
        when(this.todoRepository.save((Todo) any())).thenReturn(todo);

        Todo todo1 = new Todo();
        todo1.setId(123L);
        todo1.setAciklama("Aciklama");
        this.todoService.kaydet(todo1);
        verify(this.todoRepository).save((Todo) any());
        assertTrue(this.todoService.getAllTodo().isEmpty());
    }

    @Test
    void testGetAllTodo() {
        ArrayList<Todo> todoList = new ArrayList<>();
        when(this.todoRepository.findAll()).thenReturn(todoList);
        List<Todo> actualAllTodo = this.todoService.getAllTodo();
        assertSame(todoList, actualAllTodo);
        assertTrue(actualAllTodo.isEmpty());
        verify(this.todoRepository).findAll();
    }
}

