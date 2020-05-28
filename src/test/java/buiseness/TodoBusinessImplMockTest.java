package buiseness;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import data.api.TodoService;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TodoBusinessImplMockTest {

@Test
public void usingMockito() {
    TodoService todoService = mock(TodoService.class);
    List<String> allTodos = Arrays.asList("Learn Spring MVC",
            "Learn Spring", "Learn to Dance");
    when(todoService.retrieveTodos("Username")).thenReturn(allTodos);
    TodoBusiness todoBusinessImpl = new TodoBusiness(todoService);
    List<String> todos = todoBusinessImpl
            .retrieveTodosRelatedToSpring("Username");
    assertEquals(2, todos.size());
}
    @Test
    public void usingMockitoEmptyList() {
        TodoService todoService = mock(TodoService.class);
        List<String> allTodos = Arrays.asList();
        when(todoService.retrieveTodos("Username")).thenReturn(allTodos);//dynamic stubbing
        TodoBusiness todoBusinessImpl = new TodoBusiness(todoService);
        List<String> todos = todoBusinessImpl
                .retrieveTodosRelatedToSpring("Username");
        assertEquals(0, todos.size());
    }
}
