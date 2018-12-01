import image.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static util.Matrices.getColumnCount;
import static util.Matrices.getRowCount;

public class BruteRasterImageTest {
    private final BruteRasterImage redSquare = new BruteRasterImage(Color.RED,200,200);
    private final BruteRasterImage blueSquare = new BruteRasterImage(Color.BLUE,200,200);
    private final BruteRasterImage redRectangle = new BruteRasterImage(Color.RED,400,200);
    private final BruteRasterImage blueRectangle = new BruteRasterImage(Color.BLUE, 400,200);

    private final Color[][] redSquareMatrix = new Color[200][200];
    private final Color[][] BlueRedSquareMatrix = new Color[200][200];



    @Test
    void testFirstConstructor(){
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
    void testSecondConstructor(){
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
        assertEquals(Color.RED,BlueRedSquare.pixels[0][100]);        // Testing if pixel (0,100) from BlueRedSquare image is red
    }
}
