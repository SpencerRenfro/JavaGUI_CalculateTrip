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

    private GridPane pane;

    // Labels
    private Label distanceLabel;
    private Label gasLabel;
    private Label mileageLabel;
    private Label numberOfDays;
    private Label foodCost;
    private Label hotelCost;
    private Label attractions;
    private Label tripCostLabel;

    // Input fields
    private TextField distanceInput;
    private TextField gasInput;
    private TextField mileageInput;
    private TextField numberOfDaysInput;
    private TextField foodCostInput;
    private TextField hotelCostInput;
    private TextField attractionsInput;
    private TextField tripCostOutput;

    // Buttons
    private Button calcButton;

    // comboBoxes
    private ComboBox<String> unitOfSpeedSelect;
    private ComboBox<String> gasVolumeSelect;
    private ComboBox<String> gasMileageUnitSelect;

    // Drop Selection Lists
    private String[] speedUnits = { "miles", "kilometers" };
    private String[] gasCostUnits = { "dollar/gallon", "dollars/liter" };
    private String[] gasMileageUnits = { "miles/gallon", "kilometers/liter" };

    // Drop Selections
    private ObservableList<String> speedUnitList = FXCollections.observableArrayList(speedUnits);
    private ObservableList<String> gasVolumeList = FXCollections.observableArrayList(gasCostUnits);
    private ObservableList<String> gasMileageList = FXCollections.observableArrayList(gasMileageUnits);

    public GridLayout() {


        pane = new GridPane();

        pane.setHgap(10); // Horizontal gap between columns
        pane.setVgap(10); // Vertical gap between rows
        pane.setAlignment(Pos.CENTER);

        // Initialize labels
        distanceLabel = new Label("Distance:");
        gasLabel = new Label("Gasoline Cost:");
        mileageLabel = new Label("Gas Mileage");
        numberOfDays = new Label("Number of Days:");
        foodCost = new Label("Food Cost");
        hotelCost = new Label("Hotel Cost");
        attractions = new Label("Attractions");
        tripCostLabel = new Label("Total Trip Cost");

        // Initialize input fields
        distanceInput = new TextField();
        gasInput = new TextField();
        mileageInput = new TextField();
        numberOfDaysInput = new TextField();
        foodCostInput = new TextField();
        hotelCostInput = new TextField();
        attractionsInput = new TextField();
        tripCostOutput = new TextField("TEST OUTPUT: 2222.2");
        tripCostOutput.setEditable(false);

        // initalize buttons
        calcButton = new Button("Calculate");

        //handler buttons
        CalculateTripHandlerClass calcBtnHandler = new CalculateTripHandlerClass();
        calcButton.setOnAction(calcBtnHandler);

        // OR use annon function
        calcButton.setOnAction((ActionEvent e) -> {
            TripCost tripCost;

            try {
                tripCost = new TripCost(Double.valueOf(distanceInput.getText()), Double.valueOf(mileageInput.getText()),Double.valueOf(gasInput.getText()));

                tripCostOutput.setText(String.valueOf(tripCost.gasolineCost() ));
            }
            catch(Exception e1) {
                tripCostOutput.setText("");
                return;
            }


            System.out.println(tripCost.gasolineCost());

        });

        //combos
        unitOfSpeedSelect = new ComboBox<>();
        gasVolumeSelect = new ComboBox<>();
        gasMileageUnitSelect = new ComboBox<>();


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
        unitOfSpeedSelect.setPrefWidth(200);
        unitOfSpeedSelect.setValue("miles");
        gasVolumeSelect.setValue("dollars/gallon");
        gasMileageUnitSelect.setValue("miles/gallon");


        // adding observableLists
        unitOfSpeedSelect.getItems().addAll(speedUnitList);
        gasVolumeSelect.getItems().addAll(gasVolumeList);
        gasMileageUnitSelect.getItems().addAll(gasMileageList);

        // Add labels and input fields to the grid
        pane.add(distanceLabel, 0, 0);
        pane.add(distanceInput, 1, 0);
        pane.add(unitOfSpeedSelect, 2, 0);


        pane.add(gasLabel, 0, 1);
        pane.add(gasInput, 1, 1);
        pane.add(gasVolumeSelect, 2, 1);

        pane.add(mileageLabel, 0, 2);
        pane.add(mileageInput, 1, 2);
        pane.add(gasMileageUnitSelect, 2, 2);

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
    }

    public GridPane getGrid() {
        return pane;
    }

}



class CalculateTripHandlerClass implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
        double tripTotal = 0.00;
        System.out.println("Calculating trip...");

        //call other methods to calc trip here

    }

//	@Override
//	public void handle(ActionEvent arg0) {
//		// TODO Auto-generated method stub
//
//	}
}
