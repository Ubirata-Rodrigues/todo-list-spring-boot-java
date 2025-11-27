package br.com.ubirataoliveira.desafio_todo_list.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.ubirataoliveira.desafio_todo_list.entity.Todo;
import br.com.ubirataoliveira.desafio_todo_list.repository.TodoRepository;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> create(Todo todo){
        todoRepository.save(todo);
        return list();
    }
    
    public List<Todo> list(){
        
        Sort sort = Sort.by("prioridade").descending().and(
            Sort.by("nome").ascending());
            
            return todoRepository.findAll(sort);
            
        }
        
    public List<Todo> update(Todo todo){
    if (todo.getId() == null) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID é obrigatório");
    }
    
    if (!todoRepository.existsById(todo.getId())) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo não encontrado");
    }
    
    todoRepository.save(todo);
    return list();
    }


    public List<Todo> delete(Long id){
        if (!todoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo não encontrado");
        }
        
        todoRepository.deleteById(id);
        return list();
    }
}
