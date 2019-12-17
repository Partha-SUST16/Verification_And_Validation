import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

class TodoServiceImplTest {
    @Test
    void deleteTodoServiceTest() {
        TodoService todoService = mock(TodoService.class);
//Give
        List<String> allTodo = Arrays.asList("Learn spring" , "16 is winner", "they know spring");

        when(todoService.getTodoList()).thenReturn(allTodo);

        TodoServiceImpl serviceImpl = new TodoServiceImpl(todoService);
//When
        serviceImpl.deleteTextFromList();

//        verify(todoService, Mockito.never()).deleteList("spring");
//then
        then(todoService).should(never()).deleteList("spring");
    }

    @Test
    void deleteTodoServiceTestArgument() {
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        TodoService todoService = mock(TodoService.class);
//Give
        List<String> allTodo = Arrays.asList("Learn spring" , "16 is winner", "they know spring");

        when(todoService.getTodoList()).thenReturn(allTodo);

        TodoServiceImpl serviceImpl = new TodoServiceImpl(todoService);
//When
        serviceImpl.deleteTextFromList();

//        verify(todoService, Mockito.never()).deleteList("spring");
//then
        then(todoService).should().deleteList(captor.capture());

        System.out.println(captor.getAllValues());
        assertThat(captor.getAllValues().size(), is(1));
    }
}