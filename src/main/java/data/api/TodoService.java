package data.api;

import java.util.List;

// External Service -
public interface TodoService {
    public List<String> retrieveTodos(String user);
    public void  deleteTodo(String todo);
}