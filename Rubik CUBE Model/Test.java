public class Test{
	public static void main(String[] args){

		char[] arr = new char[]{'a','b','c','d','e','f','g'};

		print(arr);

		char[] rev = reverse(arr);

		print(rev);


	}
	public static void print(char[] arr){
		for( int i = 0 ; i < arr.length ; i++ ){
			System.out.print(Character.toString(arr[i])+" ");
		}
	}
	public static char[] reverse(char[] arr){
		char[] rev_arr = new char[arr.length];
		for( int i = 0 ; i < arr.length ; i++ ){
			rev_arr[i] = arr[(arr.length-1)-i];
		}
		return rev_arr;
	}	
}