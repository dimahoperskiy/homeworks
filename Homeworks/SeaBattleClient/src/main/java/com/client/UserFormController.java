package com.client;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class UserFormController {
    public TextField userField;
    public Button userButton;
    public TextField enemyField;


    public void addUser() {
        if (userField.getText().isEmpty())
            userField.setPromptText("Put your nickname!");
        if (enemyField.getText().isEmpty())
            enemyField.setPromptText("Put enemy nickname!");
        if (!userField.getText().isEmpty() & !enemyField.getText().isEmpty()) {
            App.setUsername(userField.getText());
            App.controller.usernameLabel.setText("Username: " + App.getUsername());
            App.enemy = enemyField.getText();
            App.setScene(2);
        }
    }



}
