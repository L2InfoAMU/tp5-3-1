package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

import static util.Matrices.*;

public class PaletteRasterImage extends RasterImage implements Image {

    public List<Color> palette;
    public int[][] indexesOfColors;

    public PaletteRasterImage(Color color, int width, int height){
        super(color,width,height);
    }

    public PaletteRasterImage(Color[][] pixel){
        super(pixel);
    }

    public void createRepresentation(){
        palette = new ArrayList<>();
        indexesOfColors = new int[width][height];
    }

    public void setPixelColor(Color color, int x, int y){
        if(!palette.contains(color)){
            palette.add(color);
        }
        indexesOfColors[x][y] = palette.indexOf(color);
    }

    public Color getPixelColor(int x, int y) {
        return palette.get(indexesOfColors[x][y]);
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
        for(int i = 0; i < this.width; i++){
            for(int j = 0; j < this.height; j++){
                setPixelColor(color,i,j);
            }
        }
    }

}
