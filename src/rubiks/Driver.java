package rubiks;
import java.util.*;

public class Driver {
	public static void main(String[] args) {
		String[] colours = {"WHITE","BLUE","RED","GREEN","YELLOW","ORANGE"};
		String[] cubeInput = new String[6];
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter your cube state:");
		for(int i = 0; i < 6; i++) {
			System.out.print(colours[i] + ":\t");
			cubeInput[i] = scan.nextLine();
		}
		
		//Cube setCube = new Cube();
		Cube myCube = new Cube(cubeInput);
		
		/*setCube.printCube();
		
		for(int i = 0; i < 6; i++)
			setCube.clockwise(i);
		
		for(int i = 0; i < 6; i++)
			setCube.counterclockwise(i);
		
		setCube.printCube(); */
		
		//LLSolver setSolver = new LLSolver(setCube);
		LLSolver solver = new LLSolver(myCube);
		
		solver.solve();
	}
}