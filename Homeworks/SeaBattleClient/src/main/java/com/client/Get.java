package com.client;


import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.net.URL;
import java.util.*;


public class Get extends Service<JSONArray> {

    public static JSONArray temp;


    public static void getMsg() throws IOException, InterruptedException {
        boolean flag = false;
        int myId = -1;

        while (true) {
            Thread.sleep(2000);
            String url = "http://localhost:8080/game";
            URL obj = new URL(url);
            App.controller.waitingLabel1.setVisible(true);
            App.controller.info.setVisible(true);

            ObjectMapper objectMapper = new ObjectMapper();
            List<User> list = Arrays.asList(objectMapper.readValue(obj, User[].class));

            if (flag)
                break;

            for (int i = 0; i < list.size(); i++) {
                User user = list.get(i);
                if (new JSONObject(user).get("name").toString().equals(App.getUsername())) {
                    myId = i;
                }
                if (new JSONObject(user).get("name").toString().equals(App.enemy)) {
                    if (myId == -1) {
                        App.second = true;
                    }
                    App.enemy = new JSONObject(user).get("name").toString();
                    temp = (JSONArray) new JSONObject(user).get("list");
                    flag = true;
                }
            }
        }
    }

    public static long[] getMove() throws IOException {
        String gameName = Long.toString(MainSceneController.enemyToCode() + MainSceneController.usernameToCode());
        String url = String.format("http://localhost:8080/game/%s/move", (gameName));
        URL obj = new URL(url);
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(Arrays.toString(objectMapper.readValue(obj, long[].class)));
        return objectMapper.readValue(obj, long[].class);
    }


    @Override
    protected Task<JSONArray> createTask() {
        return new Task<>() {
            @Override
            protected JSONArray call() throws Exception {
                getMsg();
                return temp;
            }
        };
    }
}
