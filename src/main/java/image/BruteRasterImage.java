package image;
import util.Matrices.*;

import javafx.scene.paint.Color;

import static util.Matrices.*;

public class BruteRasterImage implements Image{

    public Color[][] pixels;
    public int width;
    public int height;

    public BruteRasterImage(Color color, int width, int height){
        this.width = width;
        this.height = height;
        createRepresentation();
        for(int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                pixels[i][j] = color;
            }
        }
    }

    public BruteRasterImage(Color[][] colors){
        requiresNonNull(colors);
        requiresNonZeroDimensions(colors);
        requiresRectangularMatrix(colors);
        createRepresentation();
        this.width = getRowCount(colors);
        this.height = getColumnCount(colors);
        for(int i = 0; i < this.width; i++){
            for(int j = 0; j < this.height; j++){
                pixels[i][j] = colors[i][j];
            }
        }
    }

    public void createRepresentation(){
        Color[][] pixels = new Color[width][height];
    }
    

}
