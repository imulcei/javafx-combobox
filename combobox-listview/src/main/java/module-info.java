module fr.afpa {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires javafx.base;

    opens fr.afpa to javafx.fxml;
    opens fr.afpa.controller to javafx.fxml;

    exports fr.afpa;
}
