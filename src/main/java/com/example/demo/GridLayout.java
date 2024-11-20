package com.example.demo;


import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class GridLayout {

    private final GridPane pane;

    // Input fields
    private final TextField distanceInput;
    private final TextField gasInput;
    private final TextField mileageInput;
    private final TextField numberOfDaysInput;
    private final TextField foodCostInput;
    private final TextField hotelCostInput;
    private final TextField attractionsInput;
    private final TextField tripCostOutput;

    public GridLayout() {


        pane = new GridPane();

        pane.setHgap(10); // Horizontal gap between columns
        pane.setVgap(10); // Vertical gap between rows
        pane.setAlignment(Pos.CENTER);

        // Initialize labels
        // Labels
        Label distanceLabel = new Label("Distance:");
        Label gasLabel = new Label("Gasoline Cost:");
        Label mileageLabel = new Label("Gas Mileage");
        Label numberOfDays = new Label("Number of Days:");
        Label foodCost = new Label("Food Cost");
        Label hotelCost = new Label("Hotel Cost");
        Label attractions = new Label("Attractions");
        Label tripCostLabel = new Label("Total Trip Cost");

        // Initialize input fields
        distanceInput = new TextField();
        gasInput = new TextField();
        mileageInput = new TextField();
        numberOfDaysInput = new TextField();
        foodCostInput = new TextField();
        hotelCostInput = new TextField();
        attractionsInput = new TextField();
        tripCostOutput = new TextField();
        tripCostOutput.setEditable(false);

        // initalize buttons
        // Buttons
        Button calcButton = new Button("Calculate");

        //handler buttons
        CalculateTripHandlerClass calcBtnHandler = new CalculateTripHandlerClass();


        //combos
        // comboBoxes
        ComboBox<String> unitForDistance = new ComboBox<>();
        ComboBox<String> unitForFuelCost = new ComboBox<>();
        ComboBox<String> unitForEfficiency = new ComboBox<>();


        // Set preferred width for labels
        distanceLabel.setPrefWidth(120);
        gasLabel.setPrefWidth(120);
        mileageLabel.setPrefWidth(120);
        numberOfDays.setPrefWidth(120);
        foodCost.setPrefWidth(120);
        hotelCost.setPrefWidth(120);
        attractions.setPrefWidth(120);
        tripCostLabel.setPrefWidth(120);

        // Set preferred width for input fields
        distanceInput.setPrefWidth(200);
        gasInput.setPrefWidth(200);
        mileageInput.setPrefWidth(200);
        numberOfDaysInput.setPrefWidth(200);
        foodCostInput.setPrefWidth(200);
        hotelCostInput.setPrefWidth(200);
        attractionsInput.setPrefWidth(200);

        // Set preferred width for button
        calcButton.setPrefWidth(200);

        // Set preferred width & value for dropdowns
        unitForDistance.setPrefWidth(200);
        unitForDistance.setValue("miles");
        unitForFuelCost.setValue("dollars/gallon");
        unitForEfficiency.setValue("miles/gallon");


        // adding observableLists
        // Drop Selections
        // Drop Selection Lists
        String[] speedUnits = {"miles", "kilometers"};
        ObservableList<String> speedUnitList = FXCollections.observableArrayList(speedUnits);
        unitForDistance.getItems().addAll(speedUnitList);
        String[] gasCostUnits = {"dollar/gallon", "dollars/liter"};
        ObservableList<String> gasVolumeList = FXCollections.observableArrayList(gasCostUnits);
        unitForFuelCost.getItems().addAll(gasVolumeList);
        String[] gasMileageUnits = {"miles/gallon", "kilometers/liter"};
        ObservableList<String> gasMileageList = FXCollections.observableArrayList(gasMileageUnits);
        unitForEfficiency.getItems().addAll(gasMileageList);

        // Add labels and input fields to the grid
        pane.add(distanceLabel, 0, 0);
        pane.add(distanceInput, 1, 0);
        pane.add(unitForDistance, 2, 0);


        pane.add(gasLabel, 0, 1);
        pane.add(gasInput, 1, 1);
        pane.add(unitForFuelCost, 2, 1);

        pane.add(mileageLabel, 0, 2);
        pane.add(mileageInput, 1, 2);
        pane.add(unitForEfficiency, 2, 2);

        pane.add(numberOfDays, 0, 3);
        pane.add(numberOfDaysInput, 1, 3);

        pane.add(foodCost, 0, 4);
        pane.add(foodCostInput, 1, 4);

        pane.add(hotelCost, 0, 5);
        pane.add(hotelCostInput, 1, 5);

        pane.add(attractions, 0, 6);
        pane.add(attractionsInput, 1, 6);

        pane.add(calcButton, 1, 7);


        pane.add(tripCostLabel, 0, 8);
        pane.add(tripCostOutput, 1, 8);

        // annon function for calculating trip cost
        calcButton.setOnAction((ActionEvent e) -> {

            TripCost tripCost;
            tripCostOutput.setText("");




            try {
                if(attractionsInput.getText().isEmpty()) {
                    attractionsInput.setText("0");
                };
                if(foodCostInput.getText().isEmpty()) {
                    foodCostInput.setText("0");
                };
                if(hotelCostInput.getText().isEmpty()) {
                    hotelCostInput.setText("0");
                };
                if(numberOfDaysInput.getText().isEmpty()) {
                    numberOfDaysInput.setText("0");
                };
                tripCost = new TripCost(Double.parseDouble(gasInput.getText()), Double.parseDouble(distanceInput.getText()),Double.parseDouble(mileageInput.getText()),
                        Integer.parseInt(numberOfDaysInput.getText()), Double.parseDouble(foodCostInput.getText()), Double.parseDouble(hotelCostInput.getText()),
                        Integer.parseInt(attractionsInput.getText()), unitForDistance.getValue(), unitForFuelCost.getValue(), unitForEfficiency.getValue());

                // logic for unit conversions

                //convert km/l to mpg
//                if(unitForDistance.getValue().equals("kilometers") && gasMil) {
//                    tripCost.convertMilesToKilometers();
//                }
                tripCostOutput.setText(String.valueOf(tripCost.totalCost() ));
            }
            catch(Exception e1) {
                tripCostOutput.setText("ERROR: Invalid input");
                return;
            }
        });
    }


    public GridPane getGrid() {
        return pane;
    }

}


// if not using annon function for calculating trip cost
class CalculateTripHandlerClass implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
        double tripTotal = 0.00;
        System.out.println("Calculating trip...");

        //call other methods to calc trip here

    }
}


