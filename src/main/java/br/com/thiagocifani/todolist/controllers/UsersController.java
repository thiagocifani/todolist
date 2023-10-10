package br.com.thiagocifani.todolist.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.thiagocifani.todolist.models.User;

/**
 * Modificador
 * public
 * private
 * protected
 */
@RestController
@RequestMapping("/users")
public class UsersController {

  /**
   * String
   * Integer
   * Double
   * Float
   * char
   * Date
   * void
   */
  /*
   * Body
   */
  @PostMapping("/")
  public void create(@RequestBody User user) {
    System.out.println(user.getName());

  }
}
