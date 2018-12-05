package image;

import util.Matrices.*;

import javafx.scene.paint.Color;

import static util.Matrices.*;
import java.awt.*;

public abstract class RasterImage{

    public int width;
    public int height;


    public RasterImage(Color color, int width, int height){
        setWidth(width);
        setHeight(height);

        createRepresentation();

        setPixelsColor(color); // utilise setPixelsColor(Color color)
    }

    public RasterImage(Color[][] colors){
        requiresNonNull(colors);
        requiresNonZeroDimensions(colors);
        requiresRectangularMatrix(colors);

        setWidth(getRowCount(colors));
        setHeight(getColumnCount(colors));

        createRepresentation();

        setPixelsColor(colors); // utilise setPixelsColor(Color[][] pixels)
    }
    public abstract void createRepresentation();
    public abstract void setPixelsColor(Color color);
    public abstract void setPixelsColor(Color[][] pixels);



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
