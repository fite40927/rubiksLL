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
		
		//{Coordinate: side+blockie, End coordinate: side+blockie, rotation sequence}
		String[][] whiteEdges = {{"11", "07", "5"},{"13", "03", "1 2'"},{"15", "03", "2'"},{"17", "03", "1' 2'"},
								 {"21", "01", "1"},{"23", "01", "2' 1"},{"25", "05", "3'"},{"27", "05", "2' 3'"},
								 {"31", "03", "2"},{"33", "03", "3' 2"},{"35", ""},{"37", ""},
								 {"41", "1 1"},{"43", ""},{"45", ""},{"47", "2 2"},
								 {"51", ""},{"53", ""},{"55", ""},{"57", ""}};
		
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
