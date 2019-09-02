package threadstudy.matrixexample.serial;

/**
 * SerialMultiplier class
 *
 * @author xiwang
 * @date 2019-08-30
 */
public class SerialMultiplier {
    public static void multiply(double[][] matrix1, double[][] matrix2,
                                double[][] result){
        int row1 = matrix1.length;
        int column1 = matrix1[0].length;
        int column2 = matrix2[0].length;

        for(int i=0; i<row1; i++){
            for(int j=0; j<column2; j++){
                result[i][j] = 0;
                for(int k=0; k<column1; k++){
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
    }
}
