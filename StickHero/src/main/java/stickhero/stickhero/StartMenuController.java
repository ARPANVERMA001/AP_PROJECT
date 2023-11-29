package stickhero.stickhero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class StartMenuController {
    public Button startButton;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    protected void startPlay(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("StartPlay.fxml")));

        scene = new Scene(root);
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

        stage.setWidth(800);
        stage.setHeight(600);
        stage.setResizable(false);
        stage.setScene(scene);

        stage.show();
    }
}