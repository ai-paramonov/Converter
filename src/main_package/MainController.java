package main_package;

import imports.NegativeNumberTextField;
import imports.NumberTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.rmi.UnexpectedException;
import java.util.ResourceBundle;

public class MainController implements Initializable {


    public Button convertButtonLength;
    public Button convertMassButton;
    public Button convertTempButton;
    public Button convertSquareButton;
    public Button convertVolumeButton;

    public NumberTextField lengthInputField;
    public NumberTextField massInputField;
    public NegativeNumberTextField tempInputField;
    public NumberTextField squareInputField;
    public NumberTextField volumeInputField;


    @FXML
    public ComboBox<String> lengthFromCB;
    @FXML
    public ComboBox<String> lengthToCB;
    @FXML
    public ComboBox<String> massFromCB;
    @FXML
    public ComboBox<String> massToCB;
    @FXML
    public ComboBox<String> tempFromCB;
    @FXML
    public ComboBox<String> tempToCB;
    @FXML
    public ComboBox<String> squareFromCB;
    @FXML
    public ComboBox<String> squareToCB;
    @FXML
    public ComboBox<String> volumeFromCB;
    @FXML
    public ComboBox<String> volumeToCB;


    private void showResult(String conversation) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result window");
        alert.setHeaderText("Results: ");
        alert.setContentText(conversation);

        alert.showAndWait();
    }


    public void initialize(URL url, ResourceBundle resourceBundle) {
        lengthInputField.setText("1");
        lengthFromCB.setItems(lengthValues);
        lengthFromCB.setValue(lengthValues.get(1));
        lengthToCB.setItems(lengthValues);
        lengthToCB.setValue(lengthValues.get(2));

        convertButtonLength.setOnAction(event -> showResult(lengthConvert()));

        massInputField.setText("1");
        massFromCB.setItems(massValues);
        massFromCB.setValue(massValues.get(0));
        massToCB.setItems(massValues);
        massToCB.setValue(massValues.get(1));
        convertMassButton.setOnAction(event -> showResult(massConvert()));

        tempInputField.setText("1");
        tempFromCB.setItems(tempValues);
        tempFromCB.setValue(tempValues.get(0));
        tempToCB.setItems(tempValues);
        tempToCB.setValue(tempValues.get(1));
        convertTempButton.setOnAction(event -> showResult(tempConvert()));

        squareInputField.setText("1");
        squareFromCB.setItems(squareValues);
        squareFromCB.setValue(squareValues.get(0));
        squareToCB.setItems(squareValues);
        squareToCB.setValue(squareValues.get(1));
        convertSquareButton.setOnAction(event -> showResult(squareConvert()));

        volumeInputField.setText("1");
        volumeFromCB.setItems(volumeValues);
        volumeFromCB.setValue(volumeValues.get(0));
        volumeToCB.setItems(volumeValues);
        volumeToCB.setValue(volumeValues.get(1));
        convertVolumeButton.setOnAction(event -> showResult(volumeConvert()));
    }

    static ObservableList<String> lengthValues = FXCollections.observableArrayList(
            "Metres",
            "Kilometres",
            "Miles"

    );


    @FXML
    private String lengthConvert() {

        double result = 0;
        String valueCB1 = lengthFromCB.getValue();
        String valueCB2 = lengthToCB.getValue();

        try {
            var inputData = Double.parseDouble(lengthInputField.getText().trim().replace(",", "."));
            if (inputData < 0) {
                throw new UnexpectedException(Constants.NE_WARN);
            }

            if (valueCB1.equals(lengthValues.get(0))) {
                if (valueCB2.equals(lengthValues.get(0))) result = inputData;
                if (valueCB2.equals(lengthValues.get(1))) result = inputData * 0.001;
                if (valueCB2.equals(lengthValues.get(2))) result = inputData / 1609.34;
            }

            if (valueCB1.equals(lengthValues.get(1))) {
                if (valueCB2.equals(lengthValues.get(1))) result = inputData;
                if (valueCB2.equals(lengthValues.get(0))) result = inputData * 1000;
                if (valueCB2.equals(lengthValues.get(2))) result = inputData / 1.609;
            }

            if (valueCB1.equals(lengthValues.get(2))) {
                if (valueCB2.equals(lengthValues.get(2))) result = inputData;
                if (valueCB2.equals(lengthValues.get(0))) result = inputData * 1609;
                if (valueCB2.equals(lengthValues.get(1))) result = inputData * 1.609;
            }
            return inputData + " " + valueCB1 + " = " + result + " " + valueCB2;

        } catch (NullPointerException npe) {
            npe.printStackTrace();
            return Constants.NPE_WARN;
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            return Constants.NFE_WARN;
        } catch (UnexpectedException ne) {
            ne.printStackTrace();
            return Constants.NE_WARN;
        }


    }

    static ObservableList<String> massValues = FXCollections.observableArrayList(
            "Grams",
            "Kilograms",
            "Pounds",
            "Ounces"

    );

    @FXML
    private String massConvert() {
        double result = 0;
        String valueCB1 = massFromCB.getValue();
        String valueCB2 = massToCB.getValue();
        try {
            var inputData = Double.parseDouble(massInputField.getText().trim().replace(",", "."));
            if (inputData < 0) {
                throw new UnexpectedException(Constants.NE_WARN);
            }
            if (valueCB1.equals(massValues.get(0))) {
                if (valueCB2.equals(massValues.get(0))) result = inputData;
                if (valueCB2.equals(massValues.get(1))) result = inputData * 0.001;
                if (valueCB2.equals(massValues.get(2))) result = inputData * 0.0022;
                if (valueCB2.equals(massValues.get(3))) result = inputData * 0.035;
            }
            if (valueCB1.equals(massValues.get(1))) {
                if (valueCB2.equals(massValues.get(0))) result = inputData * 1000;
                if (valueCB2.equals(massValues.get(1))) result = inputData;
                if (valueCB2.equals(massValues.get(2))) result = inputData * 2.2;
                if (valueCB2.equals(massValues.get(3))) result = inputData * 35.2;
            }
            if (valueCB1.equals(massValues.get(2))) {
                if (valueCB2.equals(massValues.get(0))) result = inputData * 454;
                if (valueCB2.equals(massValues.get(1))) result = inputData / 2.2;
                if (valueCB2.equals(massValues.get(2))) result = inputData;
                if (valueCB2.equals(massValues.get(3))) result = inputData * 16;
            }
            if (valueCB1.equals(massValues.get(3))) {
                if (valueCB2.equals(massValues.get(0))) result = inputData * 28.35;
                if (valueCB2.equals(massValues.get(1))) result = inputData / 35.28;
                if (valueCB2.equals(massValues.get(2))) result = inputData / 16;
                if (valueCB2.equals(massValues.get(3))) result = inputData;
            }


            return inputData + " " + valueCB1 + " = " + result + " " + valueCB2;

        } catch (NullPointerException npe) {
            npe.printStackTrace();
            return Constants.NPE_WARN;
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            return Constants.NFE_WARN;
        } catch (UnexpectedException ne) {
            ne.printStackTrace();
            return Constants.NE_WARN;
        }
    }

    static ObservableList<String> tempValues = FXCollections.observableArrayList(
            "° C",
            "° F",
            "K"

    );

    @FXML
    private String tempConvert() {
        double result = 0;
        String valueCB1 = tempFromCB.getValue();
        String valueCB2 = tempToCB.getValue();
        try {
            var inputData = Double.parseDouble(tempInputField.getText().trim().replace(",", "."));

            if (valueCB1.equals(tempValues.get(0))) {
                if (valueCB2.equals(tempValues.get(0))) result = inputData;
                if (valueCB2.equals(tempValues.get(1))) result = (inputData * 9 / 5) + 32;
                if (valueCB2.equals(tempValues.get(2))) result = inputData + 273.15;
            }
            if (valueCB1.equals(tempValues.get(1))) {
                if (valueCB2.equals(tempValues.get(0))) result = (inputData - 32) * 5 / 9;
                if (valueCB2.equals(tempValues.get(1))) result = inputData;
                if (valueCB2.equals(tempValues.get(2))) result = (inputData - 32) * 5 / 9 + 273.15;
            }
            if (valueCB1.equals(tempValues.get(2))) {
                if (valueCB2.equals(tempValues.get(0))) result = inputData - 273.15;
                if (valueCB2.equals(tempValues.get(1))) result = (inputData - 273.15) * 9 / 6 + 32;
                if (valueCB2.equals(tempValues.get(2))) result = inputData;
            }

            return inputData + " " + valueCB1 + " = " + result + " " + valueCB2;

        } catch (NullPointerException npe) {
            npe.printStackTrace();
            return Constants.NPE_WARN;
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            return Constants.NFE_WARN;

        }
    }

    static ObservableList<String> squareValues = FXCollections.observableArrayList(
            "m²",
            "ft²",
            "inch²",
            "ha"

    );

    public String squareConvert() {
        double result = 0;
        String valueCB1 = squareFromCB.getValue();
        String valueCB2 = squareToCB.getValue();
        try {
            var inputData = Double.parseDouble(squareInputField.getText().trim().replace(",", "."));
            if (inputData < 0) {
                throw new UnexpectedException(Constants.NE_WARN);
            }
            if (valueCB1.equals(squareValues.get(0))) {
                if (valueCB2.equals(squareValues.get(0))) result = inputData;
                if (valueCB2.equals(squareValues.get(1))) result = inputData * 10.764;
                if (valueCB2.equals(squareValues.get(2))) result = inputData * 1550;
                if (valueCB2.equals(squareValues.get(3))) result = inputData / 10000;
            }
            if (valueCB1.equals(squareValues.get(1))) {
                if (valueCB2.equals(squareValues.get(0))) result = inputData / 10.764;
                if (valueCB2.equals(squareValues.get(1))) result = inputData;
                if (valueCB2.equals(squareValues.get(2))) result = inputData * 144;
                if (valueCB2.equals(squareValues.get(3))) result = inputData / 107639;
            }
            if (valueCB1.equals(squareValues.get(2))) {
                if (valueCB2.equals(squareValues.get(0))) result = inputData / 1550;
                if (valueCB2.equals(squareValues.get(1))) result = inputData / 144;
                if (valueCB2.equals(squareValues.get(2))) result = inputData;
                if (valueCB2.equals(squareValues.get(3))) result = inputData / 1.55e+7;
            }
            if (valueCB1.equals(squareValues.get(3))) {
                if (valueCB2.equals(squareValues.get(0))) result = inputData * 10000;
                if (valueCB2.equals(squareValues.get(1))) result = inputData * 107639;
                if (valueCB2.equals(squareValues.get(2))) result = inputData * 1.55e+7;
                if (valueCB2.equals(squareValues.get(3))) result = inputData;
            }


            return inputData + " " + valueCB1 + " = " + result + " " + valueCB2;

        } catch (NullPointerException npe) {
            npe.printStackTrace();
            return Constants.NPE_WARN;
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            return Constants.NFE_WARN;
        } catch (UnexpectedException ne) {
            ne.printStackTrace();
            return Constants.NE_WARN;
        }
    }

    static ObservableList<String> volumeValues = FXCollections.observableArrayList(
            "м³",
            "Litres",
            "U.S Gallon",
            "U.S Barrel"

    );


    @FXML
    private String volumeConvert() {
        double result = 0;
        String valueCB1 = volumeFromCB.getValue();
        String valueCB2 = volumeToCB.getValue();
        try {
            var inputData = Double.parseDouble(volumeInputField.getText().trim().replace(",", "."));
            if (inputData < 0) {
                throw new UnexpectedException(Constants.NE_WARN);
            }
            if (valueCB1.equals(volumeValues.get(0))) {
                if (valueCB2.equals(volumeValues.get(0))) result = inputData;
                if (valueCB2.equals(volumeValues.get(1))) result = inputData * 1000;
                if (valueCB2.equals(volumeValues.get(2))) result = inputData * 264;
                if (valueCB2.equals(volumeValues.get(3))) result = inputData * 6.29;
            }
            if (valueCB1.equals(volumeValues.get(1))) {
                if (valueCB2.equals(volumeValues.get(0))) result = inputData / 1000;
                if (valueCB2.equals(volumeValues.get(1))) result = inputData;
                if (valueCB2.equals(volumeValues.get(2))) result = inputData / 3.785;
                if (valueCB2.equals(volumeValues.get(3))) result = inputData / 159;
            }
            if (valueCB1.equals(volumeValues.get(2))) {
                if (valueCB2.equals(volumeValues.get(0))) result = inputData / 264;
                if (valueCB2.equals(volumeValues.get(1))) result = inputData * 3.785;
                if (valueCB2.equals(volumeValues.get(2))) result = inputData;
                if (valueCB2.equals(volumeValues.get(3))) result = inputData / 42;
            }
            if (valueCB1.equals(volumeValues.get(3))) {
                if (valueCB2.equals(volumeValues.get(0))) result = inputData / 6.29;
                if (valueCB2.equals(volumeValues.get(1))) result = inputData * 159;
                if (valueCB2.equals(volumeValues.get(2))) result = inputData * 42;
                if (valueCB2.equals(volumeValues.get(3))) result = inputData;
            }


            return inputData + " " + valueCB1 + " = " + result + " " + valueCB2;

        } catch (NullPointerException npe) {
            npe.printStackTrace();
            return Constants.NPE_WARN;
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            return Constants.NPE_WARN;
        } catch (UnexpectedException ne) {
            ne.printStackTrace();
            return Constants.NE_WARN;
        }
    }
}
