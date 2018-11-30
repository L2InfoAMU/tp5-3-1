package image;

import javafx.scene.paint.Color;

import java.util.List;

public class PaletteRasterImage implements Image {
    private List<Color>

    PaletteRasterImage(Color color, int width, int height){

    }

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
