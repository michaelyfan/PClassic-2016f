import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;



public class Tester {

	public static void main(String[] args) {
		int[] x = {1,2,5,2,1,6};
		int[] y = Arrays.copyOf(x, x.length);
		x[3] = 0;
		System.out.println(Arrays.toString(x));
		System.out.println(Arrays.toString(y));
	}
	
	public static String sortString(String str) {
    	char[] temp = str.toCharArray();
    	Arrays.sort(temp);
    	return new String(temp);
    }


}
