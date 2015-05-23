package com.github.vdemeester.testws;

import com.github.vdemeester.testws.model.Todo;
import com.github.vdemeester.testws.service.TodoService;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.*;

public class BasicStepdefs {

    private List<Todo> todos;
    private Todo todo;

    private Throwable exceptionThrown;

    private final TodoService todoService = new TodoService();

    @When("^I run findAll$")
    public void i_run_findAll() throws Throwable {
        try {
            this.todos = todoService.findAll();
        } catch (Exception e) {
            this.exceptionThrown = e;
        }
    }

    @Then("^I get a list of size (\\d+)$")
    public void i_get_a_list_of_size(int todoListSize) throws Throwable {
        assertNotNull(this.todos);
        assertEquals(todoListSize, this.todos.size());
    }

    @When("^I run findOne with id (\\d+)$")
    public void i_run_findOne_with_id(int todoId) throws Throwable {
        try {
            this.todo = todoService.findOne(todoId);
        } catch (Exception e) {
            this.exceptionThrown = e;
        }
    }

    @Then("^I get a Todo object$")
    public void i_get_a_Todo_object() throws Throwable {
        assertNotNull(this.todo);
    }

    @Then("^It is completed$")
    public void it_is_completed() throws Throwable {
        assertNotNull(this.todo);
        assertTrue(this.todo.isCompleted());
    }

    @Then("^It has no due date$")
    public void it_has_no_due_date() throws Throwable {
        assertNotNull(this.todo);
        assertNull(this.todo.getDue());
    }

    @Then("^I get an IllegalArgumentException$")
    public void i_get_an_IllegalArgumentException() throws Throwable {
        assertNotNull(this.exceptionThrown);
        assertTrue(this.exceptionThrown instanceof IllegalArgumentException);
    }

}
