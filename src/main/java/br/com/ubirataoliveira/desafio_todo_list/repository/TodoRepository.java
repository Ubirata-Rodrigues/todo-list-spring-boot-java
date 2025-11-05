package br.com.ubirataoliveira.desafio_todo_list.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ubirataoliveira.desafio_todo_list.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    // O JpaRepository fornece os métodos CRUD básicos. Ele apenas pede em seus generics a entidade e o tipo do ID.
}
