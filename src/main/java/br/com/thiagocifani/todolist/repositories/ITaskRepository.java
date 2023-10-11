package br.com.thiagocifani.todolist.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.thiagocifani.todolist.models.Task;

public interface ITaskRepository extends JpaRepository<Task, UUID> {

}
