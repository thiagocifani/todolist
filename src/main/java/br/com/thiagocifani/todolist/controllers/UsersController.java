package br.com.thiagocifani.todolist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.thiagocifani.todolist.models.User;
import br.com.thiagocifani.todolist.repositories.IUserRepository;

/**
 * Modificador
 * public
 * private
 * protected
 */
@RestController
@RequestMapping("/users")
public class UsersController {

  @Autowired
  private IUserRepository userRepository;

  @PostMapping("/")
  public ResponseEntity create(@RequestBody User requestUser) {
    var user = this.userRepository.findByUsername(requestUser.getUsername());

    if (user != null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe");
    } else {

      var passwordHashred = BCrypt.withDefaults()
          .hashToString(12, requestUser.getPassword().toCharArray());

      requestUser.setPassword(passwordHashred);

      return ResponseEntity.status(HttpStatus.CREATED).body(this.userRepository.save(requestUser));
    }
  }
}