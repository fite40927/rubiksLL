package rubiks;

public class Cube {
	
	/* TO DO (pls u cunt, dont be lazy just do it)
	 * 
	 * 1. --FINISHED-- Instead of assigning letters, assign numbers to the cube and print out
	 *    			   corresponding letters
	 * 2. Rewrite clockwise/counterclockwise turning functions with 'for' loops or
	 *    use more efficient switching
	 * 3. Recursion with first layer edge orientation
	 * 		
	 * 			1
	 * 		 |0|1|2|
	 * 		 |7|8|3|
	 *    0  |6|5|4|  4		5
	 * |0|1|2|0|1|2|0|1|2|0|1|2|
	 * |7|8|3|7|8|3|7|8|3|7|8|3|
	 * |6|5|4|6|5|4|6|5|4|6|5|4|
	 *		 |0|1|2|
	 * 		 |7|8|3|
	 * 		 |6|5|4|
	 * 			3
	 * 
	 */
	
	
	public static int[][] cube = new int[6][9];
	public String[] faceColours = {"WHITE","BLUE","RED","GREEN","YELLOW","ORANGE"};
	
	public Cube() {
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 9; j++) {
				cube [i][j] = i;
			}
		}
		System.out.println("Cube created");
	}
	
	public void printCube(){
		System.out.println("\nCube status:");
		String cubeS = "";
		for(int i = 0; i < 6; i++) {
			cubeS += faceColours[i] + ":\t";
			for(int j = 0; j < 9; j++) {
				cubeS = cubeS + getColorValue(cube[i][j]) + "\t";
			}
			cubeS += "\n";
		}
		System.out.println(cubeS);
	}
	
	//resets cube to solved status
	public void reset() {
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 9; j++) {
				cube [i][j] = i;
			}
		}
	}
	
	//returns value of block colour
	public static String getColorValue(int blockNum) {
		switch(blockNum) {
		case 0: return "W";
		case 1: return "B";
		case 2: return "R";
		case 3: return "G";
		case 4: return "Y";
		case 5: return "O";
		default: return "-";
		}
	}
	
	public int[][] getCube() {
		return cube;
	}
	
	public int getValue(int a, int b) {
		return cube[a][b];
	}
	public int[] getAdjacentCubie(int a, int b) {
		//for edges only
		int pair[] = new int[2];
		switch(a) {
			case 0: {
				switch(b) {
					case 1: pair[0] = 1; pair[0] = 7; break;
					case 3: pair[0] = 2; pair[0] = 7; break;
					case 5: pair[0] = 3; pair[0] = 7; break;
					case 7: pair[0] = 5; pair[0] = 3; break;
				}
				break;
			}
			case 1: {
				switch(b) {
					case 1: pair[0] = 5; pair[0] = 1; break;
					case 3: pair[0] = 4; pair[0] = 1; break;
					case 5: pair[0] = 2; pair[0] = 1; break;
					case 7: pair[0] = 0; pair[0] = 1; break;
				}
			}
			case 2: {
				switch(b) {
					case 1: pair[0] = 1; pair[0] = 5; break;
					case 3: pair[0] = 4; pair[0] = 7; break;
					case 5: pair[0] = 3; pair[0] = 1; break;
					case 7: pair[0] = 0; pair[0] = 3; break;
				}
			}
			case 3: {
				switch(b) {
					case 1: pair[0] = 2; pair[0] = 5; break;
					case 3: pair[0] = 4; pair[0] = 5; break;
					case 5: pair[0] = 5; pair[0] = 5; break;
					case 7: pair[0] = 0; pair[0] = 5; break;
				}
			}
			case 4: {
				switch(b) {
					case 1: pair[0] = 1; pair[0] = 5; break;
					case 3: pair[0] = 5; pair[0] = 7; break;
					case 5: pair[0] = 3; pair[0] = 3; break;
					case 7: pair[0] = 2; pair[0] = 3; break;
				}
			}
			case 5: {
				switch(b) {
					case 1: pair[0] = 1; pair[0] = 3; break;
					case 3: pair[0] = 0; pair[0] = 7; break;
					case 5: pair[0] = 3; pair[0] = 5; break;
					case 7: pair[0] = 4; pair[0] = 3; break;
				}
			}
			default: System.out.println("Error: corner inputted");
		}
		return pair;
	}
	
	//cube movements
	public void rotate(String rotation) {
		if(rotation.length() > 1) 
			counterclockwise(Basics.toInt(rotation.charAt(0)));
		else clockwise(Basics.toInt(rotation.charAt(0)));
	}
	public void clockwise(int side) {
		System.out.println("Rotate " + faceColours[side] + " face clockwise");
		
		//create a copy of cube
		int copy[][] = new int[6][9];
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 9; j++) {
				copy[i][j] = cube[i][j];
			}
		}
		
		//indicated side rotation
		for(int i = 0; i < 9-1; i++) {
			int switchNum = i+2;
			if(switchNum > 7) switchNum -= 8;
			cube[side][switchNum] = copy[side][i];
		}
		
		//side effects
		switch(side) {
			case 0: {
				cube[1][0] = copy[5][4];
				cube[1][7] = copy[5][3];
				cube[1][6] = copy[5][2];
				
				cube[2][0] = copy[1][0];
				cube[2][7] = copy[1][7];
				cube[2][6] = copy[1][6];
				
				cube[3][0] = copy[2][0];
				cube[3][7] = copy[2][7];
				cube[3][6] = copy[2][6];
				
				cube[5][2] = copy[3][6];
				cube[5][3] = copy[3][7];
				cube[5][4] = copy[3][0];
				
				break;
			}
			case 1: {
				cube[0][0] = copy[2][0];
				cube[0][1] = copy[2][1];
				cube[0][2] = copy[2][2];
				
				cube[2][0] = copy[4][0];
				cube[2][1] = copy[4][1];
				cube[2][2] = copy[4][2];
				
				cube[4][0] = copy[5][0];
				cube[4][1] = copy[5][1];
				cube[4][2] = copy[5][2];
				
				cube[5][0] = copy[0][0];
				cube[5][1] = copy[0][1];
				cube[5][2] = copy[0][2];
				
				break;
			}
			case 2: {
				cube[0][2] = copy[3][0];
				cube[0][3] = copy[3][1];
				cube[0][4] = copy[3][2];
				
				cube[1][4] = copy[0][2];
				cube[1][5] = copy[0][3];
				cube[1][6] = copy[0][4];

				cube[3][0] = copy[4][6];
				cube[3][1] = copy[4][7];
				cube[3][2] = copy[4][0];
				
				cube[4][6] = copy[1][4];
				cube[4][7] = copy[1][5];
				cube[4][0] = copy[1][6];
				
				break;
			}
			case 3: {
				cube[0][6] = copy[5][6];
				cube[0][5] = copy[5][5];
				cube[0][4] = copy[5][4];
				
				cube[2][6] = copy[0][6];
				cube[2][5] = copy[0][5];
				cube[2][4] = copy[0][4];
				
				cube[5][6] = copy[4][6];
				cube[5][5] = copy[4][5];
				cube[5][4] = copy[4][4];
				
				cube[4][6] = copy[2][6];
				cube[4][5] = copy[2][5];
				cube[4][4] = copy[2][4];
				
				break;				
			}
			case 4: {
				cube[1][2] = copy[2][2];
				cube[1][3] = copy[2][3];
				cube[1][4] = copy[2][4];
				
				cube[2][2] = copy[3][2];
				cube[2][3] = copy[3][3];
				cube[2][4] = copy[3][4];
				
				cube[3][2] = copy[5][6];
				cube[3][3] = copy[5][7];
				cube[3][4] = copy[5][0];
				
				cube[5][6] = copy[1][2];
				cube[5][7] = copy[1][3];
				cube[5][0] = copy[1][4];
				
				break;
			}
			case 5: {
				cube[0][6] = copy[1][0];
				cube[0][7] = copy[1][1];
				cube[0][0] = copy[1][2];
				
				cube[1][0] = copy[4][2];
				cube[1][1] = copy[4][3];
				cube[1][2] = copy[4][4];
				
				cube[3][4] = copy[0][6];
				cube[3][5] = copy[0][7];
				cube[3][6] = copy[0][0];
				
				cube[4][2] = copy[3][4];
				cube[4][3] = copy[3][5];
				cube[4][4] = copy[3][6];
				
				break;
			}
			default: {
				System.out.println("Error rotating " + getColorValue(side) + " clockwise");
			}
		}
		
	}
	public void counterclockwise(int side) {
		System.out.println("Rotate " + faceColours[side] + " face counterclockwise");
		
		//create a copy of cube
		int copy[][] = new int[6][9];
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 9; j++) {
				copy[i][j] = cube[i][j];
			}
		}
		
		//indicated side rotation
		for(int i = 0; i < 9-1; i++) {
			int switchNum = i+2;
			if(switchNum > 7) switchNum -= 8;
			cube[side][i] = copy[side][switchNum];
		}
		
		//side effects
		switch(side) {
			case 0: {
				cube[5][4] = copy[1][0];
				cube[5][3] = copy[1][7];
				cube[5][2] = copy[1][6];
				
				cube[1][0] = copy[2][0];
				cube[1][7] = copy[2][7];
				cube[1][6] = copy[2][6];
				
				cube[2][0] = copy[3][0];
				cube[2][7] = copy[3][7];
				cube[2][6] = copy[3][6];
				
				cube[3][6] = copy[5][2];
				cube[3][7] = copy[5][3];
				cube[3][0] = copy[5][4];
				
				break;
			}
			case 1: {
				cube[2][0] = copy[0][0];
				cube[2][1] = copy[0][1];
				cube[2][2] = copy[0][2];
				
				cube[0][0] = copy[5][0];
				cube[0][1] = copy[5][1];
				cube[0][2] = copy[5][2];
				
				cube[4][0] = copy[2][0];
				cube[4][1] = copy[2][1];
				cube[4][2] = copy[2][2];
				
				cube[5][0] = copy[4][0];
				cube[5][1] = copy[4][1];
				cube[5][2] = copy[4][2];
				
				break;
			}
			case 2: {
				cube[3][0] = copy[0][2];
				cube[3][1] = copy[0][3];
				cube[3][2] = copy[0][4];
				
				cube[0][2] = copy[1][4];
				cube[0][3] = copy[1][5];
				cube[0][4] = copy[1][6];
				
				cube[4][6] = copy[3][0];
				cube[4][7] = copy[3][1];
				cube[4][0] = copy[3][2];
				
				cube[1][4] = copy[4][6];
				cube[1][5] = copy[4][7];
				cube[1][6] = copy[4][0];
				
				break;
			}
			case 3: {
				cube[5][6] = copy[0][6];
				cube[5][5] = copy[0][5];
				cube[5][4] = copy[0][4];
				
				cube[0][6] = copy[2][6];
				cube[0][5] = copy[2][5];
				cube[0][4] = copy[2][4];
				
				cube[4][6] = copy[5][6];
				cube[4][5] = copy[5][5];
				cube[4][4] = copy[5][4];
				
				cube[2][6] = copy[4][6];
				cube[2][5] = copy[4][5];
				cube[2][4] = copy[4][4];
				
				break;				
			}
			case 4: {
				cube[2][2] = copy[1][2];
				cube[2][3] = copy[1][3];
				cube[2][4] = copy[1][4];
				
				cube[3][2] = copy[2][2];
				cube[3][3] = copy[2][3];
				cube[3][4] = copy[2][4];
				
				cube[5][6] = copy[3][2];
				cube[5][7] = copy[3][3];
				cube[5][0] = copy[3][4];
				
				cube[1][4] = copy[5][0];
				cube[1][3] = copy[5][7];
				cube[1][2] = copy[5][6];
				
				break;
			}
			case 5: {
				cube[3][4] = copy[4][2];
				cube[3][5] = copy[4][3];
				cube[3][6] = copy[4][4];
				
				cube[4][2] = copy[1][0];
				cube[4][3] = copy[1][1];
				cube[4][4] = copy[1][2];
				
				cube[1][0] = copy[0][6];
				cube[1][1] = copy[0][7];
				cube[1][2] = copy[0][0];
				
				cube[0][6] = copy[3][4];
				cube[0][7] = copy[3][5];
				cube[0][0] = copy[3][6];
				
				break;
			}
			default: {
				System.out.println("Error rotating " + getColorValue(side) + " counterclockwise");
			}
		}
	}
}
