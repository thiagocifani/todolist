package br.com.thiagocifani.todolist.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.thiagocifani.todolist.models.User;

public interface IUserRepository extends JpaRepository<User, UUID> {
  User findByUsername(String username);
}
