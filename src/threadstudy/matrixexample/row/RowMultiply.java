package threadstudy.matrixexample.row;

/**
 * RowMultiply class
 * 每一行元素的计算一个线程
 * @author xiwang
 * @date 2019-08-30
 */
public class RowMultiply implements Runnable{

    private final double[][] result;
    private final double[][] matrix1;
    private final double[][] matrix2;

    private final int row;

    public RowMultiply(double[][] result,
                       double[][] matrix1, double[][] matrix2,
                       int row){
        this.result = result;
        this.matrix1= matrix1;
        this.matrix2 = matrix2;
        this.row = row;
    }

    @Override
    public void run() {
        int column = matrix2[0].length;
        for(int j=0; j<column; j++){
            result[row][j] = 0;
            for(int k=0; k<matrix1[row].length; k++){
                result[row][j] += matrix1[row][k] * matrix2[k][j];
            }
        }
    }
}
