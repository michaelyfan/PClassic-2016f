import java.util.*;
import java.io.*;


public class SudokuSolver {
	
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("SudokuSolverIN.txt"));
        
        int[][] puzzle = new int[9][9];
        
        while(sc.hasNext()) {
        	for(int i = 0; i < 9; i++) {
        		for(int j = 0; j < 9; j++) {
        			puzzle[i][j] = sc.nextInt();
        		}
        	}
        	
        	puzzle = sudokuSolve(puzzle);
        	
        	for(int i = 0; i < 9; i++) {
        		for(int j = 0; j < 9; j++) {
        			if(j < 8) {
        				System.out.print(puzzle[i][j] + " ");
        			} else {
        				System.out.println(puzzle[i][j] + " ");
        			}
        		}
        	}
        	
        	System.out.println("");
        	
        }
    }
    
    
    public static int[][] sudokuSolve(int[][] puzzle) {

    	ArrayList<int[]> empties = new ArrayList<int[]>(); 
    	for (int k = 0; k < puzzle.length; k++) {
    		for (int j = 0; j < puzzle[k].length; j++) {
    			if (puzzle[k][j] == 0) {
    				int[] x = {k,j};
    				empties.add(x);
    			}
    		}
    	}
    
    	ArrayList<ArrayList<Integer>> possibleNums = new ArrayList<ArrayList<Integer>>();
    	for (int k = 0; k < empties.size(); k++) {
    		ArrayList<Integer> temp = new ArrayList<Integer>();
    		temp.add(-1);
    		possibleNums.add(temp);
    	}
    	
    	return ssr(puzzle,empties,0,possibleNums);
    }
    
    public static int[][] ssr(int[][] puzzle, ArrayList<int[]> empties, int curr, ArrayList<ArrayList<Integer>> possibleNums) {
    	if (curr == empties.size()) {
    		return puzzle;
    	}
    	
    	if (possibleNums.get(curr).size() > 0 && possibleNums.get(curr).get(0) == -1) { //not filled yet
    		puzzle[empties.get(curr)[0]][empties.get(curr)[1]] = 0;
    		possibleNums.set(curr,getPossibleNums(puzzle,empties.get(curr)));
    	}
    	//possibleNums.set(curr,getPossibleNums(puzzle,empties.get(curr)));
    	ArrayList<Integer> currentPossibleNums = possibleNums.get(curr);
    	
    	if (possibleNums.get(curr).size() == 0) {
    		ArrayList<Integer> negativeOne = new ArrayList<Integer>();
    		negativeOne.add(-1);
    		possibleNums.set(curr,negativeOne);
    		
    		return ssr(puzzle,empties,curr-1,possibleNums);
    	}
    	int numberToPutIntoPuzzle = possibleNums.get(curr).get(0);
    	possibleNums.get(curr).remove(0);
    	puzzle[empties.get(curr)[0]][empties.get(curr)[1]] = numberToPutIntoPuzzle;
    	return ssr(puzzle,empties,curr+1,possibleNums);

    }
    
    public static ArrayList<Integer> getPossibleNums(int[][] puzzle, int[] point) {
    	ArrayList<Integer> toReturn = new ArrayList<Integer>();
    	for (int k = 1; k <= 9; k++) {
    		toReturn.add(k);
    	}
    	for (int k = 0; k < 9; k++) {
    		if (toReturn.contains(puzzle[k][point[1]])) {
    			toReturn.remove(toReturn.indexOf(puzzle[k][point[1]]));
    		}
    	}
    	for (int k = 0; k < 9; k++) {
    		if (toReturn.contains( puzzle[point[0]][k] )) {
    			toReturn.remove(toReturn.indexOf( puzzle[point[0]][k] ));
    		}
    	}
    	int blockrow = point[0]/3, blockcol = point[1]/3;
    	for (int k = blockrow*3; k < blockrow*3 + 3; k++) {
    		for (int j = blockcol*3; j < blockcol*3 + 3; j++) {
    			if (toReturn.contains(puzzle[k][j])) {
    				toReturn.remove(toReturn.indexOf(puzzle[k][j]));
    			}
    		}
    	}
    	return toReturn;
    }
    
}
