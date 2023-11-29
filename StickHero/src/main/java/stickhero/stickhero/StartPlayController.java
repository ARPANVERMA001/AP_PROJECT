package stickhero.stickhero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class StartPlayController {

//    public
    private Stage stage;
    private Scene scene;
//    private Parent root;
    @FXML
    private ImageView saved_gameimg;

    @FXML
    private ImageView start_gameimg;


    @FXML
    void select_saved_game() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SaveMenu.fxml")));

        scene = new Scene(root,800,600);
        stage = (Stage) ((Node)saved_gameimg).getScene().getWindow();

//        stage.setWidth(800);
//        stage.setHeight(600);
//        stage.setResizable(false);
        stage.setScene(scene);

        stage.show();
    }

    @FXML
    void start_game() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("GamePlay.fxml")));

        scene = new Scene(root,800,600);
        stage = (Stage) ((Node)start_gameimg).getScene().getWindow();

//        stage.setWidth(800);
//        stage.setHeight(600);
//        stage.setResizable(false);
        stage.setScene(scene);

        stage.show();
    }
}