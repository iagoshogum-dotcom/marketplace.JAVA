module com.escobar.marketplace {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.escobar.marketplace to javafx.fxml;
    exports com.escobar.marketplace;
    exports com.escobar.marketplace.controller;
    opens com.escobar.marketplace.controller to javafx.fxml;
}