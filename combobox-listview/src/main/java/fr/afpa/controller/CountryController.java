package fr.afpa.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import fr.afpa.model.Country;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class CountryController {

    @FXML
    private TextField countryNameTextField;

    @FXML
    private TextField countryCodeTextField;

    @FXML
    private ComboBox<Country> comboBoxCountries;

    @FXML
    private ListView listViewCountries;

    @FXML
    private ObservableList<Country> observableArrayList;

    @FXML
    public void initialize() {
        ObservableList<Country> countries = FXCollections.observableArrayList(getCountriesList());
        comboBoxCountries.setItems(countries);
        listViewCountries.setItems(countries);

        comboBoxCountries.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                countryNameTextField.setText(newValue.getName());
                countryCodeTextField.setText(newValue.getCode());
            }
        });
    }

    private List<Country> getCountriesList() {
        List<Country> countries = new ArrayList<>();
        String[] countryCodes = Locale.getISOCountries();
        for (String countryCode : countryCodes) {
            Locale obj = new Locale("", countryCode);
            countries.add(new Country(obj.getDisplayCountry(), obj.getISO3Country()));
        }
        return countries;
    }

}
