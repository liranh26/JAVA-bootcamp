package threadPoolExecutor.Exe3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Runner {

	public static void main(String[] args) throws InterruptedException{
		
		Matrix mat = new Matrix(10);
		mat.initializeMatrix();
		mat.printMatrix();

		System.out.println("--- Serial result for multiply ---");
		Matrix res = Matrix.multiplyMatrix(mat.matrix, mat.matrix);
		System.out.println( System.nanoTime() );
		res.printMatrix();
		
		ExecutorService executorService = Executors.newFixedThreadPool(6);
		
		Matrix result = new Matrix(mat.getSize());
		for (int i = 0; i < mat.getSize(); i++) {
			for (int j = 0; j < mat.getSize(); j++) {
				 executorService.submit(new RunTask(mat, mat, result, i, j));
			}	
		}
		
		executorService.shutdown();
		executorService.awaitTermination(2, TimeUnit.SECONDS);
		System.out.println( System.nanoTime() );
		
		System.out.println("--- Parellal solving ---");
		System.out.println("Is the serial and parellal result equals : " + Matrix.isMatrixSame(result, res) );
		result.printMatrix();
		
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
