package threadstudy.matrixexample.group;

import java.util.ArrayList;
import java.util.List;

/**
 * ParallelRowMultiply class
 *
 * @author xiwang
 * @date 2019-08-30
 */
public class ParallelGroupMultiply {
    public static void multiply(double[][] matrix1, double[][] matrix2,
                                double[][] result){
        List<Thread> threads = new ArrayList<>();
        int rows1 = matrix1.length;

        int numThreads = Runtime.getRuntime().availableProcessors();
        int startIndex, endIndex, step;
        step = rows1/numThreads;
        startIndex = 0;
        endIndex = step;

        for(int i=0; i<numThreads; i++){
            GroupMultiply task = new GroupMultiply(result, matrix1, matrix2, startIndex, endIndex);
            Thread thread = new Thread(task);
            thread.start();
            threads.add(thread);
            startIndex = endIndex;
            endIndex = i==numThreads-2 ? rows1: endIndex+step;
        }
        waitForThreads(threads);
    }

    private static void waitForThreads(List<Thread> threads){
        for(Thread thread: threads){
            try {
                thread.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }


}
