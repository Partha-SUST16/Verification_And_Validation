import java.util.ArrayList;
import java.util.List;

public class TodoServiceImpl {
    TodoService service ;

    public TodoServiceImpl(TodoService todoService) {
        service = todoService;
    }

    public List<String> getFilteredList(String name) {
        List<String> list = service.getTodoList();
        List<String> filtered = new ArrayList<String>();

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).contains("spring")) {
                filtered.add(list.get(i));
            }
        }

        return filtered;
    }

    void deleteTextFromList() {
        List<String> list = service.getTodoList();

        for (int i = 0; i < list.size() ; i++) {
            if ( !list.get(i).contains("spring")) {
                service.deleteList(list.get(i));
            }
        }
    }
}
