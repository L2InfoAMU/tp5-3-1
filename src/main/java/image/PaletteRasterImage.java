package image;

import javafx.scene.paint.Color;

import java.util.List;

public class PaletteRasterImage implements Image {

    public int width;
    public int height;
    public List<Color> palette;
    public int[][] indexesOfColors;

    public BruteRasterImage(Color color, int width, int height){
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

    public void createRepresentation(){
        indexesOfColors = new int[width][height];
    }
    @Override
    public Color getPixelColor(int x, int y) {
        return null;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }
}
