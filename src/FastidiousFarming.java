import java.util.*;
import java.io.*;
public class FastidiousFarming {
  public static void main(String[] args) throws FileNotFoundException {
    // Before submitting, make sure the main method hasn't been changed!
    Scanner sc = new Scanner(new FileReader("testcases/FastidiousFarmingIN.txt"));
    while(sc.hasNext()) {
      int[] cropAInputs = new int[2];
      int[] cropBInputs = new int[2];
      int[] allowanceInputs = new int[2];

      String cropALine = sc.nextLine();
      String[] cropAStringInputs = cropALine.split(" ");
      cropAInputs[0] = Integer.parseInt(cropAStringInputs[0]);
      cropAInputs[1] = Integer.parseInt(cropAStringInputs[1]);

      String cropBLine = sc.nextLine();
      String[] cropBStringInputs = cropBLine.split(" ");
      cropBInputs[0] = Integer.parseInt(cropBStringInputs[0]);
      cropBInputs[1] = Integer.parseInt(cropBStringInputs[1]);

      String allowanceLine = sc.nextLine();
      String[] allowanceStringInputs = allowanceLine.split(" ");
      allowanceInputs[0] = Integer.parseInt(allowanceStringInputs[0]);
      allowanceInputs[1] = Integer.parseInt(allowanceStringInputs[1]);

      int[] answer = findCrops(cropAInputs,cropBInputs,allowanceInputs);
      System.out.println(answer[0] + " " + answer[1]);
    }
    sc.close();
  }
  
  // Fill out the body of this method
  // cropAInputs and cropBInputs specify the amount of water and labor required by crop
  // A and B respectively. allowanceInputs specifies the amount of water and labor you have
  // available. You should return an int array of size 2 containing the amount of crop A and B
  // you should grow in that order or [ -1, -1 ] if there aren't any amounts that satisfy the
  // requirements
  
  /*
   * For a two-variable systems, an equation for x and an equation for y can be derived
   */
  public static int[] findCrops(int[] cropAInputs, int[] cropBInputs, int[] allowanceInputs) {
	  double a = cropAInputs[0];
	  double b = cropBInputs[0];
	  double p = allowanceInputs[0];
	  double c = cropAInputs[1];
	  double d = cropBInputs[1];
	  double q = allowanceInputs[1];
	  

	  double y = (q-(c*p/a))/(d-(c*b/a));
	  double x = (p-b*y)/a;

	  
	  
	  if (x % 1 == 0 && y % 1 == 0) {
		  int[] toReturn = {(int)x,(int)y};
		  return toReturn;
	  }
	  else {
		  int[] toReturn = {-1,-1};
		  return toReturn;
	  }
  }

}
