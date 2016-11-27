import java.util.*;
import java.io.*;
public class Tricky {
    public static void main(String[] args) throws FileNotFoundException {
        // Before submitting, make sure the main method hasn't been changed!
        Scanner sc = new Scanner(new FileReader("testcases/TrickyIN.txt"));
        while(sc.hasNext()) {
            int length = sc.nextInt();
            Iterable<Integer> output = findTriples(length);
            String s = "[";
            boolean isFirstElement = true;
            for(Integer i : output) {
                if(isFirstElement) {
                    s += i;
                    isFirstElement = false;
                }
                else {
                    s += ", "+ i;
                }
            }
            s += "]";
            System.out.println(s);   
        }
        sc.close();
    }
    
    public static Iterable<Integer> findTriples(int hypotenuse) {
    	ArrayList<Integer> toReturn = new ArrayList<Integer>();
        for (int a = 1; a < hypotenuse; a++) {
        	for (int b = 1; b < a; b++) {
        		if (a*a+b*b==hypotenuse*hypotenuse) {
        			toReturn.add(a);
        			toReturn.add(b);
        		}
        	}
        }
        for (int k = 0; k < toReturn.size(); k++) {
        	toReturn.add(0, toReturn.get(k));
        	k++;
        }
        return toReturn;
    }
}
