package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    ObservableList<Contact> contacts = FXCollections.observableArrayList();
    @FXML
    TextField nameText;
    @FXML
    TextField phoneText;
    @FXML
    TextField emailText;
    @FXML
    ListView listView;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listView.setItems(contacts);
    }

    public void addContact(){
        if (nameText.getText().equals("") || phoneText.getText().equals("") || emailText.getText().equals("")){
            return;
        } else {
            Contact contact = new Contact(nameText.getText(), phoneText.getText(), emailText.getText());
            contacts.add(contact);
            nameText.setText("");
            phoneText.setText("");
            emailText.setText("");
        }
    }

    public void removeContact(){
        Contact contact = (Contact) listView.getSelectionModel().getSelectedItem();
        if (contact !=null){
            contacts.remove(contact);
        }
    }
}
