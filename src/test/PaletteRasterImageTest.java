import image.*;
import javafx.scene.paint.Color;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static util.Matrices.getColumnCount;
import static util.Matrices.getRowCount;

public class PaletteRasterImageTest {

    private final PaletteRasterImage redSquare = new PaletteRasterImage(Color.RED,200,200);
    private final PaletteRasterImage redRectangle = new PaletteRasterImage(Color.RED,400,200);

    private final int[][] redSquareMatrix = new int[200][200];
    private final int[][] BlueRedSquareMatrix = new int[200][200];
    private final int[][] BlueRedRectangleMatrix = new int[400][200];

    @Test
    void testFirstConstructor(){                                    // This also test setPixelsColor(Color color)
        for(int i = 0; i < 200; i++){                               // Initializing redSquareMatrix
            for(int j = 0; j < 200; j++) {
                redSquareMatrix[i][j] = redSquare.palette.indexOf(Color.RED);
            }
        }
        assertEquals(200,redSquare.indexesOfColors.length);         // Testing width initialization
        assertEquals(200,redSquare.indexesOfColors[0].length);      // Testing height initialization
        assertArrayEq   uals(redSquareMatrix,redSquare.indexesOfColors);        // Testing color initialization
    }
}
