package fr.afpa.controller;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.Locale;

import fr.afpa.model.Country;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class CountryController {

    @FXML
    private ComboBox<Country> comboBoxCountries;

    @FXML
    private ListView<Country> listViewCountries;

    @FXML
    private ObservableList<Country> countries = FXCollections.observableArrayList();

    @FXML
    private Button buttonAddOne;
    @FXML
    private Button buttonAddAll;
    @FXML
    private Button buttonDeleteOne;
    @FXML
    private Button buttonDeleteAll;
    @FXML
    private Button upButton;
    @FXML
    private Button dowButton;

    private ButtonController buttonController;

    @FXML
    public void initialize() {
        String[] countryCodes = Locale.getISOCountries();
        for (String countryCode : countryCodes) {
            // https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Locale.Builder.html
            // Locale obj = new Locale("", countryCode);
            Locale obj = new Locale.Builder().setRegion(countryCode).build();
            countries.add(new Country(obj.getDisplayCountry(), obj.getISO3Country()));
        }
        comboBoxCountries.setItems(countries);
        buttonController = new ButtonController(this);

        listViewCountries.getItems().addListener((ListChangeListener<Country>) change -> updateButtonState());
        updateButtonState();
    }

    public List<Country> getCountriesList() {
        return countries;
    }

    public ComboBox<Country> getComboBoxCountries() {
        return comboBoxCountries;
    }

    public ListView<Country> getListViewCountries() {
        return listViewCountries;
    }

    public void updateButtonState() {
        boolean isListEmpty = listViewCountries.getItems().isEmpty();
        buttonDeleteOne.setDisable(isListEmpty);
        buttonDeleteAll.setDisable(isListEmpty);
    }

    @FXML
    private void handleAddOne() {
        buttonController.addSelectedCountry();
    }

    @FXML
    private void handleAddAll() {
        buttonController.addAllCountries();
    }

    @FXML
    private void handleDeleteOne() {
        buttonController.deleteSelectedCountry();
    }

    @FXML
    private void handleDeleteAll() {
        buttonController.deleteAllCountries();
    }

    @FXML
    private void handleMoveUp() {
        buttonController.moveUp();
    }

    @FXML
    private void handleMoveDown() {
        buttonController.moveDown();
    }

    @FXML
    private void handleQuitApp() {
        buttonController.quitApp();
    }
}
