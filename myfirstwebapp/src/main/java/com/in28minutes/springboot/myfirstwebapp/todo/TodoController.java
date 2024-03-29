package com.in28minutes.springboot.myfirstwebapp.todo;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.Authenticator;
import java.time.LocalDate;
import java.util.List;

//@Controller
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(Model model, HttpSession session) {

        List<Todo> todos = todoService.findByUsername(getLoggenInUsername());
        model.addAttribute("todos", todos);
        return "listTodos";
    }

    private String getLoggenInUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(HttpSession session, Model model) {
        Todo todo = new Todo(0, getLoggenInUsername(), "", LocalDate.now().plusYears(1), false);
        model.addAttribute("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodoPage(HttpSession session, @Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "todo";
        }

        todoService.addTodo(getLoggenInUsername(), todo.getDescription(), todo.getTargetDate(), false);
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id, Model model) {
        todoService.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, Model model) {
        Todo todo = todoService.findById(id);
        model.addAttribute("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(Model model,@Valid Todo todo, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "todo";
        }
        todo.setUsername(getLoggenInUsername());
        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }
}