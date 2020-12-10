package com.client;

import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class WaitForMove extends Service<Boolean> {

    private static Rectangle[][] rec;

    public WaitForMove(Rectangle[][] rec) {
        WaitForMove.rec = rec;
    }

    public static boolean waitMove() throws IOException, InterruptedException {
        App.controller.waitingLabel.setVisible(true);
        App.controller.turnLabel.setVisible(false);
        App.controller.pane1.setOnMouseClicked(null);
        while (true) {
            Thread.sleep(100);
            boolean flag = false;
            long[] ans = Get.getMove();

            if (ans[2] == 10) {
                rec[(int)ans[0]][(int)ans[1]].setFill(Color.RED);
                App.controller.loseLabel.setVisible(true);
                App.controller.turnLabel.setVisible(false);
                App.controller.restartButton.setVisible(true);
                Platform.runLater(() -> App.controller.gameInfoLabel.setText("You lost. Don't cry!"));
                App.controller.pane1.setOnMouseClicked(null);
                return true;
            }

            if (ans[0] != -1) {
                if (ans[3] != MainSceneController.usernameToCode()) {
                    if (ans[2] == 0) {
                        rec[(int) ans[0]][(int) ans[1]].setFill(Color.RED);
                        Platform.runLater(() -> App.controller.gameInfoLabel.setText(App.enemy + " shot you"));
                    } else {
                        rec[(int) ans[0]][(int) ans[1]].setFill(Color.ROYALBLUE);
                        Platform.runLater(() -> App.controller.gameInfoLabel.setText(App.enemy + " missed"));
                        flag = true;
                    }
                }
            }
            if (flag)
                return false;
        }
    }



    @Override
    protected Task<Boolean> createTask() {
        return new Task<>() {
            @Override
            protected Boolean call() throws Exception {
                return waitMove();
            }
        };
    }
}
