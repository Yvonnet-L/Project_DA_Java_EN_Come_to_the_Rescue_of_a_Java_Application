package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import com.hemebiotech.analytics.count.CountSymptoms;
import com.hemebiotech.analytics.count.ISymptomsCount;
import com.hemebiotech.analytics.reader.ISymptomReader;
import com.hemebiotech.analytics.reader.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.sort.ISymptomSort;
import com.hemebiotech.analytics.sort.SortSymptoms;
import com.hemebiotech.analytics.writer.ISympWriter;
import com.hemebiotech.analytics.writer.WriteSympOutTxt;
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

	public static void main(String[] args) throws IOException {
		/**
		 *  initiation of the file address
		 */	
		//String stringfile = "symptoms.txt";	
		/**
		 * choice of  file.txt
		*  with the FileChooser class
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
				ISymptomSort  sympsorter= new SortSymptoms();
				symptomsOrdered = sympsorter.symptomsOrdered(resultL); 
		/** 
		 * 3/4 Classe : CountSymptoms	
		 * git status
		 * Sends the list to CoutSymp for creation of the list with the number of occurrences				
		 */
				Map<String, Integer> symptomsOccurrences ;
				ISymptomsCount sympCounter= new CountSymptoms();		
				symptomsOccurrences = sympCounter.count(symptomsOrdered,resultL);		
		/**
		 *  4/4 Classe : WriteSymptoms	
		 *  
		 *  Calls class to create the text file
		 *  2 Write car 2 manières de faire differentes à voir laquelle on garde !
		 */
				ISympWriter writeOut = new WriteSympOutTxt();
				writeOut.writerResults(symptomsOccurrences);
				System.out.println(  "        ---> End  <-- ");
			} else {
			System.out.println("File not selected, processing not performed!");
		}
	}
}
