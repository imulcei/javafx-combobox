package fr.afpa.controller;

import fr.afpa.model.Country;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class ButtonController {

    private final CountryController countryController;

    public ButtonController(CountryController countryController) {
        this.countryController = countryController;
    }

    // button add one
    public void addSelectedCountry() {
        ComboBox<Country> comboBox = countryController.getComboBoxCountries();
        ListView<Country> listView = countryController.getListViewCountries();

        Country selectedCountry = comboBox.getSelectionModel().getSelectedItem();
        if (selectedCountry != null && !listView.getItems().contains(selectedCountry)) {
            listView.getItems().add(selectedCountry);
        }
    }

    // button add all
    public void addAllCountries() {
        ComboBox<Country> comboBox = countryController.getComboBoxCountries();
        ListView<Country> listView = countryController.getListViewCountries();

        comboBox.getItems().forEach(country -> {
            if (!listView.getItems().contains(country)) {
                listView.getItems().add(country);
            }
        });
    }

    // button delete one
    public void deleteSelectedCountry() {
        ListView<Country> listView = countryController.getListViewCountries();

        Country selectedCountry = listView.getSelectionModel().getSelectedItem();
        if (selectedCountry != null) {
            listView.getItems().remove(selectedCountry);
        }
    }

    // button delete all
    public void deleteAllCountries() {
        ListView<Country> listView = countryController.getListViewCountries();
        listView.getItems().clear();
    }

    // button move up
    public void moveUp() {
        ListView<Country> listView = countryController.getListViewCountries();
        int selectedCountryIndex = listView.getSelectionModel().getSelectedIndex();
        if (selectedCountryIndex > 0) {
            ObservableList<Country> items = listView.getItems();
            Country selectedCountry = items.get(selectedCountryIndex);
            items.set(selectedCountryIndex, items.get(selectedCountryIndex - 1));
            items.set(selectedCountryIndex - 1, selectedCountry);
            listView.getSelectionModel().select(selectedCountryIndex - 1);
        }
    }

    // button move down
    public void moveDown() {
        ListView<Country> listView = countryController.getListViewCountries();
        ObservableList<Country> items = listView.getItems();
        int selectedCountryIndex = listView.getSelectionModel().getSelectedIndex();
        if (selectedCountryIndex < items.size() - 1 && selectedCountryIndex >= 0) {
            Country selectedCountry = items.get(selectedCountryIndex);
            items.set(selectedCountryIndex, items.get(selectedCountryIndex + 1));
            items.set(selectedCountryIndex + 1, selectedCountry);
            listView.getSelectionModel().select(selectedCountryIndex + 1);
        }
    }

    // button quit
    public void quitApp() {
        Platform.exit();
    }
}
