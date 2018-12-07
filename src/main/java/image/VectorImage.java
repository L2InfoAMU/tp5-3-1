package image;

import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;

public class VectorImage implements Image {
    private List<Shape> shapes;
    private int width;
    private int height;

    public VectorImage(List<Shape> shapes, int width, int height) {
        this.shapes = new ArrayList<>();
        setWidth(width);
        setHeight(height);
        for(Shape shape : shapes){
            this.shapes.add(shape);
        }
    }

    public Color getPixelColor(int x, int y){
        Point toSearch = new Point(x,y);
        for(Shape shape : shapes){
            if(shape.contains(toSearch)){
                return shape.getColor();
            }
        }
        return Color.WHITE;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
