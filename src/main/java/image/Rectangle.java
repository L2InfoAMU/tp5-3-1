package image;

import javafx.scene.paint.Color;

public class Rectangle implements Shape{
    private int width;
    private int height;
    private Pixel corner;

    public Rectangle(int x, int y, int width, int height, Color color) {
        this.corner = new Pixel(x,y,color);
        this.width = width;
        this.height = height;

    }

    public boolean contains(Point point) {
        return (corner.x < point.x && point.x <= corner.x + this.width
                && corner.y < point.y && point.y <= corner.y + this.height);
    }

    public Color getColor() {
        return this.corner.getColor();
    }
}
