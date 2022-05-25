package threadPoolExecutor.Exe3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Runner {

	public static void main(String[] args) throws InterruptedException{
		
		Matrix mat = new Matrix(1000);
		mat.initializeMatrix();
//		mat.printMatrix();

		System.out.println("--- Serial result for multiply ---");
		long start = System.currentTimeMillis();
		Matrix res = Matrix.multiplyMatrix(mat.matrix, mat.matrix);
		long end = System.currentTimeMillis();
		System.out.println("Elapsed time for Serial excution: " + (end-start));
//		res.printMatrix();
		
		ExecutorService executorService = Executors.newFixedThreadPool(8);
		
		long start2 = System.currentTimeMillis();
		Matrix result = new Matrix(mat.getSize());
		
//		Lock lock = new ReentrantLock();
		for (int i = 0; i < mat.getSize(); i++) {
			for (int j = 0; j < mat.getSize(); j++) {
//				lock.lock();
				 executorService.submit(new RunTask(mat, mat, result, i, j));
//				 lock.unlock();
			}	
		}
		long end2 = System.currentTimeMillis();
		System.out.println("Elapsed time for Parellal excution: " + (end2-start2));
		
		executorService.shutdown();
		executorService.awaitTermination(2, TimeUnit.SECONDS);
		
		System.out.println("--- Parellal solving ---");
		System.out.println("Is the serial and parellal result equals : " + Matrix.isMatrixSame(result, res) );
//		result.printMatrix();
		
	}
	

	static class RunTask implements Runnable{
		private int i,j;
		Matrix mat1, mat2, res;
		
		public RunTask(Matrix mat1, Matrix mat2, Matrix res, int i, int j) {
			this.mat1 = mat1;
			this.mat2 = mat2;
			this.res = res;
			this.i = i;
			this.j = j;
		}

		@Override
		public void run() {
			for (int k = 0; k < mat1.getSize(); k++) 
				res.matrix[i][j] += mat1.matrix[i][k] * mat2.matrix[k][j];
			
		}
	}


}
