import java.util.Random;
public class Test{
	public static void main(String[] args){
		/*
			CUBE Description:
				6 SIDES... [ FRONT, BACK, LEFT, RIGHT, TOP, DOWN ]
				Each side has 9 pieces...

				DEFAULT COLORS SCHEME( You can change the color Scheme by Editing the Code ):
					FRONT 	|	WHITE
					BACK 	|	YELLOW
					LEFT 	|	RED
					RIGHT 	|	ORANGE
					TOP 	|	GREEN
					DOWN 	|	BLUE

		*/


		// Getting the Rubix Cube Interface from the Rubix Cube Class....
		RubixCubeInterface cube = RubixCube.getCube();
		// Checking either the CUBE is in solved state or not. (On Getting CUBE it will be in solved state)
		System.out.println("Is Already Solved: "+cube.isSolved());

		// *** Un Comment this to Check either the cube is rotating or not! ***
		// boolean anti_clockwise = false;
		// It will rotate the CUBE's Front in clockwise direction...
		// rotateFront(anti_clockwise);	
		// It will rotate the CUBE's Back in clockwise direction...
		// rotateBack(anti_clockwise);
		// It will rotate the CUBE's Left in clockwise direction...
		// rotateLeft(anti_clockwise);
		// anti_clockwise = true;
		// It will rotate the CUBE's Right in anti-clockwise direction...
		// rotateRight(anti_clockwise);
		// It will rotate the CUBE's Top in anti-clockwise direction...
		// rotateTop(anti_clockwise);
		// It will rotate the CUBE's Down in anti-clockwise direction...
		// rotateDown(anti_clockwise);

		// printing the cube state... 
		System.out.println(cube);
		System.out.println("Scrambling the CUBE...");
		// Scrambling the Cube...
		cube.scramble();
		System.out.println("After Scrambled is Solved: "+cube.isSolved());
		// Printing the cube states... again...
		System.out.println(cube);


	}
}