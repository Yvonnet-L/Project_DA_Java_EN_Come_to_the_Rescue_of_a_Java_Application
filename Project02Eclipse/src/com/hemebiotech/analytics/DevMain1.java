package com.hemebiotech.analytics;

import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import com.hemebiotech.analytics.count.CountSymptoms;
import com.hemebiotech.analytics.reader.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.sort.SortSymptoms;
import com.hemebiotech.analytics.writer.WriteSympOut2Txt;
import com.hemebiotech.analytics.writer.WriteSympOutTxt;

/**
 * 	 This program retrieves a list of data from the symptoms.txt file,
*    to process them and output them in a resultsout.txt file 
*    classified in alphabetical order with the number of occurrences.
*    There are 4 steps in the main: Read, Sort, Cout and write.
*    each step calls a class.
 * @author Laurent Y.
 *
 */
public class DevMain1 {

	public static void main(String[] args) {
		/**
		 *  initiation of the file address
		 */	
		String stringfile = "symptoms.txt";	
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
			Set <String> symptomsOrdered = new TreeSet<>();
			symptomsOrdered = SortSymptoms.ordererSymptoms(resultL);
		/** 
		 * 3/4 Classe : CountSymptoms	
		 * 
		 * Sends the list to CoutSymp for creation of the list with the number of occurrences				
		 */
		TreeMap<String, Integer> symptomsOccurrences = CountSymptoms.Count(symptomsOrdered, resultL);
;
		/**
		 *  4/4 Classe : WriteSymptoms	
		 *  
		 *  Calls class to create the text file
		 */
		WriteSympOutTxt writeOut = new WriteSympOutTxt();
		WriteSympOut2Txt writeOut2 = new WriteSympOut2Txt();
		writeOut.writerResults(symptomsOccurrences);
		writeOut2.writerResults(symptomsOccurrences);	
		System.out.println(  "           ---> End  <-- ");

	}
}
