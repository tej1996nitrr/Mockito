package buiseness;

import data.api.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplInjectMockTest {

    @Mock
    TodoService todoService;

    @InjectMocks
    TodoBusiness todoBusinessImpl;
    @Captor
    ArgumentCaptor<String > argumentCaptor;

    @Test
    public void usingMockito()
    {
        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");
        when(todoService.retrieveTodos("Username")).thenReturn(allTodos);
        List<String> todos = todoBusinessImpl
                .retrieveTodosRelatedToSpring("Username");
        assertEquals(2, todos.size());
    }
    @Test
    public void usingMockitoEmptyList()
     {
        List<String> allTodos = Arrays.asList();
        when(todoService.retrieveTodos("Username")).thenReturn(allTodos);//dynamic stubbing
        List<String> todos = todoBusinessImpl
                .retrieveTodosRelatedToSpring("Username");
        assertEquals(0, todos.size());
    }
    @Test
    public void testDeleteTodosNotRelatedToSpring()
    {
        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");
        when(todoService.retrieveTodos("User")).thenReturn(allTodos);
        todoBusinessImpl.deleteTodoNotRelatedtoSpring("User");
        verify(todoService).deleteTodo("Learn to Dance");
        verify(todoService,never()).deleteTodo("Learn Spring MVC");
        verify(todoService, never()).deleteTodo("Learn Spring");
        verify(todoService, times(1)).deleteTodo("Learn to Dance");
        // atLeastOnce, atLeast

    }
    @Test
    public void captureArgument() {

        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");
        when(todoService.retrieveTodos("user")).thenReturn(allTodos);
        todoBusinessImpl.deleteTodoNotRelatedtoSpring("user");
        verify(todoService).deleteTodo(argumentCaptor.capture());
        assertEquals("Learn to Dance", argumentCaptor.getValue());

    }
}
