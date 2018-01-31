package Asg3;

import java.io.*;
import java.util.*;
public class Question5 {
	//------------------------------------------------------------
	//Assignment: 3
	//File name: Question5.java
	//Written by: Aida Rohani ID 21341669, Edip Tac ID 26783287, Faezeh Mobasheri ID 26821022, Milan Jetha ID 40013982
	//For Comp 5511 Section DD/Fall 2017
	//------------------------------------------------------------

	/*---------------------------------PROGRAM DESCRIPTIONS---------------------------------------------------
	 * The program takes as an input a .txt file that contains names within it. As per the requirements for the
	 * question, the .txt file taken as the input is labelled "ds17s-asg2-data.txt". The program then converts
	 * this .txt file into an array and uses that array for the searching methods. Before any of the searching
	 * methods are implemented, the array containing the names is sorted using the selectionSort method since binary
	 * search requires an already sorted array. The sorted array is also used for the dictionary search since a 
	 * true comparison of two methods requires that the data sets be identical. Due to this, both of the search 
	 * methods are implemented on the already sorted array. From the results obtained, it can be seen that the
	 * binary search method is a much more efficient method of searching for the this specific set of data.
	 * The program runs both of the search methods using the keys provided in the question and outputs the 
	 * number of comparisons required to find the key, if it is present within the data set.
	 */


	/**
	 * @author Aida Rohani <ID 21341669>
	 * @author Edip Tac <ID 26783287>
	 * @author Faezeh Mobasheri <ID 26821022>
	 * @author Milan Jetha <ID 40013982>
	 * 
	 */	
	
//----------------------------------------------------------------------------------------	
	/*
	 * This program uses the standard binary search method by taking a key
	 * and comparing it to the middle of the array that contains the data.
	 * If the data does not match the mid-value, the search runs again but focuses
	 * on either the upper half (if key > mid-value) or the lower-half(if key < mid-value)
	 * and keeps dividing the list until the final key is found, or not found if its not there.
	 */
	public static int binarySearch(String[] str, String key){
		int nbOfComparisons = 0;
		int low = 0;
		int high = str.length -1;
		int middle;
		
		while ( high >= low){
			middle = (low + high) /2 ;
			if (str[middle].equalsIgnoreCase(key)){
				return nbOfComparisons;
			}
			// if the name at index middle of string is less than that of string key, it should return a negative number
			if (str[middle].compareTo(key) < 0){ // original is < 0
				low = middle +1;
				nbOfComparisons++;
			}
			// if the name at index middle of string is greater than that of string key, it should return a positive number
			if (str[middle].compareTo(key) > 0){ // original is >0
				high = middle - 1;
				nbOfComparisons++;
			}
		}
		//if the value is not present return false;
		return (-1);
	}
	
	/*
	 * The following code below takes the first letter of a key (a string) and searches
	 * through the text file provided to find the matches for the first characters. Once
	 * that search is complete, during the 2nd loop the program increases the number of
	 * characters it tries to matches with the names in the text file. That way, with each
	 * loop the number of characters that are compared increases by 1.
	 * Please note that DictionaryBasedSearch is extremely inefficient for this sort of
	 * application in comparison to the Binary Search. 
	 */
	public static void DictionaryBasedSearch (String [] arr, String key)
	{
		int startPosition = 0; 
		int counter = 0, i=0;
		boolean match = false;
		String char1, char2;
		
		while (i<key.length()) 
		{
			char1 = key.substring(0,(i+1));
			
			for (int j=startPosition; j<arr.length; j++)
			{				
				if ((i+1) <= arr[j].length()) 
				{
					char2 = arr[j].substring(0,(i+1));
					
					if(char2.compareTo(char1) < 0) 
					{
						startPosition++;
						counter++;
						continue;
					}
					else if (char2.compareTo(char1)==0)
					{
						if ((char2.length() == arr[j].length()) & (char2.length() == key.length()))
						{
							System.out.println(key + " is found in the list at index " + startPosition);
							match = true;
						}
						counter++;
						break;
					}
					else if (char2.compareTo(char1) > 0)
					{
						counter++;
						j=arr.length;
						break;
					}
				}
				else {
					startPosition++;
					continue;
				}	
			}
			
			i++;
		}
		
		if (match == false) {
			System.out.println(key+ ": Not found ");
		}
		
		System.out.println("Dictionary Search Comparison Count:  " + counter);
	}
	
	public static void main (String [] args) throws FileNotFoundException, IOException{
		
		/*
		 * The files that have been uploaded for this assignment contain the .txt file uploaded by Dr. Desai.
		 * However, if the marker would like to test the code using their own file please change the address 
		 * in the BufferedReader below to the correct address where your .txt file is stored.
		 */
		BufferedReader textFile = new BufferedReader(new FileReader("C:\\Users\\Edip\\workspace\\Comp5511Asg3\\src\\Asg3\\ds17s-asg2-data.txt"));
        String names;
        //adding names into and array list while it is read, it continues until 
        //there are no more names
        ArrayList<String> list = new ArrayList<>();
        while ((names = textFile.readLine()) != null) {
            list.add(names);
        }
        //creates 2 arrays, one for original data, others to be used for sorting classes
        ArrayList<String> ArrOD = list;
        ArrayList<String> ArrSS = ArrOD;
        
        //doing the selectionSort since binary search would not work on an unsorted set of data
        selectionSort selection = new selectionSort();
        selection.sort(ArrSS);
        String [] ArrString = ArrSS.toArray(new String[ArrSS.size()]);
        
        //this is done to remove all the blank spaces so that the text is compared accurately
        for (int i = 0; i < ArrString.length; i++) {
			ArrString[i] = ArrString[i].replaceAll("\\s", "");
		}
        
        
        
        //the keys required as per the question
        String[] keys = { "Azevedo, Ana", "Silva, Rui", "Boussebough, Imane", "Terracina, Giorgio", "Lefebvre, Peter",
				"Houghten, Sher", "Revesz, Peter" };
        //once again, we are removing all the blank spaces from the keys provided
        for (int i = 0; i < keys.length; i++) {
        	keys[i] = keys[i].replaceAll("\\s", "");
		}
        
        //this is to reflect the number of comparisons the binary search performs
		int nbComparisons;
		
		System.out.println("The searches for the keys using Binary Search are as follows:");
		for (int i = 0; i < keys.length; i++) {
			nbComparisons = binarySearch(ArrString, keys[i]);
			System.out.print("Number of comparisons to find the key " + keys[i] + " using binary search is :");
			if (nbComparisons == -1) {
				System.out.println("The key you have entered is not in the list.");
			} else {
				System.out.println(nbComparisons);
			}
		}
		System.out.println("\n \nThe searches for the keys using Dictionary Search are as follows:");
		for (int i = 0; i < keys.length; i++) {
			DictionaryBasedSearch(ArrString, keys[i]);
		}
        
	}
	
	
	
}
