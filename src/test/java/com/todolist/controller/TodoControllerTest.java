package com.todolist.controller;

import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.todolist.model.Todo;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.server.ResponseStatusException;

@ContextConfiguration(classes = {TodoController.class})
@ExtendWith(SpringExtension.class)
class TodoControllerTest {
    @Autowired
    private TodoController todoController;

    @MockBean
    private TodoService todoService;

    @Test
    void testGetAllTodo() throws Exception {
        when(this.todoService.getAllTodo()).thenThrow(new ResponseStatusException(HttpStatus.CONTINUE));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/todo-control");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.todoController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(501));
    }

    @Test
    void testKaydet() throws Exception {
        when(this.todoService.getAllTodo()).thenThrow(new ResponseStatusException(HttpStatus.CONTINUE));

        Todo todo = new Todo();
        todo.setId(123L);
        todo.setAciklama("Aciklama");
        String content = (new ObjectMapper()).writeValueAsString(todo);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/todo-control")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.todoController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(501));
    }
}

