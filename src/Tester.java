import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;



public class Tester {

	public static void main(String[] args) {
		System.out.println(sortString("fjoeafweah"));
		
		
	}
	public static String sortString(String str) {
    	char[] temp = str.toCharArray();
    	Arrays.sort(temp);
    	return new String(temp);
    }


}
