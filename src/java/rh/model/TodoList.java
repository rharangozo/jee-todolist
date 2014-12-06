package rh.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Roland
 */
@Named
@SessionScoped
public class TodoList implements Serializable {

    private List<TodoItem> todos = new LinkedList<>();

    {
        TodoItem e = new TodoItem();
        e.setTitle("test");
        todos.add(e);
    }

    public void addTodos(TodoItem item) {
        if (item != null) {
            todos.add(new TodoItem(item));
            item.setTitle("");
        }
    }

    public void remove(TodoItem item) {
        if (item != null) {
            todos.remove(item);
        }
    }

    public int size() {
        return todos.size();
    }

    public List<TodoItem> getTodos() {
        return Collections.unmodifiableList(todos);
    }

    public void up(TodoItem item) {
        int index = todos.indexOf(item);
        if (index > 0) {
            Collections.swap(todos, index, index - 1);
        }
    }

    public boolean upDisabled(TodoItem item) {
        return todos.indexOf(item) <= 0;
    }

    public void down(TodoItem item) {
        int index = todos.indexOf(item);
        if (index < (todos.size() - 1) && index != -1) {
            Collections.swap(todos, index, index + 1);
        }
    }

    public boolean downDisabled(TodoItem item) {
        int index = todos.indexOf(item);
        return index == -1 || index > (todos.size() - 2);
    }
}
