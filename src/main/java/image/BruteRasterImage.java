package image;

import javafx.scene.paint.Color;

public class BruteRasterImage implements Image{

    public Color[][] pixels;
    public int width;
    public int height;

    public BruteRasterImage(Color color, int width, int height){
        this.width = width;
        this.height = height;
        Color[][] pixels = new Color[height][width];
        for(int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixels[i][j] = color;
            }
        }
    }



    /**Color getPixelColor(int x, int y);
    int getWidth();
    int getHeight();**/

}
