package org.ichillous.tests.todo_db.service;

import org.ichillous.tests.todo_db.model.Todo;
import org.ichillous.tests.todo_db.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository todoRepository;
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Optional<Todo> findOne(Long id) {
        return todoRepository.findById(id);
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo update(Long id, Todo updatedTodo) {
        return todoRepository.findById(id)
                .map(todo -> {
                    todo.setTitle(updatedTodo.getTitle());
                    todo.setSubtitle(updatedTodo.getSubtitle());
                    todo.setDescription(updatedTodo.getDescription());
                    return todoRepository.save(todo);
                })
                .orElseGet(() -> {
                    updatedTodo.setId(id);
                    return todoRepository.save(updatedTodo);
                });
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }


}
