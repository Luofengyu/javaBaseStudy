package threadstudy.matrixexample.group;

import threadstudy.matrixexample.MatrixGenerator;

import java.util.Date;

/**
 * SerialMain class
 *
 * @author xiwang
 * @date 2019-08-30
 */
public class ParallelGroupMain {
    public static void main(String[] args){
        double[][] matrix1 = MatrixGenerator.generate(2000, 2000);
        double[][] matrix2 = MatrixGenerator.generate(2000, 2000);

        double[][] multiplyResult = new double[matrix1.length][matrix2[0].length];

        Date start = new Date();
        ParallelGroupMultiply.multiply(matrix1, matrix2, multiplyResult);
        Date end  = new Date();
        System.out.println("parallel group matrix multiply version: " + (end.getTime() - start.getTime()));
    }
}
