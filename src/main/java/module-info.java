module com.escobar.marketplace {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.escobar.marketplace to javafx.fxml;
    exports com.escobar.marketplace;
}