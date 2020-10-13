package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Occurs;

/**
 * 	 This program retrieves a list of data from the symptoms.txt file,
*    to process them and output them in a resultsout.txt file 
*    classified in alphabetical order with the number of occurrences.
*    There are 4 steps in the main: Read, Sort, Cout and write.
*    each step calls a class.
 * @author ptiqu
 *
 */
public class DevMain1 {

	public static void main(String[] args) {
	
		/**
		 *  initiation of the file address
		 */
		String stringfile = "c://Users/ptiqu/git/sourceP2/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/symptoms.txt";	
		
		/**
		*  1/4 Classe : ReadSymptomDataFromFile
		*
		*	ReadSymptomDataFromFile retrieving the list of data from the text file
		*/
		ReadSymptomDataFromFile rsymp = new ReadSymptomDataFromFile(stringfile);
		List<String> resultL = rsymp.getSymptoms();
		
		/**
		 *  2/4 Classe : SortSymptoms		
		 */	
		SortSymptoms.sortlst(resultL); 	
		
		/** 
		 * 3/4 Classe : CountSymptoms	
		 * 
		 * Sends the list to CoutSymp for creation of the hashlist with the number of occurrences				
		 */
		CountSymptoms count1 = new CountSymptoms(resultL);	
		Map<String, Integer> occurR = count1.Count(resultL);
		
		/**
		 *  4/4 Classe : WriteSymptoms	
		 *  
		 *  Calls class to create the text file
		 */
		WriteSympOutTxt writeOut = new WriteSympOutTxt();
		writeOut.outMlst(occurR);
		System.out.println(  "           ---> End  <-- ");

	}
}
