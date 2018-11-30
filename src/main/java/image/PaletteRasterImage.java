package image;

import javafx.scene.paint.Color;

import java.util.List;

public class PaletteRasterImage implements Image {
    private List<Color> palette;
    public int width;
    public int height;
    public int[][] indexesOfColor;

    public BruteRasterImage(Color color, int width, int height){
        this.width = width;
        this.height = height;
        createRepresentation();
        for(int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                pixels[j][i] = color;
            }
        }
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

    @Override
    public void setPixelsColor(Color[][] pixels){
        for (int i = 0;i < width;i++) {
            for (int j = 0; j < height; j++) {
                indexesOfColor[j][i] = palette.indexOf(pixels[j][i]);
            }
        }
    }

    @Override
    private void setPixelsColor(Color color){

    }

    @Override
    protected void setWidth(int width){

    }

    @Override
    protected void setHeight(int height){

    }


