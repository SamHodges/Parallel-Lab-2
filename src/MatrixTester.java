import java.util.Arrays;

public class MatrixTester {
    public static final int[] TEST_SIZES = {128, 256, 512, 1024};

    public static void runTests () {
	for (int size : TEST_SIZES) {
	    SquareMatrix sm = new SquareMatrix(size);

	    long start = System.nanoTime();
	    SquareMatrix shortcuts = sm.getShortcutMatrixOptimized();
	    long stop = System.nanoTime();

	    System.out.println("n = " + size + ": " + (stop - start) / 1_000_000 + " ms");
	}
    }
    
    public static void main (String[] args) {
//	float[][] matrix = {{0.0F, 2.0F, 6.0F},
//			    {1.0F, 0.0F, 3.0F},
//			    {4.0F, 5.0F, 0.0F}};
    	
    float[][] matrix = {{0.0F, 5.0F, 6.0F, 1.0F},
    		{1.0F, 0.0F, 4.0F, 7.0F},
    		{3.0F, 3.0F, 0.0F, 2.0F},
    		{2.0F, 5.0F, 1.0F, 0.0F}};
    

	SquareMatrix sm = new SquareMatrix(matrix);

	System.out.println("Original matrix:\n" +
			   Arrays.deepToString(sm.getMatrix()));

	SquareMatrix shortcuts = sm.getShortcutMatrixOptimized();

	System.out.println("Shortcut matrix:\n" +
			   Arrays.deepToString(shortcuts.getMatrix()));
	
	SquareMatrix overall_shortcuts = sm.getShortestOverall();
	
	System.out.println("Shortcut matrix:\n" +
			   Arrays.deepToString(overall_shortcuts.getMatrix()));

	//runTests();
    }

}
