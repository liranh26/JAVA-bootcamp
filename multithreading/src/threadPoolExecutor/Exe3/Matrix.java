package threadPoolExecutor.Exe3;

public class Matrix {

	private int size;
	public int[][] matrix;

	public Matrix(int size) {
		this.size = size;
		matrix = new int[size][size];
	}

	
	
	public int getSize() {
		return size;
	}
	
	public void initializeMatrix() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				matrix[i][j] = 1;
			}
		}
	}

	public static Matrix multiplyMatrix(int[][] mat1, int[][] mat2) {
		if (mat1.length != mat2.length)
			return null;
		int size = mat1.length;
		Matrix res = new Matrix(size);
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++)
					res.matrix[i][j] += mat1[i][k] * mat2[k][j];
			}
		}

		return res;
	}

	public void printMatrix() {
		for (int i = 0; i < size; i++) {
			System.out.print("{ ");
			for (int j = 0; j < size; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.print("}");
			System.out.println();
		}
	}
	
	public static Boolean isMatrixSame(Matrix mat1, Matrix mat2) {
		for (int i = 0; i < mat1.getSize(); i++) {
			for (int j = 0; j < mat1.getSize(); j++) {
				if(mat1.matrix[i][j] != mat2.matrix[i][j])
					return false;
			}
		}
		return true;
	}
	

}
