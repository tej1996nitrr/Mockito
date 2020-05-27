package buiseness;
import java.util.List;
import static org.junit.Assert.assertEquals;
import data.api.TodoService;
import data.stub.TodoServiceStub;
import org.junit.Test;

public class TodoBusinessImplStubTest {

@Test
public void usingAStub() {
    TodoService todoService = new TodoServiceStub();
    TodoBusiness todoBusinessImpl = new TodoBusiness(todoService);
    List<String> todos = todoBusinessImpl
            .retrieveTodosRelatedToSpring("User");
    assertEquals(2, todos.size());
}
}