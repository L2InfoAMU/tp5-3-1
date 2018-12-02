import image.*;
import javafx.scene.paint.Color;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PaletteRasterImageTest {

    private final PaletteRasterImage redSquare = new PaletteRasterImage(Color.RED,200,200);
    private final PaletteRasterImage redRectangle = new PaletteRasterImage(Color.RED,400,200);

    private final Color[][] redSquareMatrix = new Color[200][200];
    private final Color[][] BlueRedSquareMatrix = new Color[200][200];
    private final Color[][] BlueRedRectangleMatrix = new Color[400][200];


}
