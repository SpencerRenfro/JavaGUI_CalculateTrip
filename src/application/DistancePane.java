package application;

import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.application.Application;

import javafx.scene.layout.StackPane;
import javafx.scene.control.ContentDisplay;
public class DistancePane {
	private FlowPane pane;
	
	private FlowPane row1;
	private FlowPane row2;
	private FlowPane row3;
	
	private TextField distance;
	private TextField gas;
	private TextField mileage;
	
	
	
	public DistancePane() {
		//styling
//	    pane.setHgap(10); 
//        pane.setVgap(10);
        
        //panes
		pane = new FlowPane();

		
		row1 = new FlowPane();
		row2 = new FlowPane();
		row3 = new FlowPane();
		
		//CSS ID's
		row1.setId("row1");
		row2.setId("row2");
		row3.setId("row3");
	
		
		//input fields
//		TextField distanceInput = new TextField();
//		TextField gasInput = new TextField();
//		TextField mileageInput = new TextField();

        
        //labels and input fields
//        Label distanceLabel = new Label("Distance");
//        Label gasLabel = new Label("Gasoline Cost");
//        Label mileageLabel = new Label("Gas Mileage");
        
        Label distanceLabel = new Label("Distance", new TextField());
        distanceLabel.setContentDisplay(ContentDisplay.RIGHT);
        
        Label gasLabel = new Label("Gasoline Cost", new TextField());
        gasLabel.setContentDisplay(ContentDisplay.RIGHT);
        
        Label mileageLabel = new Label("Gas Mileage", new TextField());
        mileageLabel.setContentDisplay(ContentDisplay.RIGHT);
        
      
        
        //dropdowns
        
        // adding children to each row
        row1.getChildren().add(distanceLabel);
        row2.getChildren().add(gasLabel);
        row3.getChildren().add(mileageLabel);
        
        // add each row to stackPane pane
        pane.getChildren().addAll(row1,row2,row3);
	}
	
	public FlowPane getPane() {
		return pane;
	}

}
