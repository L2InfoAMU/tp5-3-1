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
        this.width = width;
        this.height = height;
        createRepresentation();
        palette.add(color);
        for(int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                indexesOfColors[j][i] = palette.indexOf(color);
            }
        }
    }

    public PaletteRasterImage(Color[][] pixel){
        requiresNonNull(pixel);
        requiresNonZeroDimensions(pixel);
        requiresRectangularMatrix(pixel);
        this.width = getRowCount(pixel);
        this.height = getColumnCount(pixel);
        createRepresentation();
        for(int i = 0; i < this.width; i++){
            for(int j = 0; j < this.height; j++){
                if(!palette.contains(pixel[j][i])){
                    palette.add(pixel[j][i]);
                }
                indexesOfColors[j][i] = palette.indexOf(pixel[j][i]);
            }
        }
    }
    
    public void createRepresentation(){
        indexesOfColors = new int[width][height];
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return palette.get(indexesOfColors[x][y]);
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
