package com.kchar.todolist;

import com.kchar.todolist.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<TodoItem> todoItems;

    @FXML
    private ListView<TodoItem> todoListView;

    @FXML
    private TextArea itemDetailsTextArea;

    public void initialize() {
        TodoItem item1 = new TodoItem("Mail birthday card", "Buy bday card for Jake",
                LocalDate.of(2021, Month.FEBRUARY, 23));
        TodoItem item2 = new TodoItem("Doctors appt", "Appointment with dr. mcdouble @ mcdonalds", LocalDate.of(2021, Month.JANUARY, 12));
        TodoItem item3 = new TodoItem("It's mah birthday", "Throw a fat party",
                LocalDate.of(2020, Month.DECEMBER, 8));
        TodoItem item4 = new TodoItem("Order pizza", "Order pepperoni pizza from Dominos",
                LocalDate.of(2021, Month.MARCH, 5));

        todoItems = new ArrayList<TodoItem>();
        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);
        todoItems.add(item4);

        todoListView.getItems().setAll(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    @FXML
    public void handleClickListView() {
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
//        System.out.println("The selected item is " + item);
        StringBuilder sb = new StringBuilder(item.getDetails());
        sb.append("\n\n\n\n");
        sb.append("Due: ");
        sb.append(item.getDeadline().toString());
        itemDetailsTextArea.setText(sb.toString());
    }

}