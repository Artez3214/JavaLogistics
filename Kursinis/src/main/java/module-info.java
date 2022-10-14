module com.example.kursinis {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires mysql.connector.java;
    requires java.sql;

    opens com.example.kursinis to javafx.fxml;
    exports com.example.kursinis;
    exports com.example.kursinis.fxControllers to javafx.fxml;
    opens com.example.kursinis.fxControllers to javafx.fxml;
}