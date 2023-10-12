package br.com.thiagocifani.todolist.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.thiagocifani.todolist.models.Task;
import br.com.thiagocifani.todolist.repositories.ITaskRepository;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/tasks")
public class TasksController {

  @Autowired
  private ITaskRepository taskRepository;

  @PostMapping("/")
  public Task create(@RequestBody Task requestTask, HttpServletRequest request) {
    var userId = request.getAttribute("userId");
    requestTask.setUserId((UUID) userId);
    return this.taskRepository.save(requestTask);
  }

}
