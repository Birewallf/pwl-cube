package blackwall;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    public static byte CHOICENUMBER_FRONT = 1;
    public static byte CHOICENUMBER_UP = 2;
    public static byte CHOICENUMBER_ACTION = 0;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("app.fxml"));
        primaryStage.setTitle("CUBE");

        primaryStage.initStyle(StageStyle.UNDECORATED);
        final Delta dragDelta = new Delta(0, 0);
        root.setOnMousePressed(mouseEvent -> {
            dragDelta.setX(primaryStage.getX() - mouseEvent.getScreenX());
            dragDelta.setY(primaryStage.getY() - mouseEvent.getScreenY());
        });
        root.setOnMouseDragged(mouseEvent -> {
            primaryStage.setX(mouseEvent.getScreenX() + dragDelta.getX());
            primaryStage.setY(mouseEvent.getScreenY() + dragDelta.getY());
        });

        Scene scene = new Scene (root, primaryStage.getWidth(), primaryStage.getHeight()+50, Color.TRANSPARENT);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(App.class.getResource("style/css.css").toExternalForm());
        scene.getWindow().setOpacity(.80);

        //root.toFront();
        primaryStage.setAlwaysOnTop(true);
        primaryStage.toFront();
        primaryStage.requestFocus();

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
