package threadstudy.matrixexample;

import java.util.Random;

/**
 * MatrixGenerator class
 *
 * @author xiwang
 * @date 2019-08-30
 */
public class MatrixGenerator {
    public static double[][] generate(int rows, int columns){
        double[][] matrix = new double[rows][columns];
        Random random = new Random();
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                matrix[i][j] = random.nextDouble() * 10;
            }
        }
        return matrix;
    }
}
