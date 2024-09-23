package org.ichillous.tests.todo_db.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;

@Entity
@Data
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String subtitle;

    private String description;

}
