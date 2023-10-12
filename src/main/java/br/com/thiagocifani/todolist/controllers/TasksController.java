package br.com.thiagocifani.todolist.controllers;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity create(@RequestBody Task requestTask, HttpServletRequest request) {
    var userId = request.getAttribute("userId");
    requestTask.setUserId((UUID) userId);

    var currentDate = LocalDateTime.now();

    if (currentDate.isAfter(requestTask.getStartAt()) || currentDate.isAfter(requestTask.getEndAt())) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body("A data de início / data de término não pode ser menor que a data atual");
    }

    if (requestTask.getStartAt().isAfter(requestTask.getEndAt())) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body("A data de início não pode ser maior que a data de término");
    }

    var task = this.taskRepository.save(requestTask);

    return ResponseEntity.ok(task);
  }

}
