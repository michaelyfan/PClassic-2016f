import java.util.*;
import java.io.*;
public class Tricky {
    public static void main(String[] args) throws FileNotFoundException {
        // Before submitting, make sure the main method hasn't been changed!
        Scanner sc = new Scanner(new FileReader("TrickyIN.txt"));
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
        Iterable<Integer> list = new ArrayList<Integer>();
        Iterable<Integer> list2 = new ArrayList<Integer>();
        for(int i=3; i<hypotenuse/Math.sqrt(2); i++)
        {
         int x = (int) Math.sqrt(Math.pow(hypotenuse, 2)-Math.pow(i, 2));
         	if(Math.pow(x, 2)+Math.pow(i, 2)==Math.pow(hypotenuse, 2))
         	{
         		((ArrayList<Integer>) list).add(i);
         		((ArrayList<Integer>) list).add(x);
         		((ArrayList<Integer>) list2).add(0, i);
         		((ArrayList<Integer>) list2).add(0, x);
         	}
        }
        Iterable<Integer> finalList = new ArrayList<Integer>();
        for (int i=0; i<((ArrayList<Integer>) list).size(); i++)
        {
        	((ArrayList<Integer>) finalList).add(((ArrayList<Integer>) list).get(i));
        }
        for (int i=0; i<((ArrayList<Integer>) list2).size(); i++)
        {
        	((ArrayList<Integer>) finalList).add(((ArrayList<Integer>) list2).get(i));
        }
        return finalList;
    }
}
