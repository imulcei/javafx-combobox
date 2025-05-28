package fr.afpa.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

import fr.afpa.model.Country;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class CountryController {

    @FXML
    private ComboBox<Country> comboBoxCountries;

    @FXML
    private ListView listViewCountries;

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
        countries.add(new Country("Belgique", "BEL"));
        countries.add(new Country("France", "FRA"));
        countries.add(new Country("Pérou", "PER"));
        countries.add(new Country("Canada", "CAN"));
        countries.add(new Country("Laos", "LAO"));
        countries.add(new Country("Japon", "JPN"));
        countries.add(new Country("Moldavie", "MDA"));
        comboBoxCountries.setItems(countries);
        buttonController = new ButtonController(this);
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
