package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    public TextField length_meters_field;
    public TextField length_kilometers_field;
    public TextField lengthCentimetersField;
    public TextField length_miles_field;
    public TextField length_inches_field;
    public Button convert_button_length;

    public TextField mass_grams_field;
    public TextField mass_kilograms_field;
    public TextField mass_pounds_field;
    public TextField mass_oz_field;
    public TextField mass_tones_field;
    public Button convert_button_mass;

    public TextField temp_celsius_field;
    public TextField temp_fahr_field;
    public TextField temp_kelvin_field;
    public Button convert_button_temp;

    public TextField volume_cubmetres_field;
    public TextField volume_cubdecim_field;
    public TextField volume_cubcentim_field;
    public TextField volume_litres_field;
    public TextField volume_millil_field;
    public Button convert_button_vol;

    public TextField square_metres_field;
    public TextField square_dm_field;
    public TextField square_cm_field;
    public TextField square_km_field;
    public TextField square_hect_field;
    public Button convert_button_square;


    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void lengthConvert() {
        if (!length_meters_field.getText().equals("")) {
            double meters = Double.parseDouble(length_meters_field.getText());

            double kilometers = meters / 1000;
            length_kilometers_field.setText(String.valueOf(kilometers));

            double centimeters = meters * 100;
            lengthCentimetersField.setText(String.valueOf(centimeters));

            double miles = meters / 1609.34;
            length_miles_field.setText(String.valueOf(miles));

            double inches = meters * 3.281;
            length_inches_field.setText(String.valueOf(inches));

        }
        if (!lengthCentimetersField.getText().equals("")) {
            double centimeters = Double.parseDouble(lengthCentimetersField.getText());

            double kilometers = centimeters / 100000;
            length_kilometers_field.setText(String.valueOf(kilometers));

            double meters = centimeters / 100;
            length_meters_field.setText(String.valueOf(meters));

            double miles = centimeters / 160934.4869046;
            length_miles_field.setText(String.valueOf(miles));

            double inches = centimeters / 30.480016459204545498;
            length_inches_field.setText(String.valueOf(inches));

        }
        if (!length_kilometers_field.getText().equals("")) {
            double kilometers = Double.parseDouble(length_kilometers_field.getText());

            double meters = kilometers * 1000;
            length_meters_field.setText(String.valueOf(meters));

            double centimeters = kilometers * 100000;
            lengthCentimetersField.setText(String.valueOf(centimeters));

            double miles = kilometers / 1.609;
            length_miles_field.setText(String.valueOf(miles));

            double inches = kilometers * 3281;
            length_inches_field.setText(String.valueOf(inches));
        }

        if (!length_miles_field.getText().equals("")) {
            double miles = Double.parseDouble(length_miles_field.getText());

            double meters = miles * 1609;
            length_meters_field.setText(String.valueOf(meters));

            double centimeters = miles * 160934;
            lengthCentimetersField.setText(String.valueOf(centimeters));

            double kilometers = miles * 1.609;
            length_kilometers_field.setText(String.valueOf(kilometers));

            double inches = miles * 5280;
            length_inches_field.setText(String.valueOf(inches));


        }
        if (!length_inches_field.getText().equals("")) {
            double inches = Double.parseDouble(length_inches_field.getText());

            double meters = inches / 3.281;
            length_meters_field.setText(String.valueOf(meters));

            double centimeters = inches * 30.48;
            lengthCentimetersField.setText(String.valueOf(centimeters));

            double kilometers = inches / 3281;
            length_kilometers_field.setText(String.valueOf(kilometers));

            double miles = inches / 5280;
            length_miles_field.setText(String.valueOf(miles));

        }
//todo Reset button to clear all data after calculations

    }

    public void massConvert(ActionEvent actionEvent) {
    }

    public void tempConvert(ActionEvent actionEvent) {
    }

    public void volConvert(ActionEvent actionEvent) {
    }

    public void squareConvert(Event event) {
    }
}
