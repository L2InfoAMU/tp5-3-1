package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import static util.Matrices.*;

public class SparseRasterImage extends RasterImage implements Image{

    public Map<Point,Color> pixelsMap;

    public SparseRasterImage(Color color, int width, int height){
        super(color,width,height);
    }

    public SparseRasterImage(Color[][] colors){
        super(colors);
    }

    public void createRepresentation(){
        this.pixelsMap = new HashMap<>();
    }

    private void setPixelColor(Color color, int x, int y){
        pixelsMap.put(new Point(x,y),color);
    }

    public Color getPixelColor(int x, int y){
        return pixelsMap.getOrDefault(new Point(x,y),Color.WHITE);
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
        for(int i = 0; i < getWidth(); i++){
            for(int j = 0; j < getHeight(); j++){
                setPixelColor(color,i,j);
            }
        }
    }
}