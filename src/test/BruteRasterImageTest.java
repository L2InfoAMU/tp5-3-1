import image.*;
import javafx.scene.paint.Color;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static util.Matrices.getColumnCount;
import static util.Matrices.getRowCount;

public class BruteRasterImageTest {
    private final BruteRasterImage redSquare = new BruteRasterImage(Color.RED,200,200);
    private final BruteRasterImage redRectangle = new BruteRasterImage(Color.RED,400,200);

    private final Color[][] redSquareMatrix = new Color[200][200];
    private final Color[][] BlueRedSquareMatrix = new Color[200][200];
    private final Color[][] BlueRedRectangleMatrix = new Color[400][200];

    @Test
    void testFirstConstructor(){                                    // This also test setPixelsColor(Color color)
        for(int i = 0; i < 200; i++){                               // Initializing redSquareMatrix
            for(int j = 0; j < 200; j++) {
                redSquareMatrix[i][j] = Color.RED;
            }
        }
        assertEquals(200,getRowCount(redSquare.pixels));    // Testing width initialization
        assertEquals(200,getColumnCount(redSquare.pixels)); // Testing height initialization
        assertArrayEquals(redSquareMatrix,redSquare.pixels);        // Testing color initialization
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
        BruteRasterImage BlueRedSquare =  new BruteRasterImage(BlueRedSquareMatrix); // New BruteRasterImage based on BlueRedSquareMatrix
        assertEquals(getRowCount(BlueRedSquareMatrix),getRowCount(BlueRedSquare.pixels));                // Testing height initialization
        assertEquals(getColumnCount(BlueRedSquareMatrix),getColumnCount(BlueRedSquare.pixels));             // Testing width initialization
        assertEquals(Color.BLUE,BlueRedSquare.pixels[0][0]);        // Testing if pixel (0,0) from BlueRedSquare image is blue
        assertEquals(Color.RED,BlueRedSquare.pixels[0][100]);       // Testing if pixel (0,100) from BlueRedSquare image is red

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
        BruteRasterImage BlueRedRectangle =  new BruteRasterImage(BlueRedRectangleMatrix); // New BruteRasterImage based on BlueRedRectangleMatrix
        assertEquals(getRowCount(BlueRedRectangleMatrix),getRowCount(BlueRedRectangle.pixels));                // Testing height initialization
        assertEquals(getColumnCount(BlueRedRectangleMatrix),getColumnCount(BlueRedRectangle.pixels));             // Testing width initialization
        assertEquals(Color.BLUE,BlueRedRectangle.pixels[0][0]);        // Testing if pixel (0,0) from BlueRedSquare image is blue
        assertEquals(Color.RED,BlueRedRectangle.pixels[0][100]);       // Testing if pixel (0,100) from BlueRedSquare image is red
    }

    @Test
    void testCreateRepresentation(){
        assertEquals(400,getRowCount(redRectangle.pixels));
        assertEquals(200,getColumnCount(redSquare.pixels));
    }


}
