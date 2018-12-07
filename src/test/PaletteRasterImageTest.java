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
    private final Color[][] BlueRedSquareMatrix = new Color[200][200];
    private final Color[][] BlueRedRectangleMatrix = new Color[400][200];

    @Test
    void testFirstConstructor(){                                    // This also test setPixelsColor(Color color)
        for(int i = 0; i < 200; i++){                               // Initializing redSquareMatrix
            for(int j = 0; j < 200; j++) {
                redSquareMatrix[i][j] = redSquare.palette.indexOf(Color.RED);
            }
        }
        assertEquals(200,redSquare.indexesOfColors.length);         // Testing width initialization
        assertEquals(200,redSquare.indexesOfColors[0].length);      // Testing height initialization
        assertArrayEquals(redSquareMatrix,redSquare.indexesOfColors);        // Testing color initialization
    }

    @Test
    void testSecondConstructor(){                                   // This also test setPixelsColor(Color[][] pixels)
        // Testing constructor with a square matrix
        for(int i = 0; i < 200; i++){                               // Initializing BlueRedSquareMatrix blue part
            for(int j = 0; j < 100; j++){                           // pixels (i,j) where i = [0;200[ j = [0;100[ are blue
                BlueRedSquareMatrix[i][j] = Color.BLUE;
            }
        }
        for(int i = 0; i < 200; i++){                               // Initializing BlueRedSquareMatrix red part
            for(int j = 100; j < 200; j++){                         // pixels (i,j) where i = [0;200[ j = [100;200[ are red
                BlueRedSquareMatrix[i][j] = Color.RED;
            }
        }
        PaletteRasterImage BlueRedSquare =  new PaletteRasterImage(BlueRedSquareMatrix); // New PaletteRasterImage based on BlueRedSquareMatrix
        assertEquals(getRowCount(BlueRedSquareMatrix),BlueRedSquare.indexesOfColors.length);                // Testing height initialization
        assertEquals(getColumnCount(BlueRedSquareMatrix),BlueRedSquare.indexesOfColors[0].length);             // Testing width initialization
        assertEquals(BlueRedSquare.palette.indexOf(Color.BLUE),BlueRedSquare.indexesOfColors[0][0]);        // Testing if pixel (0,0) from BlueRedSquare image is blue (index of color blue in blueredsquare.palette)
        assertEquals(BlueRedSquare.palette.indexOf(Color.RED),BlueRedSquare.indexesOfColors[0][100]);       // Testing if pixel (0,100) from BlueRedSquare image is red (index of color red in blueredsquare.palette)

        // Testing constructor with a rectangle matrix
        for(int i = 0; i < 400; i++){                               // Initializing BlueRedRectangleMatrix blue part
            for(int j = 0; j < 100; j++){                            // pixels (i,j) where i = [0;400[ j = [0;100[ are blue
                BlueRedRectangleMatrix[i][j] = Color.BLUE;
            }
        }
        for(int i = 0; i < 400; i++){                               // Initializing BlueRedRectangleMatrix red part
            for(int j = 100; j < 200; j++){                         // pixels (i,j) where i = [0;400[ j = [100;200[ are red
                BlueRedRectangleMatrix[i][j] = Color.RED;
            }
        }
        PaletteRasterImage BlueRedRectangle =  new PaletteRasterImage(BlueRedRectangleMatrix); // New BruteRasterImage based on BlueRedRectangleMatrix
        assertEquals(getRowCount(BlueRedRectangleMatrix),BlueRedRectangle.indexesOfColors.length);                // Testing height initialization
        assertEquals(getColumnCount(BlueRedRectangleMatrix),BlueRedRectangle.indexesOfColors[0].length);             // Testing width initialization
        assertEquals(BlueRedRectangle.palette.indexOf(Color.BLUE),BlueRedRectangle.indexesOfColors[0][0]);        // Testing if pixel (0,0) from BlueRedSquare image is blue
        assertEquals(BlueRedRectangle.palette.indexOf(Color.RED),BlueRedRectangle.indexesOfColors[0][100]);       // Testing if pixel (0,100) from BlueRedSquare image is red
    }

    @Test
    void testCreateRepresentation(){
        assertEquals(400,redRectangle.indexesOfColors.length);
        assertEquals(200,redSquare.indexesOfColors[0].length);
    }
}
