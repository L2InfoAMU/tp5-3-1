package image;

import javafx.scene.paint.Color;

import java.util.List;

import static util.Matrices.*;

public class PaletteRasterImage implements Image {

    public int width;
    public int height;
    public List<Color> palette;
    public int[][] indexesOfColors;

    public PaletteRasterImage(Color color, int width, int height){
        setWidth(width);
        setHeight(height);
        createRepresentation();
        setPixelsColor(color);
    }

    public PaletteRasterImage(Color[][] pixel){
        requiresNonNull(pixel);
        requiresNonZeroDimensions(pixel);
        requiresRectangularMatrix(pixel);
        setWidth(getRowCount(pixel));
        setHeight(getColumnCount(pixel));
        createRepresentation();
        setPixelsColor(pixel);
    }
    
    public void createRepresentation(){
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
        for(int i = 0; i < getRowCount(pixels); i++){
            for(int j = 0; j < getColumnCount(pixels); j++){
                setPixelColor(pixels[i][j],i,j);
            }
        }
    }

    private void setPixelsColor(Color color){
        for(int i = 0; i < this.width; i++){
            for(int j = 0; j < this.height; j++){
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

    protected void setWidth(int width){
        this.width = width;
    }

    protected void setHeight(int height){
        this.height = height;
    }
}
