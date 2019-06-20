package blackwall;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;


public class App {
    public Cube cube;


    @FXML
    private ToggleButton exit;
    final private ToggleGroup toggleGroup = new ToggleGroup();
    @FXML
    private RadioButton radioButton_1;
    @FXML
    private RadioButton radioButton_2;
    @FXML
    ImageView imageViewFront;
    @FXML
    ImageView imageViewUp;
    @FXML
    ImageView imageView_1;
    @FXML
    ImageView imageView_2;
    @FXML
    ImageView imageView_3;
    /**
     * Toggle Button Action */
    public void onActionToggle(){
        if (Main.CHOICENUMBER_ACTION == 0) return;

        imageView_1.setEffect(null);
        imageView_2.setEffect(null);
        imageView_3.setEffect(null);

        switch (Main.CHOICENUMBER_ACTION){
            case 1:
                if (radioButton_1.isSelected()) {
                    cube.upTurn(); cube.upTurn(); cube.rightTurn();
                } else {
                    cube.rightTurn(); cube.rightTurn(); cube.upTurn();
                }
                break;
            case 2:
                cube.upTurn(); cube.rightTurn(); cube.upTurn();
                break;
            case 3:
                if (radioButton_1.isSelected()) {
                    cube.rightTurn(); cube.upTurn(); cube.upTurn();
                } else  {
                    cube.upTurn(); cube.rightTurn(); cube.rightTurn();
                }
                break;
        }

        imageViewFront.setImage(new Image(Main.class.getResourceAsStream("res/cube-"+ cube.getFrontside() +".png")));
        imageViewUp.setImage(new Image(Main.class.getResourceAsStream("res/cube-"+ cube.get_s1() +".png")));

        if (radioButton_1.isSelected()) {
            onAction_1();
        } else onAction_2();

        Main.CHOICENUMBER_ACTION = 0;
    }
    /**
     * поворот ВВП*/
    public void onAction_1(){
        imageView_1.setImage(new Image(Main.class.getResourceAsStream("res/cube-"+ cube.get_s2() +".png")));
        imageView_2.setImage(new Image(Main.class.getResourceAsStream("res/cube-"+ cube.get_s5() +".png")));
        imageView_3.setImage(new Image(Main.class.getResourceAsStream("res/cube-"+ cube.get_s3() +".png")));
        setLabelText();
    }
    /**
     * поворот ПВВ*/
    public void onAction_2(){
        imageView_1.setImage(new Image(Main.class.getResourceAsStream("res/cube-"+ cube.get_s4() +".png")));
        imageView_2.setImage(new Image(Main.class.getResourceAsStream("res/cube-"+ cube.get_s5() +".png")));
        imageView_3.setImage(new Image(Main.class.getResourceAsStream("res/cube-"+ cube.get_s1() +".png")));
        setLabelText();
    }

    @FXML
    Label label_id1;
    @FXML
    Label label_id2;
    @FXML
    Label label_id3;

    private void setLabelText(){
        RadioButton radioButton = (RadioButton) toggleGroup.getSelectedToggle();
        if(Objects.equals(radioButton.getText(), "ввп")){
            label_id1.setText("ввп");
            label_id2.setText("впв");
            label_id3.setText("пвв");
        } else {
            label_id1.setText("ппв");
            label_id2.setText("пвп");
            label_id3.setText("впп");
        }
    }

    @FXML
    public void initialize() {
        cube = new Cube();



        radioButton_1.setToggleGroup(toggleGroup);
        radioButton_1.setSelected(true);
        onAction_1();
        radioButton_2.setToggleGroup(toggleGroup);



        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setContrast(0.1);
        colorAdjust.setHue(-0.3);//(-0.05);
        colorAdjust.setBrightness(0.1);
        colorAdjust.setSaturation(0.2);
        imageViewFront.setOnMouseClicked(event -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("choice.fxml"));
                fxmlLoader.setController(new Choice((byte) 0));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setAlwaysOnTop(true);
                stage.toFront();
                stage.requestFocus();

                stage.setOnHiding(e -> {
                    System.out.printf("\nCHOICENUMBER_FRONT = %d CHOICENUMBER_UP = %d", Main.CHOICENUMBER_FRONT, Main.CHOICENUMBER_UP);

                    cube.reBuild(Main.CHOICENUMBER_FRONT, cube.get_s1());
                    imageViewFront.setImage(new Image(Main.class.getResourceAsStream("res/cube-"+ cube.getFrontside() +".png")));
                    imageViewUp.setImage(new Image(Main.class.getResourceAsStream("res/cube-"+ cube.get_s1() +".png")));

                    radioButton_1.setSelected(true);
                    onAction_1();
                });

                Scene scene = new Scene(root1);
                stage.setScene(scene);
                scene.getStylesheets().add(App.class.getResource("style/css.css").toExternalForm());
                scene.getWindow().setOpacity(.85);

                Stage _stage = (Stage) imageViewFront.getScene().getWindow();
                stage.setX(_stage.getX()-60);
                stage.setY(_stage.getY()+65);

                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        imageViewUp.setOnMouseClicked(event -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("choice.fxml"));
                fxmlLoader.setController(new Choice((byte) 1));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setAlwaysOnTop(true);
                stage.toFront();
                stage.requestFocus();

                stage.setOnHiding(e -> {
                    System.out.printf("\nCHOICENUMBER_FRONT = %d CHOICENUMBER_UP = %d", Main.CHOICENUMBER_FRONT, Main.CHOICENUMBER_UP);

                    cube.reBuild(cube.getFrontside(), Main.CHOICENUMBER_UP);
                    imageViewFront.setImage(new Image(Main.class.getResourceAsStream("res/cube-"+ cube.getFrontside() +".png")));
                    imageViewUp.setImage(new Image(Main.class.getResourceAsStream("res/cube-"+ cube.get_s1() +".png")));
                    radioButton_1.setSelected(true);
                    onAction_1();
                });

                Scene scene = new Scene(root1);
                stage.setScene(scene);
                scene.getStylesheets().add(App.class.getResource("style/css.css").toExternalForm());
                scene.getWindow().setOpacity(.85);

                Stage _stage = (Stage) imageViewFront.getScene().getWindow();
                stage.setX(_stage.getX()-60);
                stage.setY(_stage.getY()+65);

                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        imageView_1.setOnMouseClicked(event -> {
            if (Main.CHOICENUMBER_ACTION == 1) {
                imageView_1.setEffect(null);
                Main.CHOICENUMBER_ACTION = 0;
            }
            else {
                imageView_1.setEffect(colorAdjust);
                imageView_2.setEffect(null);
                imageView_3.setEffect(null);
                Main.CHOICENUMBER_ACTION = 1;
            }
        });
        imageView_2.setOnMouseClicked(event -> {
            if (Main.CHOICENUMBER_ACTION == 2) {
                imageView_2.setEffect(null);
                Main.CHOICENUMBER_ACTION = 0;
            }
            else {
                imageView_2.setEffect(colorAdjust);
                imageView_1.setEffect(null);
                imageView_3.setEffect(null);
                Main.CHOICENUMBER_ACTION = 2;
            }
        });
        imageView_3.setOnMouseClicked(event -> {
            if (Main.CHOICENUMBER_ACTION == 3) {
                imageView_3.setEffect(null);
                Main.CHOICENUMBER_ACTION = 0;
            }
            else {
                imageView_3.setEffect(colorAdjust);
                imageView_1.setEffect(null);
                imageView_2.setEffect(null);
                Main.CHOICENUMBER_ACTION = 3;
            }
        });

    }

    public void onExit() {
        System.exit(0);
    }
    public void onMin() {
        Stage stage = (Stage)exit.getScene().getWindow();
        // is stage minimizable into task bar. (true | false)
        stage.setIconified(true);
    }

}
