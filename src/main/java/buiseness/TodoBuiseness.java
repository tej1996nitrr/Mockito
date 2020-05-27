package buiseness;

import data.api.TodoService;

import java.util.ArrayList;
import java.util.List;


class TodoBusiness {
    private final TodoService todoService;

    TodoBusiness(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<String> retrieveTodosRelatedToSpring(String user) {
        //System under test -TodoBuisness (SUT)
        //Dependency-TodoService
        List<String> filteredTodos = new ArrayList<String>();
        List<String> allTodos = todoService.retrieveTodos(user);
        for (String todo : allTodos) {
            if (todo.contains("Spring")) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }
}