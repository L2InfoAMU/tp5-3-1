package image;
import util.Matrices.*;

import javafx.scene.paint.Color;

import static util.Matrices.*;

public class BruteRasterImage extends RasterImage implements Image{

    public Color[][] pixels;

    public BruteRasterImage(Color color, int width, int height){
        super(color,width,height);
    }

    public BruteRasterImage(Color[][] colors){
        super(colors);
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

    public void setPixelsColor(Color[][] pixels){
        requiresNonNull(pixels);
        for(int i = 0; i < getRowCount(pixels); i++){
            for(int j = 0; j < getColumnCount(pixels); j++){
                setPixelColor(pixels[i][j],i,j);
            }
        }
    }

    public void setPixelsColor(Color color){
        for(int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                setPixelColor(color,i,j);
            }
        }
    }

}