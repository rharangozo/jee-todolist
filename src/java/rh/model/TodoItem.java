package rh.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class TodoItem {
    
    private String title;

    public TodoItem(){
    }
    
    public TodoItem(TodoItem todoItem) {
        this.title = todoItem.getTitle();
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
