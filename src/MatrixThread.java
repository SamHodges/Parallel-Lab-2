import java.util.concurrent.ThreadLocalRandom;

public class MatrixThread implements Runnable {
	// initialize variables
	int threadWorkload;
	float[][] shortcuts;
	float[][] matrix;
	float[][] transposed;
	int threadNum;

	// set thread variables
	public MatrixThread(int threadWorkload, float[][] shortcuts, int threadNum, float[][] matrix,
			float[][] transposed) {
		this.threadWorkload = threadWorkload;
		this.shortcuts = shortcuts;
		this.threadNum = threadNum;
		this.matrix = matrix;
		this.transposed = transposed;
	}

	// code that runs when the thread is started
	public void run() {
		// define height and width that this specific thread is assigned
		int width = shortcuts.length;
		int heightMin = threadWorkload * threadNum;
		int heightMax = heightMin + threadWorkload;

		// loop through rows and columns to find shortcuts
		for (int i = 0; i < width; ++i) {
			for (int j = heightMin; j < heightMax; ++j) {

				float min = Float.MAX_VALUE;

				// check to see if any shortcuts are shorter than non-shortcuts
				for (int k = 0; k < width; ++k) {
					float x = matrix[i][k];
					float y = transposed[j][k];
					float z = x + y;

					if (z < min) {
						// if there are shorter paths, set them as the new shortcut
						min = z;
					}
				}
				// update portion of shortcuts matrix with new shortcuts
				shortcuts[i][j] = min;
			}
		}

	}
}