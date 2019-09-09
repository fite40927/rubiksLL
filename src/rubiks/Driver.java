package rubiks;

public class Driver {
	public static void main(String[] args) {
		Cube myCube = new Cube();
		myCube.printCube();
		
		for(int i = 0; i < 6; i++)
			myCube.clockwise(i);
		
		for(int i = 0; i < 6; i++)
			myCube.counterclockwise(i);
		
		myCube.printCube();
		
		LLSolver solver = new LLSolver(myCube);
		
		solver.solve();
	}
}