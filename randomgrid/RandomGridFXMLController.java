/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomgrid;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author enoch
 */
public class RandomGridFXMLController  implements Initializable, Startable {
    
    private Stage stage;
    
   Checkerboard checkerBoard;
    
    private final Color[] colors = {Color.RED,/* Color.DEEPPINK, Color.BISQUE, /*Color.AZURE,*/ Color.BLACK};
    
    @FXML
    private AnchorPane anchorPane;
    
   
    @FXML
    private VBox vbox;
    
    int currentRows =8;
    int currentCols =8;
    
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println(anchorPane.getWidth());
        
        
    }   

    public void start(Stage stage) {
        this.stage = stage;
        System.out.println(anchorPane.getWidth());
        
        
        checkerBoard = new Checkerboard(anchorPane.getWidth() ,anchorPane.getHeight(), 8, 8);
        
         anchorPane.getChildren().add(checkerBoard.build());
        
         
       
        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue)->{
          refresh(currentRows,currentCols);
          System.out.println(anchorPane.widthProperty());
      //    System.out.println(stage.widthProperty());
        
        };
        /*
        this.stage.heightProperty().addListener(new ChangeListener <Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
              refresh(currentRows,currentCols); 
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
          */      
        
        
        
        this.anchorPane.widthProperty().addListener(lambdaChangeListener);
        this.anchorPane.heightProperty().addListener(lambdaChangeListener);
        
       // this.stage.widthProperty().addListener(lambdaChangeListener);
       // this.stage.heightProperty().addListener(lambdaChangeListener);
       
       
    }
    
    private void refresh(int numRows, int numCols){
       anchorPane.getChildren().clear();
       
      checkerBoard = new Checkerboard(anchorPane.getWidth() ,anchorPane.getHeight(), numRows, numCols);
      // vbox.getChildren().remove(anchorPane);
       anchorPane.getChildren().add(checkerBoard.build());
       
       
       
    }

    
    private void colored(Color lightColor, Color darkColor){
     int numRows =  checkerBoard.getNumCols();
     int numCols =   checkerBoard.getNumRows();
        anchorPane.getChildren().clear();
       checkerBoard = new Checkerboard(anchorPane.getWidth() ,anchorPane.getHeight(), numRows, numCols, lightColor, darkColor);
      // vbox.getChildren().remove(anchorPane);
       anchorPane.getChildren().add(checkerBoard.build());
    }
    
    
    
    
    @FXML
    private void handle16(ActionEvent event) {
        refresh(16,16);
        currentRows = 16;
        currentCols= 16;
    }

    @FXML
    private void handle10(ActionEvent event) {
        refresh(10,10);
        currentRows =10;
        currentCols= 10;
    }

    @FXML
    private void handle8(ActionEvent event) {
        refresh(8,8);
        currentRows =8;
        currentCols= 8;
    }

    @FXML
    private void handle3(ActionEvent event) {
        
        refresh(3,3);
        currentRows =3;
        currentCols= 3;
        
    }

    @FXML
    private void red(ActionEvent event) {
        
        colored(Color.RED, Color.BLACK);
        
    }

    @FXML
    private void blue(ActionEvent event) {
        
        colored(Color.SKYBLUE, Color.DARKBLUE);  
        
    }
}
