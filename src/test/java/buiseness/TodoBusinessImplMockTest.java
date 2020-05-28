package buiseness;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

import data.api.TodoService;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

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
    @Test
    public void testDeleteTodosNotRelatedToSpring()
    {
        TodoService todoService = mock(TodoService.class);

        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");

        when(todoService.retrieveTodos("User")).thenReturn(allTodos);

        TodoBusiness todoBusinessImpl = new TodoBusiness(todoService);

        todoBusinessImpl.deleteTodoNotRelatedtoSpring("User");

        verify(todoService).deleteTodo("Learn to Dance");

        verify(todoService,never()).deleteTodo("Learn Spring MVC");

        verify(todoService, never()).deleteTodo("Learn Spring");

        verify(todoService, times(1)).deleteTodo("Learn to Dance");
        // atLeastOnce, atLeast

    }
    @Test
    public void captureArgument() {
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor
                .forClass(String.class);

        TodoService todoService = mock(TodoService.class);

        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");
        when(todoService.retrieveTodos("user")).thenReturn(allTodos);

        TodoBusiness todoBusinessImpl = new TodoBusiness(todoService);
        todoBusinessImpl.deleteTodoNotRelatedtoSpring("user");
        verify(todoService).deleteTodo(argumentCaptor.capture());

        assertEquals("Learn to Dance", argumentCaptor.getValue());

    }
}
