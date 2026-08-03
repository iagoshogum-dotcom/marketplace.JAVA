module com.escobar.marketplace {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.media;


    opens com.escobar.marketplace to javafx.fxml;
    opens com.escobar.marketplace.controller to javafx.fxml;
    opens com.escobar.marketplace.model to javafx.base;
    exports com.escobar.marketplace;
}