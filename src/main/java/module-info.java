module com.escobar.marketplace {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.escobar.marketplace to javafx.fxml;
    opens com.escobar.marketplace.controller to javafx.fxml;
    opens com.escobar.marketplace.model to javafx.base;
    exports com.escobar.marketplace;
}