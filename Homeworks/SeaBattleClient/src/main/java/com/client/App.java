package com.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.JSONArray;

import java.io.IOException;

public class App extends Application {

    public static Stage stage;

    private static Scene scene2;

    public static MainSceneController controller;

    private static String username;
    public static String enemy;

    public static JSONArray enemyShips;
    public static boolean second = false;
    public static int redCnt = 0;
    public static int enemyCnt = 0;


    @Override
    public void start(Stage stage) throws Exception {
        startGame(stage);
    }

    public static void setScene(int id) {
        if (id == 2)
            stage.setScene(scene2);
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        App.username = username;
    }

    public static void main(String[] args) {
        launch(args);
    }

    void startGame(Stage stage) throws IOException {
        App.stage = stage;
        stage.setTitle("Sea battle");

//      user's form scene
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/templates/userForm.fxml"));
        Scene scene1 = new Scene(loader1.load());
        stage.setScene(scene1);

//      main scene
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/templates/mainScene.fxml"));
        Parent root = loader2.load();
        scene2 = new Scene(root);
        controller = loader2.getController();

        controller.restartButton.setOnAction(__ -> {
            try {
                restart(stage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        stage.show();
    }

    void restart(Stage stage) throws IOException {
        Delete.deleteMsg();
//        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/templates/userForm.fxml"));
//        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/templates/mainScene.fxml"));

//        scene1 = new Scene(loader1.load());
//        scene2 = new Scene(loader2.load());
        stage.close();
//        stage.setScene(scene1);
        startGame(stage);

    }




}
