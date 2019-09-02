package threadstudy.matrixexample.row;

import java.util.ArrayList;
import java.util.List;

/**
 * ParallelRowMultiply class
 *
 * @author xiwang
 * @date 2019-08-30
 */
public class ParallelRowMultiply {
    public static void multiply(double[][] matrix1, double[][] matrix2,
                                double[][] result){
        List<Thread> threads = new ArrayList<>();
        int rows1 = matrix1.length;

        for(int i=0; i<rows1; i++){
            RowMultiply task = new RowMultiply(result, matrix1, matrix2, i);
            Thread thread = new Thread(task);
            thread.start();
            threads.add(thread);
            if(threads.size() % 10 == 0){
                waitForThreads(threads);
            }
        }
    }

    private static void waitForThreads(List<Thread> threads){
        for(Thread thread: threads){
            try {
                thread.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        threads.clear();
    }


}
