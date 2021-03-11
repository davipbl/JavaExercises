import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Currency extends Application {

    public void start (Stage stage) {
        Button convertButton = new Button();
        convertButton.setText("Convert");

        TextField userInput = new TextField();
        Label inputValue = new Label("Input value: ");
        Label result = new Label();

        convertButton.setOnAction(event -> {
            String dolarValue = userInput.getCharacters().toString();
            try {
                double value = Double.parseDouble(dolarValue);
                double conversionResult = convert(value);
                result.setText(String.format("%.2f", conversionResult));
            } catch (NumberFormatException e) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Error");
                a.setHeaderText("Invalid input");
                a.setContentText("That is not a valid value.");
                a.showAndWait();
            }
        });

    HBox input = new HBox();
    input.setAlignment(Pos.CENTER);
    input.getChildren().addAll(inputValue, userInput);

    VBox root = new VBox();
    root.setAlignment(Pos.CENTER);
    root.setSpacing(10);
    root.getChildren().addAll(input, convertButton, result);

    Scene scene = new Scene(root, 400, 400);
    stage.setTitle("Currency Converter");
    stage.setScene(scene);
    stage.show();
    }

    private double convert(double value) {
        double converted = 0;
        converted = value * 0.72;
        return converted;
    }
}