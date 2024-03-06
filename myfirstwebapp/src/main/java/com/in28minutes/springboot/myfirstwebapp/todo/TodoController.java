package com.in28minutes.springboot.myfirstwebapp.todo;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(Model model){
        List<Todo> todos = todoService.findByUsername("in28minutes");
        model.addAttribute("todos", todos);
        return "listTodos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(HttpSession session, Model model){
        Todo todo = new Todo(0, (String) session.getAttribute("name"),"",LocalDate.now().plusYears(1),false);
        model.addAttribute("todo", todo);
        return "todo";
    }
    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodoPage(HttpSession session, @Valid Todo todo, BindingResult result){

        if(result.hasErrors()){
            return "todo";
        }

        todoService.addTodo((String)session.getAttribute("name"),todo.getDescription(), LocalDate.now().plusYears(1), false);
        return "redirect:list-todos";
    }


}
