module com.luca.calcolatrice {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.luca.calcolatrice to javafx.fxml;
    exports com.luca.calcolatrice;
}