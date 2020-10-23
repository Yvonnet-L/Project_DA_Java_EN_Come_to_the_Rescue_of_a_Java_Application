package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import com.hemebiotech.analytics.count.CountSymptoms;
import com.hemebiotech.analytics.count.ISymptomsCounter;
import com.hemebiotech.analytics.read.ISymptomReader;
import com.hemebiotech.analytics.read.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.sort.ISymptomSorter;
import com.hemebiotech.analytics.sort.SortSymptoms;
import com.hemebiotech.analytics.write.ISympWriter;
import com.hemebiotech.analytics.write.WriteSympOutTxt;

/**
 * 	 This program retrieves a list of data from the symptoms.txt file,
 *    to process them and output them in a resultsout.txt file 
 *    classified in alphabetical order with the number of occurrences.
 *    There are 4 steps in the main: Read, Sort, Cout and write.
 *    each step calls a class.
 * @author Laurent Y.
 *
 */
public class Main {  

	public static void main(String[] args) {
		/**
		 *  initiation of the file address
		 *  choice of file.txt with the FileChooser class
		 */
				String stringfile = null;
				FileChooser fc = new FileChooser();	
				stringfile = fc.chooserFile();
		/**
		 * return with the address of the file starting the processing
		 */	
			if (stringfile!=null) {		
		/**
		*  1/4 Classe : ReadSymptomDataFromFile
		*
		*	ReadSymptomDataFromFile retrieving the list of data from the text file
		*/
				ISymptomReader rsymp = new ReadSymptomDataFromFile(stringfile);
				List<String> resultL = rsymp.getSymptoms();	
		/**
		 *  2/4 Classe : SortSymptoms		
		 */	
				Set <String> symptomsOrdered = new TreeSet<>(); 
				ISymptomSorter  sympsorter= new SortSymptoms();
				symptomsOrdered = sympsorter.symptomsOrdered(resultL); 
		/** 
		 * 3/4 Classe : CountSymptoms	
		 * 
		 * Sends the list to CoutSymp for creation of the list with the number of occurrences				
		 */
				Map<String, Integer> symptomsOccurrences ;
				ISymptomsCounter sympCounter= new CountSymptoms();		
				symptomsOccurrences = sympCounter.count(symptomsOrdered,resultL);		
		/**
		 *  4/4 Classe : WriteSymptoms	
		 *  
		 *  Calls class to create the text file
		 */
				ISympWriter writeOut = new WriteSympOutTxt();
				writeOut.writerResults(symptomsOccurrences);
				System.out.println(  "        --->  End  <-- ");
			} else {
			System.out.println("File not selected, processing not performed!");
		}
	}
}
