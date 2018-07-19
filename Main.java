package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    // new added comment

    Stage window;
    int row,col;
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Solve my Sudoku");
        window.getIcons().addAll(new Image("/sample/unnamed.png"));
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setStyle("-fx-background-color: #E8E8E8;");
        grid.setAlignment(Pos.CENTER);
        TextField[][] ch = new TextField[9][9];
        InitLabel(ch);
        SetOnGrid(ch);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                ch[i][j].setPromptText("");
            }
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                grid.getChildren().addAll(ch[i][j]);
            }
        }
        Button b = new Button("Solve");
        b.setStyle("-fx-font:12 arial;-fx-color: gold;");
        GridPane.setConstraints(b, 8, 10);
        grid.getChildren().addAll(b);
        b.setOnAction(e -> {
            try {
                Algo(ch);
            } catch (Exception var) {
                myfuntion(ch);
                Aboutme.about("Wrong Input");
            }
        });
        Button b2 = new Button("Clear");
        b2.setStyle("-fx-font:12 arial;-fx-color: gold;");
        b2.setOnAction(e -> {
            myfuntion(ch);
        });
        Button b3 = new Button("About");
        b3.setStyle("-fx-font:12 arial;-fx-color: gold;");
        GridPane.setConstraints(b3, 4, 10);
        b3.setOnAction(e -> {
            Aboutme.about("Aniket's Creation");
        });
        GridPane.setConstraints(b2, 0, 10);
        grid.getChildren().addAll(b2, b3);
        Scene s = new Scene(grid,550,600);
        window.setMinWidth(600);
        window.setMinHeight(500);
        window.setScene(s);
        window.show();
    }

    private void myfuntion(TextField[][] t)
    {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                t[i][j].setText("");
                Seteffects2(t);
            }
        }
    }

    private void InitLabel(TextField[][] l)
    {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                l[i][j] = new TextField();
                if(i<3&&j<3 || i<3&&j>5 ||i>5&&j<3||i>5&&j>5||i>2&&i<6&&j>2&&j<6){
                    l[i][j].setStyle("-fx-font: 23 arial;-fx-control-inner-background: #7CAFC2;-fx-fill:#282828");
                }
                else{
                    l[i][j].setStyle("-fx-font: 23 arial;-fx-control-inner-background: #F7CA88");
                }
                l[i][j].setMinSize(50,50);
                l[i][j].setPrefWidth(1);
                l[i][j].setText("");
            }
        }
    }

    private void Seteffects(TextField[][] l)
    {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(i<3&&j<3 || i<3&&j>5 ||i>5&&j<3||i>5&&j>5||i>2&&i<6&&j>2&&j<6){
                    l[i][j].setStyle("-fx-font: 23 arial;-fx-control-inner-background: gold;-fx-fill:#282828");
                }
                else{
                    l[i][j].setStyle("-fx-font: 23 arial;-fx-control-inner-background: red");
                }
            }
        }
    }

    private void Seteffects2(TextField[][] l)
    {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(i<3&&j<3 || i<3&&j>5 ||i>5&&j<3||i>5&&j>5||i>2&&i<6&&j>2&&j<6){
                    l[i][j].setStyle("-fx-font: 23 arial;-fx-control-inner-background: #7CAFC2;-fx-fill:#282828");
                }
                else{
                    l[i][j].setStyle("-fx-font: 23 arial;-fx-control-inner-background: #F7CA88");
                }
            }
        }
    }

    private void SetOnGrid(TextField[][] t){
        for(int i=1;i<=9;i++){
            for(int j=0;j<9;j++){
                GridPane.setConstraints(t[i - 1][j], j, i);
            }
        }
    }

    void Algo(TextField[][] t) throws Exception{
        int[][] grid = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                t[i][j].setText(t[i][j].getText().trim());
                if(t[i][j].getText().compareTo("-") == 0||t[i][j].getText().compareTo("") == 0||t[i][j].getText().compareTo("0") == 0){
                    grid[i][j] = 0;
                }

                else{
                    grid[i][j] = Integer.parseInt(t[i][j].getText());
                    if(grid[i][j]>9 || t[i][j].getText().length() > 1){
                        Aboutme.about("Wrong Input");
                        BestOne(t);
                    }
                }
            }
        }

        if(Controller.Algorithm(grid)){
            for(int i=0;i<9;i++){
                for(int j = 0;j<9;j++){
                    t[i][j].setText(Integer.toString(grid[i][j]));
                    Seteffects(t);
                }
            }
        }

        else{
            Aboutme.about("Error..Retry");
            BestOne(t);
        }

    }

    private void BestOne(TextField[][] t)
    {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                t[i][j].setText("");
                Seteffects2(t);
            }
        }
    }


    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
