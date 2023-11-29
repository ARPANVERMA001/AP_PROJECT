package stickhero.stickhero;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;
import static javafx.application.ConditionalFeature.FXML;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root  = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("StartMenu.fxml")));

        Scene scene = new Scene(root,800,600);
        stage.setTitle("StickHero!");
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}