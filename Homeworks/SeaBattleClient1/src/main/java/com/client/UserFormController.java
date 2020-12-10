package com.client;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class UserFormController {
    public TextField userField;
    public Button userButton;


    public void addUser() {
        App.setUsername(userField.getText());
        App.controller.usernameLabel.setText("Username: " + App.getUsername());
        App.setScene(2);
    }



}
