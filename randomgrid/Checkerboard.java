/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomgrid;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author enoch
 */
public class Checkerboard {
    
    private double boardWidth;
    private double boardHeight;
    private int numRows;

    public double getBoardWidth() {
        return boardWidth;
    }

    public void setBoardWidth(double boardWidth) {
        this.boardWidth = boardWidth;
    }

    public double getBoardHeight() {
        return boardHeight;
    }

    public void setBoardHeight(double boardHeight) {
        this.boardHeight = boardHeight;
    }

    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public void setNumCols(int numCols) {
        this.numCols = numCols;
    }

    public Color getLightColor() {
        return lightColor;
    }

    public void setLightColor(Color lightColor) {
        this.lightColor = lightColor;
    }

    public Color getDarkColor() {
        return darkColor;
    }

    public void setDarkColor(Color darkColor) {
        this.darkColor = darkColor;
    }

    public double getRectangleHeight() {
        return rectangleHeight;
    }

    public void setRectangleHeight(double rectangleHeight) {
        this.rectangleHeight = rectangleHeight;
    }

    public double getRectangleWidth() {
        return rectangleWidth;
    }

    public void setRectangleWidth(double rectangleWidth) {
        this.rectangleWidth = rectangleWidth;
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }
    private int numCols;
    private Color lightColor = Color.RED;
    private Color darkColor = Color.BLACK;
    
    private double rectangleHeight;
    private double rectangleWidth;
    
    //private final Color[] colors = {Color.RED, Color.BLACK};
    
    
    private AnchorPane anchorPane = new AnchorPane();
    
    
    
    public Checkerboard( double width, double height, int rows, int columns){
        this.boardHeight = height;
        this.boardWidth = width;
        this.numRows = rows;
        this.numCols = columns;
    }
    public Checkerboard(double width, double height, int rows, int columns, Color lightColor, Color darkColor){
        this(width,height,rows, columns);
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    
    public AnchorPane getBoard(){
        
        if(anchorPane ==null){
            return null;
        }
        
        
        return anchorPane;
    }
    
    
    public AnchorPane build(){
       rectangleHeight = boardHeight/ numRows;
       rectangleWidth = boardWidth / numCols;
       Color color;
      
       for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
              
                if ((row % 2) == (col % 2)){
                    color = lightColor;
                    Rectangle rect = new Rectangle(rectangleWidth, rectangleHeight, color);
                    rect.setX((rectangleWidth)* col);
                    rect.setY((rectangleHeight)* row );
                    anchorPane.getChildren().add(rect);
                }
                else{
                    color = darkColor;
                    Rectangle rect = new Rectangle(rectangleWidth, rectangleHeight, color);
                    rect.setX((rectangleWidth)* col);
                    rect.setY((rectangleHeight)* row );
                    anchorPane.getChildren().add(rect);
                }
                
            }
       }
        
        
        return getBoard();        
    }
}
