module fr.afpa {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires javafx.base;

    opens fr.afpa to javafx.fxml;

    exports fr.afpa;
}
