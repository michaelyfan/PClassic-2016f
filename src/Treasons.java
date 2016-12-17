import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Treasons
{
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("testcases/TreasonsIN.txt"));
        int i=0;
        String[] input=new String[10000];
        while (sc.hasNext()) {
            input[i]=sc.next();
            i++;    
        }
        int counter=0;
        String[] input2=new String[i];
        while (counter<i){
            input2[counter]=input[counter];
            counter++;}
        String[] input20=new String[20];
        int counter2=0;
        for (int j=0; j<i;j++){
            if (!(input2[j].equals("|"))){
                input20[counter2]=input2[j];
                counter2++;
            }
            else{
                counter2=0;
                System.out.println(Arrays.toString(maximalAnagramList(input20)));
            }
        }
        sc.close();
    }
    /*The function will be given an array of distinct strings. The purpose of this method is to return
     * the largest set of strings which anagram to each other in an array with the strings in the 
     * output array being in alphabetical order.
       */
    public static String[] maximalAnagramList(String[] array) {
    	/*
    	 * 1) sort each word. store this new array of sorted words in a backup array
    	 * 2) sort the entire array of sorted words (the original, NOT the backup), anagrams will end up next to each other
    	 * 3) find the word of the largest row of words that are the same
    	 * 4) in the backup array, find all the indexes of the alphabetized anagram word
    	 * 5) return a string array of the original array(parameter)'s elements of #4's indexes, sorted
    	 */
    	// 1
    	String[] sortedWords = new String[array.length];
    	for (int k = 0 ; k < array.length; k++) {
    		sortedWords[k] = sortString(array[k]);
    	}
    	String[] backupSorted = Arrays.copyOf(sortedWords, sortedWords.length);
    	// 2
    	Arrays.sort(sortedWords);
    	// 3
    	TreeMap<Integer,String> counts = new TreeMap<Integer,String>();
    	String currentWord = sortedWords[0];
    	int count = 1;
    	for (int k = 1; k < sortedWords.length; k++) {
    		if (sortedWords[k].equals(currentWord)) {
    			count++;
    		}
    		else {
    			counts.put(count, currentWord);
    			currentWord = sortedWords[k];
    			count = 1;
    		}
    	}
    	counts.put(count, currentWord);
    	String keyWord = counts.get(counts.lastKey());
    	// 4
    	ArrayList<Integer> indexes = new ArrayList<Integer>();
    	for (int k = 0; k < backupSorted.length; k++) {
    		if (backupSorted[k].equals(keyWord)) {
    			indexes.add(k);
    		}
    	}
    	// 5
    	String[] toReturn = new String[indexes.size()];
    	for (int k = 0; k < indexes.size(); k++) {
    		toReturn[k] = array[indexes.get(k)];
    	}
    	Arrays.sort(toReturn);
    	return toReturn;
    }
    
    public static String sortString(String str) {
    	char[] temp = str.toCharArray();
    	Arrays.sort(temp);
    	return new String(temp);
    }
}
