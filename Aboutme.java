package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Aboutme {

    public static void about(String s2)
    {
        Stage win = new Stage();
        win.setTitle("About");
        win.getIcons().addAll(new Image("/sample/unnamed.png"));
        win.initModality(Modality.APPLICATION_MODAL);
        Label s = new Label(s2);
        s.setStyle("-fx-font:20 arial;");
        StackPane p = new StackPane();
        p.setStyle("-fx-background-color: #E8E8E8;");
        p.getChildren().addAll(s);
        p.setAlignment(Pos.CENTER);
        Scene s1 = new Scene(p,300,110);
        win.setMaxHeight(110);
        win.setMaxWidth(300);
        win.setScene(s1);
        win.show();
    }
}
