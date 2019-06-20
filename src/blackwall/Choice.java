package blackwall;

import javafx.fxml.FXML;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Choice {
    @FXML
    ImageView id_1;
    @FXML
    ImageView id_2;
    @FXML
    ImageView id_3;
    @FXML
    ImageView id_4;
    @FXML
    ImageView id_5;
    @FXML
    ImageView id_6;

    private byte SIDE = 0;

    public Choice(byte side){
        this.SIDE = side;
    }

    @FXML
    public void initialize() {
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setContrast(0.1);
        colorAdjust.setHue(-0.3);//(-0.05);
        colorAdjust.setBrightness(0.1);
        colorAdjust.setSaturation(0.2);


        id_1.setOnMouseClicked(event -> {
            id_1.setEffect(colorAdjust);
            if (this.SIDE == 0)
                Main.CHOICENUMBER_FRONT = 1;
            else Main.CHOICENUMBER_UP = 1;
            Stage stage = (Stage) id_1.getScene().getWindow();
            stage.close();
        });
        id_2.setOnMouseClicked(event -> {
            id_2.setEffect(colorAdjust);
            if (this.SIDE == 0)
                Main.CHOICENUMBER_FRONT = 2;
            else Main.CHOICENUMBER_UP = 2;
            Stage stage = (Stage) id_1.getScene().getWindow();
            stage.close();
        });
        id_3.setOnMouseClicked(event -> {
            id_3.setEffect(colorAdjust);
            if (this.SIDE == 0)
                Main.CHOICENUMBER_FRONT = 3;
            else Main.CHOICENUMBER_UP = 3;
            Stage stage = (Stage) id_1.getScene().getWindow();
            stage.close();
        });
        id_4.setOnMouseClicked(event -> {
            id_4.setEffect(colorAdjust);
            if (this.SIDE == 0)
                Main.CHOICENUMBER_FRONT = 4;
            else Main.CHOICENUMBER_UP = 4;
            Stage stage = (Stage) id_1.getScene().getWindow();

            stage.close();
        });
        id_5.setOnMouseClicked(event -> {
            id_5.setEffect(colorAdjust);
            if (this.SIDE == 0)
                Main.CHOICENUMBER_FRONT = 5;
            else Main.CHOICENUMBER_UP = 5;
            Stage stage = (Stage) id_1.getScene().getWindow();
            stage.close();
        });
        id_6.setOnMouseClicked(event -> {
            id_6.setEffect(colorAdjust);
            if (this.SIDE == 0)
                Main.CHOICENUMBER_FRONT = 6;
            else Main.CHOICENUMBER_UP = 6;
            Stage stage = (Stage) id_1.getScene().getWindow();
            stage.close();
        });
    }
}
