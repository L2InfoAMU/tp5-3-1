package image;
import util.Matrices.*;

import javafx.scene.paint.Color;

import static util.Matrices.*;

public class BruteRasterImage implements Image{

    public Color[][] pixels;
    public int width;
    public int height;

    public BruteRasterImage(Color color, int width, int height){
        setWidth(width);
        setHeight(height);

        createRepresentation();

        setPixelsColor(color);
        /*for(int i = 0; i < width; i++) {              // Method without using setPixelsColor
            for (int j = 0; j < height; j++) {
                setPixelColor(color,i,j);
            }
        }*/
    }

    public BruteRasterImage(Color[][] colors){
        requiresNonNull(colors);
        requiresNonZeroDimensions(colors);
        requiresRectangularMatrix(colors);

        setWidth(getRowCount(colors));
        setHeight(getColumnCount(colors));

        createRepresentation();

        setPixelsColor(colors);
        /*for(int i = 0; i < this.width; i++){          // Method without using setPixelsColor
            for(int j = 0; j < this.height; j++){
                setPixelColor(colors[i][j],i,j);
            }
        }*/
    }

    public void createRepresentation(){
        this.pixels = new Color[width][height];
    }

    public void setPixelColor(Color color, int x, int y){
        this.pixels[x][y] = color;
    }

    public Color getPixelColor(int x, int y){
        return this.pixels[x][y];
    }

    private void setPixelsColor(Color[][] pixels){
        requiresNonNull(pixels);
        for(int i = 0; i < this.width; i++){
            for(int j = 0; j < this.height; j++){
                setPixelColor(pixels[i][j],i,j);
            }
        }
    }

    private void setPixelsColor(Color color){
        for(int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                setPixelColor(color,i,j);
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}