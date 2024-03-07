package com.in28minutes.springboot.myfirstwebapp.todo;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class TodoControllerJpa {

    private TodoRepository todoRepository;

    public TodoControllerJpa(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(Model model) {
        //List<Todo> todos = todoService.findByUsername(getLoggenInUsername());
        List<Todo> todos = todoRepository.findByUsername(getLoggenInUsername());
        model.addAttribute("todos", todos);
        return "listTodos";
    }

    private String getLoggenInUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(Model model) {
        Todo todo = new Todo(0, getLoggenInUsername(), "", LocalDate.now().plusYears(1), false);
        model.addAttribute("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodoPage(@Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "todo";
        }
        todo.setUsername(getLoggenInUsername());
        todoRepository.save(todo);
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id, Model model) {
        todoRepository.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, Model model) {

        Todo todo = todoRepository.findById(id).orElse(null);
        model.addAttribute("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(@Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        todo.setUsername(getLoggenInUsername());
        todoRepository.save(todo);
        return "redirect:list-todos";
    }
}