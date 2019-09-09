package rubiks;

public class LLSolver {
	static Cube cube;
	static int turnCount;
	public LLSolver(Cube c) {
		cube = c;
		turnCount = 0;
	}
	public Cube solve() {	
	//1st layer
		System.out.println("Solving first layer...");
		firstLayer();
		cube.printCube();
		
		//
		
		
	//2nd layer
		System.out.println("Solving second layer...");
		
	//3rd layer
		System.out.println("Solving third layer...");
		
		
		return cube;
	}
	public static boolean firstLayer() {
		boolean complete = false;
		String[] rotations = null;
		String[] idx = null;
		
		//{Current coordinate: side+blockie, End coordinate: side+blockie, rotation sequence}
		String[][][] whiteEdges = {{{"11", "07", "5"},{"13", "03", "1 2'"},{"15", "03", "2'"},{"17", "03", "1' 2'"}},
								   {{"21", "01", "1"},{"23", "01", "2' 1"},{"25", "05", "3'"},{"27", "05", "2' 3'"}},
								   {{"31", "03", "2"},{"33", "03", "3' 2"},{"35", "07", "5'"},{"37", "07", "3' 5'"}},
							  	   {{"41", "01", "1 1"},{"43", "07", "5 5"},{"45", "05", "3 3"},{"47", "03", "2 2"}},
								   {{"51", "01", "1'"},{"53", "01", "5' 1'"},{"55", "07", "3"},{"57", "01", "5 1'"}}};
		
		//find white edges
		for(int i = 1; i < 6; i++) {
			System.out.println("\nfirstLayer for1:\t" + i);
			for(int j = 1; j < 9; j+=2) {
				System.out.println("firstLayer for2:\t" + j);
				if(cube.getValue(i, j) == 0) {
					System.out.println("WHITE EDGE FOUND");
					idx = whiteEdges[i-1][(j-1)/2];
					rotations = idx[2].split(" ");
					System.out.print("Rotations to complete:\t");
					for(int k = 0; k < rotations.length; k++) System.out.print(rotations[k] + "\t");
					
					char c = idx[1].charAt(1);
					int cInt = Character.getNumericValue(c);
					while(cube.getValue(0, cInt) == 0) {
						cube.clockwise(0);
					}
					for(int m = 0; m < rotations.length; m++) {
						
						cube.rotate(rotations[m]);
					}
					firstLayer();
				}
				
			}
		}
		return complete;
	}
	public static boolean secondLayer() {
		boolean complete = false;
		return complete;
	}
	public static boolean thirdLayer() {
		boolean complete = false;
		return complete;
	}
}
