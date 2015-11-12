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
        // TODO Appeler todoService.findAll et le stocker dans todos
        // NOTE fait un try/catch et mettez l'exception dans exceptionThrown
        try {
          todos = todoService.findAll();
        } catch(Exception e) {
            exceptionThrown = e;
        }
    }

    @Then("^I get a list of size (\\d+)$")
    public void i_get_a_list_of_size(int todoListSize) throws Throwable {
        // TODO Valider la taille de todos par rapport à todoListSize (en utilisant les assert de JUnit)
        assertEquals(todos.size(), todoListSize);
    }

    @When("^I run findOne with id (\\d+)$")
    public void i_run_findOne_with_id(int todoId) throws Throwable {
        try {
            todo = todoService.findOne(todoId);
        } catch(Exception e) {
            exceptionThrown = e;
        }
        // TODO Appeler todoService.findOne et le stocker dans todos
        // NOTE fait un try/catch et mettez l'exception dans exceptionThrown
    }

    @Then("^I get a Todo object$")
    public void i_get_a_Todo_object() throws Throwable {
        // TODO S'assurer que todo n'est pas null
        assertNotNull(todo);
    }

    @Then("^It is completed$")
    public void it_is_completed() throws Throwable {
        // TODO s'assurer que l'attribut completed to todo est à true
        assertTrue(todo.isCompleted());
    }

    @Then("^It has no due date$")
    public void it_has_no_due_date() throws Throwable {
        // TODO s'assurer que l'attribut dueDate de todo est null
        assertNull(todo.getDue());
    }

    @Then("^I get an IllegalArgumentException$")
    public void i_get_an_IllegalArgumentException() throws Throwable {
        // TODO valider que exceptionThrown n'est pas null et qu'il est du type souhaité
        assertNotNull(exceptionThrown);
        assertTrue(exceptionThrown instanceof IllegalArgumentException);
    }



    //////////////// PART 2 ////////////////////

    @Then("^It is not completed$")
    public void it_is_not_completed() throws Throwable {
        // TODO s'assurer que l'attribut completed to todo est à true
        assertFalse(todo.isCompleted());
    }


    @Then("^It has a due date$")
    public void it_has_a_due_date() throws Throwable {
        // TODO s'assurer que l'attribut dueDate de todo est not null
        assertNotNull(todo.getDue());
    }




}
