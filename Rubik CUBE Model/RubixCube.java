import java.util.Random;
class RubixCube implements RubixCubeInterface{

	private Surface[] SIDES = new Surface[6];

	private RubixCube(){
		SIDES[0] = Surface.getSurface(Color.WHITE);			// FRONT 		[ 0 ] 
		SIDES[1] = Surface.getSurface(Color.YELLOW);		// BACK 		[ 1 ]
		SIDES[2] = Surface.getSurface(Color.RED);			// LEFT 		[ 2 ]
		SIDES[3] = Surface.getSurface(Color.ORANGE);		// RIGHT 		[ 3 ]
		SIDES[4] = Surface.getSurface(Color.GREEN);			// TOP 			[ 4 ]
		SIDES[5] = Surface.getSurface(Color.BLUE);			// BOTTOM 		[ 5 ]
	}

	public static RubixCubeInterface getCube(){
		RubixCube cube = new RubixCube();
		return (RubixCubeInterface)cube;
	}

	public enum Color {
		RED,
		BLUE,
		GREEN,
		WHITE,
		YELLOW,
		ORANGE
	}

	private static class Surface{

		char [][] area = new char[3][3];

		// Making the Constructor Private...
		private Surface(){}

		private Surface(Color c){
			for ( int i = 0 ; i < area.length ; i++ ){
				for ( int j = 0 ; j < area[i].length ; j++ ){
					area[i][j] = getCharEquivalent(c);
				}
			}
		}

		private char getCharEquivalent(Color c){

			switch (c) {
				case RED:
					return 'R';
				case BLUE:
					return 'B';
				case GREEN:
					return 'G';
				case WHITE:
					return 'W';
				case YELLOW:
					return 'Y';
				case ORANGE:
					return 'O';
				default:
					return 'X';
			}
		}

		public static Surface getSurface(Color c){
			return new Surface(c);
		}

		public char[] getRow(int row_no){
			return area[row_no].clone();
		}
		public char[] getCol(int col_no){
			char[] col = new char[area.length];
			for( int i = 0 ; i < area.length ; i++ ){
				col[i] = area[i][col_no];
			}
			return col;
		}
		public void setRow(char[] row, int row_no, boolean fill_reverse){
			char[] tuple;	// Creating Row Reference...
			if(!fill_reverse){
				tuple = row;
			}else{
				tuple = reverse(row);
			}
			area[row_no] = tuple;
		}
		public void setCol(char[] col, int col_no, boolean fill_reverse){
			char[] column;	// Creating Column Reference...
			// If fill reverse not true...
			if(!fill_reverse){
				column = col;
			}else{
				column = reverse(col);
			}
			// Start filling...
			for( int i = 0 ; i < column.length ; i++ ){
				area[i][col_no] = column[i];
			}
		}

		public char[] reverse(char[] arr){	
			char[] rev_arr = new char[arr.length];
			for( int i = 0 ; i < arr.length ; i++ ){
				rev_arr[i] = arr[(arr.length-1)-i];
			}
			return rev_arr;
		}

		public boolean isSolved(){
			outer_most:
			for( int i = 0 ; i < area.length ; i++ ){
				outer:
				for( int j = 0 ; j < area[i].length ; j++){
					char col_1 = area[i][j];
					inner:
					for( int k = 0 ; k < area.length; k++ ){
						inner_most:
						for(int l = 0 ; l < area[i].length ; l++){
							if(i == k && j == l)
								continue inner_most;	// Skip that step...
							char col_2 = area[k][l];
							if(col_1 != col_2)
								return false;
						}
					}
				}
			}
			return true;
		}

		public String toString(){
			String s = "";
			for ( int i = 0 ; i < area.length ; i++ ) {
				for ( int j = 0; j < area[i].length ; j++) {
					s += Character.toString(area[i][j]) + "  ";
				}
				s += "\n";
			}
			return s;
		}

	}	// End of Surface Class...

	public void rotateFront(boolean inverse){
		// If not inverse...
		if(!inverse){	// Spin Clockwise...

			char[] row_1 = SIDES[0].getRow(0);
			char[] row_2 = SIDES[0].getRow(1);
			char[] row_3 = SIDES[0].getRow(2);

			SIDES[0].setCol(row_3, 0, false);
			SIDES[0].setCol(row_2, 1, false);
			SIDES[0].setCol(row_1, 2, false);


			char[] top_row = SIDES[4].getRow(2);
			char[] left_col = SIDES[2].getRow(2);
			char[] down_row = SIDES[5].getRow(0);
			char[] right_col = SIDES[3].getRow(0);

			SIDES[3].setCol(top_row,0,false);	
			SIDES[4].setRow(left_col,2,true);	
			SIDES[2].setCol(down_row,2,false);
			SIDES[5].setRow(right_col,0,true);	



		}else{		// Spin Counter Clockwise...

			char[] row_1 = SIDES[0].getRow(0);
			char[] row_2 = SIDES[0].getRow(1);
			char[] row_3 = SIDES[0].getRow(2);

			SIDES[0].setCol(row_3, 0, true);
			SIDES[0].setCol(row_2, 1, true);
			SIDES[0].setCol(row_1, 2, true);


			char[] top_row = SIDES[4].getRow(2);
			char[] left_col = SIDES[2].getRow(2);
			char[] down_row = SIDES[5].getRow(0);
			char[] right_col = SIDES[3].getRow(0);

			SIDES[2].setCol(top_row,2,true);	
			SIDES[5].setRow(left_col,0,false);	
			SIDES[3].setCol(down_row,0,true);
			SIDES[4].setRow(right_col,2,false);	

		}
	}
	public void rotateBack(boolean inverse){
		// If not inverse...
		if(!inverse){	// Spin Clockwise...

			char[] row_1 = SIDES[1].getRow(0);
			char[] row_2 = SIDES[1].getRow(1);
			char[] row_3 = SIDES[1].getRow(2);

			SIDES[1].setCol(row_3, 0, false);
			SIDES[1].setCol(row_2, 1, false);
			SIDES[1].setCol(row_1, 2, false);


			char[] top_row = SIDES[4].getRow(0);
			char[] left_col = SIDES[2].getCol(0);
			char[] down_row = SIDES[5].getRow(2);
			char[] right_col = SIDES[3].getCol(2);

			SIDES[2].setCol(top_row,0,false);	 
			SIDES[5].setRow(left_col,2,true);	 
			SIDES[3].setCol(down_row,2,false);	 
			SIDES[4].setRow(right_col,0,true);	



		}else{		// Spin Counter Clockwise...

			char[] row_1 = SIDES[1].getRow(0);
			char[] row_2 = SIDES[1].getRow(1);
			char[] row_3 = SIDES[1].getRow(2);

			SIDES[1].setCol(row_3, 0, true);
			SIDES[1].setCol(row_2, 1, true);
			SIDES[1].setCol(row_1, 2, true);


			char[] top_row = SIDES[4].getRow(0);
			char[] left_col = SIDES[2].getCol(0);
			char[] down_row = SIDES[5].getRow(2);
			char[] right_col = SIDES[3].getCol(2);

			SIDES[3].setCol(top_row,2,false);	 
			SIDES[4].setRow(left_col,0,true);	 
			SIDES[2].setCol(down_row,0,false);	 
			SIDES[5].setRow(right_col,2,true);	

		}

	}
	//             ------------ok-------------------
	public void rotateLeft(boolean inverse){
		// If not inverse...
		if(!inverse){	// Spin Clockwise...

			char[] row_1 = SIDES[2].getRow(0);
			char[] row_2 = SIDES[2].getRow(1);
			char[] row_3 = SIDES[2].getRow(2);

			SIDES[2].setCol(row_3, 0, false);
			SIDES[2].setCol(row_2, 1, false);
			SIDES[2].setCol(row_1, 2, false);


			char[] top_col = SIDES[4].getCol(0);
			char[] front_col = SIDES[0].getCol(0);
			char[] back_col = SIDES[1].getCol(2);
			char[] down_col = SIDES[5].getCol(0);

			SIDES[0].setCol(top_col,0,false);	
			SIDES[5].setCol(front_col,0,false);	
			SIDES[4].setCol(back_col,0,true);	
			SIDES[1].setCol(down_col,0,true);	



		}else{		// Spin Counter Clockwise...

			char[] row_1 = SIDES[2].getRow(0);
			char[] row_2 = SIDES[2].getRow(1);
			char[] row_3 = SIDES[2].getRow(2);

			SIDES[2].setCol(row_3, 0, true);
			SIDES[2].setCol(row_2, 1, true);
			SIDES[2].setCol(row_1, 2, true);


			char[] top_col = SIDES[4].getCol(0);
			char[] front_col = SIDES[0].getCol(0);
			char[] back_col = SIDES[1].getCol(2);
			char[] down_col = SIDES[5].getCol(0);

			SIDES[1].setCol(top_col,2,true);	
			SIDES[4].setCol(front_col,0,false);	
			SIDES[5].setCol(back_col,0,true);	
			SIDES[0].setCol(down_col,0,false);	

		}

	}
	//  ---- ok--------
	public void rotateRight(boolean inverse){
		// If not inverse...
		if(!inverse){	// Spin Clockwise...

			char[] row_1 = SIDES[3].getRow(0);
			char[] row_2 = SIDES[3].getRow(1);
			char[] row_3 = SIDES[3].getRow(2);

			SIDES[3].setCol(row_3, 0, false);
			SIDES[3].setCol(row_2, 1, false);
			SIDES[3].setCol(row_1, 2, false);


			char[] top_col = SIDES[4].getCol(2);
			char[] front_col = SIDES[0].getCol(2);
			char[] back_col = SIDES[1].getCol(0);
			char[] down_col = SIDES[5].getCol(2);

			SIDES[1].setCol(top_col,0,true);	
			SIDES[4].setCol(front_col,0,false);	
			SIDES[5].setCol(back_col,2,true);	
			SIDES[0].setCol(down_col,2,false);	



		}else{		// Spin Counter Clockwise...

			char[] row_1 = SIDES[3].getRow(0);
			char[] row_2 = SIDES[3].getRow(1);
			char[] row_3 = SIDES[3].getRow(2);

			SIDES[3].setCol(row_3, 0, true);
			SIDES[3].setCol(row_2, 1, true);
			SIDES[3].setCol(row_1, 2, true);


			char[] top_col = SIDES[4].getCol(2);
			char[] front_col = SIDES[0].getCol(2);
			char[] back_col = SIDES[1].getCol(0);
			char[] down_col = SIDES[5].getCol(2);

			SIDES[0].setCol(top_col,2,false);	
			SIDES[5].setCol(front_col,2,false);	
			SIDES[4].setCol(back_col,2,true);	
			SIDES[1].setCol(down_col,0,true);	

		}

	}

	//---------ok------------
	public void rotateTop(boolean inverse){
		// If not inverse...
		if(!inverse){	// Spin Clockwise...

			char[] row_1 = SIDES[4].getRow(0);
			char[] row_2 = SIDES[4].getRow(1);
			char[] row_3 = SIDES[4].getRow(2);

			SIDES[4].setCol(row_3, 0, false);
			SIDES[4].setCol(row_2, 1, false);
			SIDES[4].setCol(row_1, 2, false);


			char[] front_row = SIDES[0].getRow(0);
			char[] right_row = SIDES[3].getRow(0);
			char[] back_row = SIDES[1].getRow(0);
			char[] left_row = SIDES[2].getRow(0);

			SIDES[2].setRow(front_row,0,false);	
			SIDES[0].setRow(right_row,0,false);	
			SIDES[3].setRow(back_row,0,false);	
			SIDES[1].setRow(left_row,0,false);	



		}else{		// Spin Counter Clockwise...

			char[] row_1 = SIDES[4].getRow(0);
			char[] row_2 = SIDES[4].getRow(1);
			char[] row_3 = SIDES[4].getRow(2);

			SIDES[4].setCol(row_3, 0, true);
			SIDES[4].setCol(row_2, 1, true);
			SIDES[4].setCol(row_1, 2, true);


			char[] front_row = SIDES[0].getRow(0);
			char[] right_row = SIDES[3].getRow(0);
			char[] back_row = SIDES[1].getRow(0);
			char[] left_row = SIDES[2].getRow(0);

			SIDES[3].setRow(front_row,0,false);	
			SIDES[1].setRow(right_row,0,false);	
			SIDES[2].setRow(back_row,0,false);	
			SIDES[0].setRow(left_row,0,false);	

		}

	}
	public void rotateDown(boolean inverse){
		// If not inverse...
		if(!inverse){	// Spin Clockwise...

			char[] row_1 = SIDES[5].getRow(0);
			char[] row_2 = SIDES[5].getRow(1);
			char[] row_3 = SIDES[5].getRow(2);

			SIDES[5].setCol(row_3, 0, false);
			SIDES[5].setCol(row_2, 1, false);
			SIDES[5].setCol(row_1, 2, false);


			char[] front_row = SIDES[0].getRow(2);
			char[] right_row = SIDES[3].getRow(2);
			char[] back_row = SIDES[1].getRow(2);
			char[] left_row = SIDES[2].getRow(2);

			SIDES[3].setRow(front_row,2,false);	
			SIDES[1].setRow(right_row,2,false);	
			SIDES[2].setRow(back_row,2,false);	
			SIDES[0].setRow(left_row,2,false);	



		}else{		// Spin Counter Clockwise...

			char[] row_1 = SIDES[5].getRow(0);
			char[] row_2 = SIDES[5].getRow(1);
			char[] row_3 = SIDES[5].getRow(2);

			SIDES[5].setCol(row_3, 0, false);
			SIDES[5].setCol(row_2, 1, false);
			SIDES[5].setCol(row_1, 2, false);


			char[] front_row = SIDES[0].getRow(2);
			char[] right_row = SIDES[3].getRow(2);
			char[] back_row = SIDES[1].getRow(2);
			char[] left_row = SIDES[2].getRow(2);

			SIDES[2].setRow(front_row,2,false);	
			SIDES[0].setRow(right_row,2,false);	
			SIDES[3].setRow(back_row,2,false);	
			SIDES[1].setRow(left_row,2,false);	

		}

	}	

	public void scramble(){		//Default Scrambling rate will be 30 times...
		scramble(30);
	}
	public void scramble(int times){
		Random ran_gen = new Random();
		for( int i = 0 ; i < times ; i++){
			int rotation_type = ran_gen.nextInt(6);
			boolean invert = ran_gen.nextBoolean();
			switch (rotation_type){
				case 0:
					rotateFront(invert);
					break;
				case 1:
					rotateBack(invert);
					break;
				case 2:
					rotateTop(invert);
					break;
				case 3:
					rotateDown(invert);
					break;
				case 4:
					rotateLeft(invert);
					break;
				case 5:
					rotateRight(invert);
					break;
			}
		}
	}

	public boolean isSolved(){		// Check All Sides to Solve...

		for(Surface s : SIDES){
			if(!s.isSolved())
				return false;
		}
		return true;
	}


	public String toString(){
		String s = "";
		for ( int i = 0 ; i < SIDES.length ; i++ ) {
			s += SIDES[i].toString();
			s += "--------\n";
		}
		return s;
	}
	
	public static void print(char[] arr){
		for( int i = 0 ; i < arr.length ; i++ ){
			System.out.print(Character.toString(arr[i])+" ");
		}
		System.out.println();
	}

}
