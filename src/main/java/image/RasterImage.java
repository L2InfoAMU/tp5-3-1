package image;

import util.Matrices.*;

import javafx.scene.paint.Color;

import static util.Matrices.*;

public class RasterImage {
    public int width;
    public int height;

    public RasterImage(Color color, int width, int height){
        setWidth(width);
        setHeight(height);

        createRepresentation();

        setPixelsColor(color);
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
