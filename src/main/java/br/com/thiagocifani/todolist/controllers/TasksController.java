package br.com.thiagocifani.todolist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.thiagocifani.todolist.models.Task;
import br.com.thiagocifani.todolist.repositories.ITaskRepository;

@RestController
@RequestMapping("/tasks")
public class TasksController {

  @Autowired
  private ITaskRepository taskRepository;

  @PostMapping("/")
  public Task create(@RequestBody Task requestTask) {
    return this.taskRepository.save(requestTask);
  }

}
