module stickhero.stickhero {
    requires javafx.controls;
    requires javafx.fxml;


    opens stickhero.stickhero to javafx.fxml;
    exports stickhero.stickhero;
}