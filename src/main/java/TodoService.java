import java.util.List;

public interface TodoService {
    List<String> getTodoList();

    void deleteList(String s);
}
