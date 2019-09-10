package rubiks;
import java.util.*;

/*
G O O B Y O B W W
R G G B O R W G B
G Y W W Y G B R R
O W G W R Y Y Y G
B O Y Y W O O R Y
R R W B R G B B O
 */

public class LLSolver {
	static Cube cube;
	static int turnCount;
	public LLSolver(Cube c) {
		cube = c;
		turnCount = 0;
		cube.printCube();
	}
	public Cube solve() {	
	//1st layer
		System.out.println("Solving first layer...");
		firstLayer();
		cube.printCube();
		
	//2nd layer
		System.out.println("Solving second layer...");
		secondLayer();
		
	//3rd layer
		System.out.println("Solving third layer...");
		thirdLayer();
		
		
		return cube;
	}
	public static boolean firstLayer() {
		boolean complete = false;
		
		//place edges
		findWhiteEdges();
		
		//check permutation
		String placement = "";
		String expectedPlacement = "1235123";
		for(int i = 1; i < 9; i+=2) {
			int adjCubie[] = cube.getAdjacentCubie(0, i);
			System.out.println(adjCubie[0] + "\t" + adjCubie[1]);
			placement = placement.concat("" + cube.getValue(adjCubie[0], adjCubie[1]));
		}
	
		if(expectedPlacement.contains(placement)) {
			System.out.println("\nCorrectly placed\n");
		}
		else {
			System.out.println("\nIncorrectly placed\n");
			for(int i = 0; i < expectedPlacement.length(); i++) {
				if(expectedPlacement.charAt(i) == placement.charAt(0)) {
					expectedPlacement = expectedPlacement.substring(i, i+4);
					i = expectedPlacement.length();
				}
			}
			System.out.println(placement);
			System.out.println(expectedPlacement);
			int[] p = {1, 3, 5, 7};
			for(int i = 0; i < 4; i++) {
				if(placement.charAt(i) != expectedPlacement.charAt(i)) {
					for(int j = i+1; j < 4; j++) {
						if(placement.charAt(j) == expectedPlacement.charAt(i)) {
							
						}
					}
				}
			}
			
		}
		
		return complete;
	}
	public static boolean findWhiteEdges() {
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
			for(int j = 1; j < 9; j+=2) {
				if(cube.getValue(i, j) == 0) {
					System.out.println("\nWHITE EDGE FOUND");
					idx = whiteEdges[i-1][(j-1)/2];
					rotations = idx[2].split(" ");
					
					while(cube.getValue(0, Basics.toInt(idx[1].charAt(1))) == 0) {
						cube.clockwise(0);
					}
					for(int m = 0; m < rotations.length; m++) {
						
						cube.rotate(rotations[m]);
					}
					findWhiteEdges();
				}
				
			}
		}
		return true;
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
