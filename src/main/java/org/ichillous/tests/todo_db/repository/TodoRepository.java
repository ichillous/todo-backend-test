package org.ichillous.tests.todo_db.repository;

import org.ichillous.tests.todo_db.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
