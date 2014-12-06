package rh.model;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("TodoItemConverter")
public class TodoItemConverter implements Converter {

    @Override
    public TodoItem getAsObject(FacesContext context, UIComponent component, String value) {
        TodoItem todoItem = new TodoItem();
        todoItem.setTitle(value);
        return todoItem;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((TodoItem) value).getTitle();
    }

}
