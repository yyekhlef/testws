package com.github.vdemeester.testws.model;

import java.time.LocalDateTime;
import java.util.Objects;
public class Todo {

    private final Integer id;
    private final String name;
    private final Boolean completed;
    private final LocalDateTime due;


    public Todo(Integer id,
                String name,
                Boolean completed,
                LocalDateTime due) {
        this.id = id;
        this.name = name;
        this.completed = completed;
        this.due = due;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean isCompleted() {
        return completed;
    }

    public LocalDateTime getDue() {
        return due;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return Objects.equals(id, todo.id) &&
                Objects.equals(name, todo.name) &&
                Objects.equals(completed, todo.completed) &&
                Objects.equals(due, todo.due);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, completed, due);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Todo{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", completed=").append(completed);
        sb.append(", due=").append(due);
        sb.append('}');
        return sb.toString();
    }
}
