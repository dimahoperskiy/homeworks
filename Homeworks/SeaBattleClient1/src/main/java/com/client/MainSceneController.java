package com.client;


import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.json.JSONArray;

import java.io.IOException;
import java.util.ArrayList;

public class MainSceneController {
    public Pane pane;
    public Pane pane1;
    public Pane showPane;

    public HBox hbox1;

    public Button sendButton;
    public Button restartButton;

    public Label usernameLabel;
    public Label waitingLabel;
    public Label winLabel;
    public Label loseLabel;
    public Label enemyLabel;
    public Label enemyBoardLAbel;
    public Label ship4Info;
    public Label ship3Info;
    public Label ship2Info;
    public Label ship1Info;
    public Label waitingLabel1;
    public Label turnLabel;
    public Label pickLabel;
    public Label gameInfoLabel;

    final int width = 30;
    final int n = 10;

//    user's board
    public Rectangle[][] rec = new Rectangle [n][n];
//    enemy's board
    public Rectangle[][] rec1 = new Rectangle [n][n];

//    ship examples
    public Rectangle[] ship4 = new Rectangle[4];
    public Rectangle[] ship3one = new Rectangle[3];
    public Rectangle[] ship3two = new Rectangle[3];
    public Rectangle[] ship2one = new Rectangle[2];
    public Rectangle[] ship2two = new Rectangle[2];
    public Rectangle[] ship2three = new Rectangle[2];
    public Rectangle ship1one = new Rectangle();
    public Rectangle ship1two = new Rectangle();
    public Rectangle ship1three = new Rectangle();
    public Rectangle ship1four = new Rectangle();
    public VBox shipsInfo;
    public HBox info;



    public void initialize() {
        hbox1.setVisible(false);
        waitingLabel.setVisible(false);
        waitingLabel1.setVisible(false);
        winLabel.setVisible(false);
        loseLabel.setVisible(false);
        enemyLabel.setVisible(false);
        enemyBoardLAbel.setVisible(false);
        showPane.setVisible(true);
        shipsInfo.setVisible(false);
        turnLabel.setVisible(false);
        info.setVisible(false);
        restartButton.setVisible(false);


        drawBoard();
        drawShips();
    }

//    drawing user's and enemy's board
    public void drawBoard() {
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                rec[i][j] = new Rectangle();
                rec[i][j].setX(i * width);
                rec[i][j].setY(j * width);
                rec[i][j].setWidth(width);
                rec[i][j].setHeight(width);
                rec[i][j].setFill(null);
                rec[i][j].setStroke(Color.BLACK);
                rec[i][j].setId("0");
                pane.getChildren().add(rec[i][j]);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                rec1[i][j] = new Rectangle();
                rec1[i][j].setX(i * width);
                rec1[i][j].setY(j * width);
                rec1[i][j].setWidth(width);
                rec1[i][j].setHeight(width);
                rec1[i][j].setFill(null);
                rec1[i][j].setStroke(Color.BLACK);
                pane1.getChildren().add(rec1[i][j]);
            }
        }
    }

//    drawing ships which can be picked
    public void drawShips() {
        for (int i=0; i<4; i++) {
            ship4[i] = new Rectangle();
            ship4[i].setX(i * width);
            ship4[i].setWidth(width);
            ship4[i].setHeight(width);
            ship4[i].setFill(Color.YELLOW);
            ship4[i].setStroke(Color.BLACK);
            showPane.getChildren().add(ship4[i]);
        }

        for (int i=0; i<3; i++) {
            ship3one[i] = new Rectangle();
            ship3one[i].setX(i * width);
            ship3one[i].setY(width * 2);
            ship3one[i].setWidth(width);
            ship3one[i].setHeight(width);
            ship3one[i].setFill(Color.YELLOW);
            ship3one[i].setStroke(Color.BLACK);
            showPane.getChildren().add(ship3one[i]);
        }

        for (int i=0; i<3; i++) {
            ship3two[i] = new Rectangle();
            ship3two[i].setX(i * width + 4 * width);
            ship3two[i].setY(width * 2);
            ship3two[i].setWidth(width);
            ship3two[i].setHeight(width);
            ship3two[i].setFill(Color.YELLOW);
            ship3two[i].setStroke(Color.BLACK);
            showPane.getChildren().add(ship3two[i]);
        }

        for (int i=0; i<2; i++) {
            ship2one[i] = new Rectangle();
            ship2one[i].setX(i * width);
            ship2one[i].setY(width * 4);
            ship2one[i].setWidth(width);
            ship2one[i].setHeight(width);
            ship2one[i].setFill(Color.YELLOW);
            ship2one[i].setStroke(Color.BLACK);
            showPane.getChildren().add(ship2one[i]);
        }


        for (int i=0; i<2; i++) {
            ship2two[i] = new Rectangle();
            ship2two[i].setX(i * width + 3 * width);
            ship2two[i].setY(width * 4);
            ship2two[i].setWidth(width);
            ship2two[i].setHeight(width);
            ship2two[i].setFill(Color.YELLOW);
            ship2two[i].setStroke(Color.BLACK);
            showPane.getChildren().add(ship2two[i]);
        }


        for (int i=0; i<2; i++) {
            ship2three[i] = new Rectangle();
            ship2three[i].setX(i * width + 6 * width);
            ship2three[i].setY(width * 4);
            ship2three[i].setWidth(width);
            ship2three[i].setHeight(width);
            ship2three[i].setFill(Color.YELLOW);
            ship2three[i].setStroke(Color.BLACK);
            showPane.getChildren().add(ship2three[i]);
        }

        ship1one = new Rectangle();
        ship1one.setY(width * 6);
        ship1one.setWidth(width);
        ship1one.setHeight(width);
        ship1one.setFill(Color.YELLOW);
        ship1one.setStroke(Color.BLACK);
        showPane.getChildren().add(ship1one);

        ship1two = new Rectangle();
        ship1two.setX(width * 2);
        ship1two.setY(width * 6);
        ship1two.setWidth(width);
        ship1two.setHeight(width);
        ship1two.setFill(Color.YELLOW);
        ship1two.setStroke(Color.BLACK);
        showPane.getChildren().add(ship1two);

        ship1three = new Rectangle();
        ship1three.setX(width * 4);
        ship1three.setY(width * 6);
        ship1three.setWidth(width);
        ship1three.setHeight(width);
        ship1three.setFill(Color.YELLOW);
        ship1three.setStroke(Color.BLACK);
        showPane.getChildren().add(ship1three);

        ship1four = new Rectangle();
        ship1four.setX(width * 6);
        ship1four.setY(width * 6);
        ship1four.setWidth(width);
        ship1four.setHeight(width);
        ship1four.setFill(Color.YELLOW);
        ship1four.setStroke(Color.BLACK);
        showPane.getChildren().add(ship1four);
    }

//  picking ships on user's board
    public void pickShip(MouseEvent mouseEvent) {
        double posX = mouseEvent.getX();
        double posY = mouseEvent.getY();

        int colX = (int) posX / width;
        int colY = (int) posY / width;

        //        not letting fill diagonals
        if (colX == 0 & colY == 0) {
            if (rec[colX+1][colY+1].getFill() != Color.BLUE) {
                fillShip(colX, colY);
            }
        } else if (colX == n-1 & colY == n-1) {
            if (rec[colX-1][colY-1].getFill() != Color.BLUE) {
                fillShip(colX, colY);
            }
        } else if (colX == 0 & colY == n-1) {
            if (rec[colX+1][colY-1].getFill() != Color.BLUE) {
                fillShip(colX, colY);
            }
        } else if (colX == n-1 & colY == 0) {
            if (rec[colX-1][colY+1].getFill() != Color.BLUE) {
                fillShip(colX, colY);
            }
        } else if (colX == 0) {
            if (rec[colX+1][colY-1].getFill() != Color.BLUE & rec[colX+1][colY+1].getFill() != Color.BLUE) {
                fillShip(colX, colY);
            }
        } else if (colY == 0) {
            if (rec[colX+1][colY+1].getFill() != Color.BLUE & rec[colX-1][colY+1].getFill() != Color.BLUE) {
                fillShip(colX, colY);
            }
        } else if (colX == n-1) {
            if (rec[colX - 1][colY - 1].getFill() != Color.BLUE & rec[colX - 1][colY + 1].getFill() != Color.BLUE) {
                fillShip(colX, colY);
            }
        } else if (colY == n-1) {
            if (rec[colX + 1][colY - 1].getFill() != Color.BLUE & rec[colX - 1][colY - 1].getFill() != Color.BLUE) {
                fillShip(colX, colY);
            }
        } else {
            if (
                    rec[colX-1][colY-1].getFill() != Color.BLUE &
                    rec[colX+1][colY-1].getFill() != Color.BLUE &
                    rec[colX-1][colY+1].getFill() != Color.BLUE &
                    rec[colX+1][colY+1].getFill() != Color.BLUE
            ) {
                fillShip(colX, colY);
            }
        }
    }

//  guessing enemy's ships
    public void pickEnemyShip(MouseEvent mouseEvent) {
        try {
            double posX = mouseEvent.getX();
            double posY = mouseEvent.getY();

            int colX = (int) posX / width;
            int colY = (int) posY / width;
            boolean redFlag = false;

            if (rec1[colX][colY].getFill() != Color.RED & rec1[colX][colY].getFill() != Color.ROYALBLUE) {
                if (rec1[colX][colY].getId() != null) {
                    rec1[colX][colY].setFill(Color.RED);
                    gameInfoLabel.setText("You shot " + App.enemy);
                    redFlag = true;
                    App.redCnt ++;
                    long [] move = {colX, colY, 0, usernameToCode()};
                    Post.postMove(move);
                } else {
                    rec1[colX][colY].setFill(Color.ROYALBLUE);
                    gameInfoLabel.setText("You missed");
                    long [] move = {colX, colY, 1, usernameToCode()};
                    Post.postMove(move);
                }

                if (App.redCnt == App.enemyCnt) {
                    winLabel.setVisible(true);
                    App.controller.gameInfoLabel.setText("Congratulations! You won!");
                    turnLabel.setVisible(false);
                    restartButton.setVisible(true);
                    pane1.setOnMouseClicked(null);
                    long[] end = {colX, colY, 10, usernameToCode()};
                    Post.postMove(end);
                } else if (!redFlag) {
                    WaitForMove waitForMove = new WaitForMove(rec);

                    waitForMove.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                        @Override
                        public void handle(WorkerStateEvent workerStateEvent) {
                            waitingLabel.setVisible(false);
                            if ((Boolean) workerStateEvent.getSource().getValue()) {
                                pane1.setOnMouseClicked(null);
                                turnLabel.setVisible(false);
                            } else {
                                pane1.setOnMouseClicked(MainSceneController.this::pickEnemyShip);
                                turnLabel.setVisible(true);
                            }
                        }
                    });
                    waitForMove.start();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//  confirming our ships' positions and sending it to server & waiting for enemy to do the same
    public void sendMap() throws IOException, InterruptedException {

        for (Rectangle rectangle: ship4) {
            rectangle.setFill(Color.YELLOW);
        }
        for (Rectangle rectangle: ship3one) {
            rectangle.setFill(Color.YELLOW);
        }
        for (Rectangle rectangle: ship3two) {
            rectangle.setFill(Color.YELLOW);
        }
        for (Rectangle rectangle: ship2one) {
            rectangle.setFill(Color.YELLOW);
        }
        for (Rectangle rectangle: ship2two) {
            rectangle.setFill(Color.YELLOW);
        }
        for (Rectangle rectangle: ship2three) {
            rectangle.setFill(Color.YELLOW);
        }
        ship1one.setFill(Color.YELLOW);
        ship1two.setFill(Color.YELLOW);
        ship1three.setFill(Color.YELLOW);
        ship1four.setFill(Color.YELLOW);

        int cnt = 0;
        int fourCnt = 0;
        int threeCnt = 0;
        int twoCnt = 0;
        int oneCnt = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (Integer.parseInt(rec[i][j].getId()) == 4)
                    fourCnt++;
                else if (Integer.parseInt(rec[i][j].getId()) == 3)
                    threeCnt++;
                else if (Integer.parseInt(rec[i][j].getId()) == 2)
                    twoCnt++;
                else if (Integer.parseInt(rec[i][j].getId()) == 1)
                    oneCnt++;
                cnt += Integer.parseInt(rec[i][j].getId());
            }
        }
        fourCnt /= 4;
        threeCnt /= 3;
        twoCnt /=2;

        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;

        if (fourCnt > 1) {
            for (Rectangle r: ship4) {
                r.setFill(null);
            }
            ship4Info.setText("4-ship: " + (fourCnt - 1) + " extra 4-ship");
        } else if (fourCnt < 1) {
            ship4Info.setText("4-ship: You need to put one 4-ship");
        } else {
            for (Rectangle r: ship4) {
                r.setFill(null);
            }
            ship4Info.setText("4-ship: OK");
            flag4 = true;
        }
        if (threeCnt > 2) {
            for (Rectangle r: ship3two) {
                r.setFill(null);
            }
            for (Rectangle r: ship3one) {
                r.setFill(null);
            }
            ship3Info.setText("3-ship: " + (threeCnt - 2) + " extra 3-ship");
        } else if (threeCnt == 1) {
            for (Rectangle r: ship3two) {
                r.setFill(null);
            }
            ship3Info.setText("3-ship: You need to put one more 3-ship");
        } else if (threeCnt == 0) {
            ship3Info.setText("3-ship: You need to put two 3-ship");
        } else {
            for (Rectangle r: ship3two) {
                r.setFill(null);
            }
            for (Rectangle r: ship3one) {
                r.setFill(null);
            }
            ship3Info.setText("3-ship: OK");
            flag3 = true;
        }
        if (twoCnt > 3) {
            for (Rectangle r: ship2one) {
                r.setFill(null);
            }
            for (Rectangle r: ship2two) {
                r.setFill(null);
            }
            for (Rectangle r: ship2three) {
                r.setFill(null);
            }
            ship2Info.setText("2-ship: " + (twoCnt - 3) + " extra 2-ship");
        } else if (twoCnt == 2) {
            for (Rectangle r: ship2two) {
                r.setFill(null);
            }
            for (Rectangle r: ship2three) {
                r.setFill(null);
            }
            ship2Info.setText("2-ship: You need to put one more 2-ship");
        } else if (twoCnt == 1) {
            for (Rectangle r: ship2three) {
                r.setFill(null);
            }
            ship2Info.setText("2-ship: You need to put two more 2-ship");
        } else if (twoCnt == 0)
            ship2Info.setText("2-ship: You need to put three 2-ship");
        else {
            for (Rectangle r: ship2one) {
                r.setFill(null);
            }
            for (Rectangle r: ship2two) {
                r.setFill(null);
            }
            for (Rectangle r: ship2three) {
                r.setFill(null);
            }
            ship2Info.setText("2-ship: OK");
            flag2 = true;
        }
        if (oneCnt > 4) {
            ship1one.setFill(null);
            ship1two.setFill(null);
            ship1three.setFill(null);
            ship1four.setFill(null);
            ship1Info.setText("1-ship: " + (oneCnt - 4) + " extra 1-ship");
        } else if (oneCnt == 3) {
            ship1two.setFill(null);
            ship1three.setFill(null);
            ship1four.setFill(null);
            ship1Info.setText("1-ship: You need to put one more 1-ship");
        } else if (oneCnt == 2) {
            ship1three.setFill(null);
            ship1four.setFill(null);
            ship1Info.setText("1-ship: You need to put two more 1-ship");
        } else if (oneCnt == 1) {
            ship1four.setFill(null);
            ship1Info.setText("1-ship: You need to put three more 1-ship");
        } else if (oneCnt == 0)
            ship1Info.setText("1-ship: You need to put four 1-ship");
        else {
            ship1one.setFill(null);
            ship1two.setFill(null);
            ship1three.setFill(null);
            ship1four.setFill(null);
            ship1Info.setText("1-ship: OK");
            flag1 = true;
        }

        shipsInfo.setVisible(true);

        if (flag1 & flag2 & flag3 & flag4) {
            shipsInfo.setVisible(false);
            pickLabel.setVisible(false);
            ArrayList<int []> ships = new ArrayList<>();
            for(int i=0; i<n; i++) {
                for (int j = 0; j < n; j++) {
                    int[] temp = {i, j};
                    if (rec[i][j].getFill() == Color.BLUE)
                        ships.add(temp);
                }
            }

            pane.setOnMouseClicked(null);

            Post.postMsg(App.getUsername(), ships);

            Get get = new Get();
            get.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent workerStateEvent) {
                    App.enemyShips = (JSONArray) workerStateEvent.getSource().getValue();
                    enemyLabel.setText("Enemy: " + App.enemy);
                    enemyLabel.setVisible(true);
                    waitingLabel.setVisible(false);
                    waitingLabel1.setVisible(false);
                    pane1.setOnMouseClicked(MainSceneController.this::pickEnemyShip);

                    if (App.second) {
                        WaitForMove waitForMove = new WaitForMove(rec);
                        turnLabel.setVisible(false);

                        waitForMove.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                            @Override
                            public void handle(WorkerStateEvent workerStateEvent) {
                                waitingLabel.setVisible(false);
                                turnLabel.setVisible(true);
                                pane1.setOnMouseClicked(MainSceneController.this::pickEnemyShip);
                            }
                        });
                        waitForMove.start();
                    } else
                        turnLabel.setVisible(true);
                    try {
                        showEnemies();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });
            get.start();

            hbox1.setVisible(true);
            showPane.setVisible(false);
            enemyBoardLAbel.setVisible(true);
            sendButton.setVisible(false);
        }
    }

//  mapping ships on enemy's board as "ship" after receiving enemy's board
    public void showEnemies() throws IOException {
        JSONArray temp = App.enemyShips;
        for (int i = 0; i < temp.length(); i++) {
            JSONArray tempLi = temp.getJSONArray(i);
            rec1[tempLi.getInt(0)][tempLi.getInt(1)].setId("ship");
            App.enemyCnt ++;
        }


    }

//  converting username to char code
    public static long usernameToCode() {
        StringBuilder ans = new StringBuilder();
        for (int i: App.getUsername().getBytes()) {
            ans.append(i);
        }
        String ansSt = ans.toString();
        return Long.parseLong(ansSt);
    }

//  filling ship
    public void fillShip(int colX, int colY) {
        boolean flag = false;
//      finding horizontal size
        int leftSize = 0;
        while (true) {
            if (colX-(leftSize + 1) != -1) {
                if (rec[colX-(leftSize + 1)][colY].getFill() == Color.BLUE)
                    leftSize ++;
                else break;
            } else break;
        }
        int rightSize = 0;
        while (true) {
            if (colX+(rightSize + 1) != 10) {
                if (rec[colX+(rightSize + 1)][colY].getFill() == Color.BLUE)
                    rightSize ++;
                else break;
            } else break;
        }
        int horizontalSize = leftSize + rightSize + 1;
        leftSize = 0;
        rightSize = 0;

//      finding vertical size
        int topSize = 0;
        while (true) {
            if (colY-(topSize + 1) != -1) {
                if (rec[colX][colY-(topSize + 1)].getFill() == Color.BLUE)
                    topSize ++;
                else break;
            } else break;
        }
        int bottomSize = 0;
        while (true) {
            if (colY+(bottomSize + 1) != 10) {
                if (rec[colX][colY+(bottomSize + 1)].getFill() == Color.BLUE)
                    bottomSize ++;
                else break;
            } else break;
        }
        int verticalSize = topSize + bottomSize + 1;
        topSize = 0;
        bottomSize = 0;




        if (horizontalSize < 5 & verticalSize < 5) {
            if (horizontalSize > verticalSize) {
//          neighbors on left
                while (true) {
                    if ((colX-(leftSize + 1)) != -1) {
                        if (rec[colX-(leftSize + 1)][colY].getFill() == Color.BLUE) {
                            if (rec[colX][colY].getFill() == Color.BLUE) {
                                rec[colX-(leftSize + 1)][colY].setId("0");
                                rec[colX-(leftSize + 1)][colY].setFill(null);
                            } else
                                rec[colX-(leftSize + 1)][colY].setId(Integer.toString(horizontalSize));
                            leftSize++;
                        } else break;
                    } else break;
                }
//          neighbors on right
                while (true) {
                    if (colX+(rightSize + 1) != 10) {
                        if (rec[colX+(rightSize + 1)][colY].getFill() == Color.BLUE) {
                            if (rec[colX][colY].getFill() == Color.BLUE) {
                                rec[colX+(rightSize + 1)][colY].setId("0");
                                rec[colX+(rightSize + 1)][colY].setFill(null);
                            } else
                                rec[colX + (rightSize + 1)][colY].setId(Integer.toString(horizontalSize));
                            rightSize++;
                        } else break;
                    } else break;
                }
//          itself
                if (rec[colX][colY].getFill() == Color.BLUE) {
                    rec[colX][colY].setId("0");
                    rec[colX][colY].setFill(null);
                    flag = true;

//
                } else
                    rec[colX][colY].setId(Integer.toString(horizontalSize));
            } else {
//          neighbors on top
                while (true) {
                    if (colY-(topSize + 1) != -1) {
                        if (rec[colX][colY-(topSize + 1)].getFill() == Color.BLUE) {
                            if (rec[colX][colY].getFill() == Color.BLUE) {
                                rec[colX][colY-(topSize + 1)].setId("0");
                                rec[colX][colY-(topSize + 1)].setFill(null);
                            } else
                                rec[colX][colY - (topSize + 1)].setId(Integer.toString(verticalSize));
                            topSize++;
                        } else break;
                    } else break;
                }
//          neighbors on bottom
                while (true) {
                    if (colY+(bottomSize + 1) != 10) {
                        if (rec[colX][colY+(bottomSize + 1)].getFill() == Color.BLUE) {
                            if (rec[colX][colY].getFill() == Color.BLUE) {
                                rec[colX][colY+(bottomSize + 1)].setId("0");
                                rec[colX][colY+(bottomSize + 1)].setFill(null);
                            } else
                                rec[colX][colY + (bottomSize + 1)].setId(Integer.toString(verticalSize));
                            bottomSize++;
                        } else break;
                    } else break;
                }
//          itself
                if (rec[colX][colY].getFill() == Color.BLUE) {
                    rec[colX][colY].setId("0");
                    rec[colX][colY].setFill(null);
                    flag = true;
                } else
                    rec[colX][colY].setId(Integer.toString(verticalSize));
            }

            if (rec[colX][colY].getFill() == Color.BLUE | flag)
                rec[colX][colY].setFill(null);
            else
                rec[colX][colY].setFill(Color.BLUE);
        }
    }

}
