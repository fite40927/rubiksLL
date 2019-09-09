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
		
		firstLayer();
		
		//
		
		
	//2nd layer
		
		
	//3rd layer
		
		
		
		return cube;
	}
	public static boolean firstLayer() {
		boolean complete = false;
		//find white edges
		for(int i = 1; i < 6; i++) {
			for(int j = 0; j < 9; j++) {
				if(cube.getValue(i, j) == 0) {
					if(turnCount < 4) {
						cube.clockwise(i);
						turnCount++;
					}
					else {
						cube.clockwise(cube.getAdjacentSide(i, j));
						turnCount = 0;
					}
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
