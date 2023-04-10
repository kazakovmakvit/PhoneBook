import java.io.FileNotFoundException;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {

		Class_for_trow_exception c = new Class_for_trow_exception();
		

		System.out.println(Class_for_trow_exception.readLocalFile("src/fileInt.txt"));
		int[] race = null;
		Subtraction_array array = new Subtraction_array();
		int[] a = array.sub(new int[]{1,2,3,4,5},new int[]{5,4,3,2,1,});
		System.out.println(Arrays.toString(a));

		
		
		Division_elements_of_array div = new Division_elements_of_array();
		int[]com = null;
	
		
		double[] res = div.div(new int[]{4,6,8,10,16}, new int[]{2,2,2,2,2});

		
		System.out.println(Arrays.toString(res));

	}
	
	
	
}