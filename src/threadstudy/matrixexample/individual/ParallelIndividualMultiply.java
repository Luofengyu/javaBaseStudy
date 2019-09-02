package threadstudy.matrixexample.individual;

import java.util.ArrayList;
import java.util.List;

/**
 * ParallelIndividualMultiply class
 *
 * @author xiwang
 * @date 2019-08-30
 */
public class ParallelIndividualMultiply {
    public static void multiply(double[][] matrix1, double[][] matrix2,
                                double[][] result){
        List<Thread> threads = new ArrayList<>();
        int rows1 = matrix1.length;
        int columns2 = matrix2[0].length;

        for(int i=0; i<rows1; i++){
            for(int j=0; j<columns2; j++){
                IndividualMultiply task = new IndividualMultiply(result, matrix1, matrix2, i, j);
                Thread thread = new Thread(task);
                thread.start();
                threads.add(thread);
                if(threads.size() % 10 == 0){
                    waitForThreads(threads);
                }
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
