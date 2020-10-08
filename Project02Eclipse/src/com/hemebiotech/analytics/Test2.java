package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Test2 {
	
	public static void main(String[] args) throws IOException {
		
		File file = new File("c://Users/ptiqu/git/sourceP2/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/symptoms.txt");
			
		// Initialize the Occurences HashMap
		Map<String, Integer> occurrences = new HashMap<>();
		
		// test to verify the existence of the file
			if(file.exists())
				{
				System.out.println("symptom.txt exists!");
				
			// initialize the Buffer to use the file
				BufferedReader readerSymptom = new BufferedReader (new FileReader(file));		
				String line = readerSymptom.readLine();
				
			// We browse each line of the file
				while (line != null) {	
					// check the existence of the symptom in the HashMap Occurences
					if( occurrences.containsKey(line))
						{
						// If it exists, we increment the cumulation which represents the number of occurrences
							int cumul = occurrences.get(line);
							cumul +=1;
							occurrences.put(line, cumul);
						// Otherwise we create the symptom line
						} else { 
							occurrences.put(line, 1); 
							
							}
					// Go to the next line in the file
					line = readerSymptom.readLine();
					}
				readerSymptom.close();
				}
			else  
				{
		 		System.out.println(	"This file does not exist !"	);
				}
			
		// This code sorts HashMap by keys and it is based on the use of the TreeMap class
			  Map<String, Integer> sortedMap = new TreeMap<String, Integer>(occurrences);
		      Set set = sortedMap.entrySet();
		      Iterator iterator = set.iterator();
		      
		      System.out.println( "\n"+" The length of TriMap is "+ sortedMap.size());
		      
		      System.out.println("\n"+" ------------+  After sorting   +------------");
		        System.out.println( "+-----------------------------+--------------+" );
		        System.out.println( "|             Symptom         |Nb.Occurrences|" );
		        System.out.println( "+-----------------------------+--------------+" );
		      while(iterator.hasNext()) {
		          Map.Entry me = (Map.Entry)iterator.next();
		         
		         String strS= ("" +  me.getKey() );
		         String strO= (""+ me.getValue() ); 
		         String strfinal = String.format("| %-27s | %12s |\n",strS,strO);		         
		         System.out.printf(strfinal);
		    
		         
		      }

		   // display a footer
		      System.out.println( "+-----------------------------+--------------+" );
		   // Display of HashMap occurrences
		      System.out.println("\n"+ "The length of occurrences is " + occurrences.size() +"\n");
			for(Entry<String, Integer> donnees : occurrences.entrySet())
				{				
					System.out.println(" Symptom: " + donnees.getKey() + " with " + donnees.getValue() +" occurence(s)");				
				}
	// Creation of the backup file of the results of the occurrences with Sort
			
			File folder = new File("c://Users/Ptiqu/Desktop/Symptoms_treated");
			File fileT = new File("c://Users/Ptiqu/Desktop/Symptoms_treated/results.out.txt");
			
			if(!folder.exists())
			{
				folder.mkdir();		
			}
		
			if(!fileT.exists())
			{
				try {
					fileT.createNewFile();			
				} catch ( IOException e) {
					e.printStackTrace();
				}
			}
			  // try/catch necessary to manage a possible writing problem
				try {
					FileWriter writer = new FileWriter(fileT);
					BufferedWriter bw = new BufferedWriter(writer);
					
					bw.write( "+--------------------------------------------+" );
					bw.newLine();
					bw.write( "|        File processing symptoms.txt        |");
					bw.newLine();
					bw.write( "+-----------------------------+--------------+" );
					bw.newLine();
					bw.write( "|             Symptom         |Nb.Occurrences|" );
					bw.newLine();
					bw.write( "+-----------------------------+--------------+" );
					bw.newLine();
					
					Map sortedMapF = new TreeMap(occurrences);
				    Set setF = sortedMapF.entrySet();
				    Iterator iteratorF = setF.iterator();
					
			      while(iteratorF.hasNext()) {
			         Map.Entry meF = (Map.Entry)iteratorF.next();
			         String strS= ("" +  meF.getKey() );
			         String strO= (""+ meF.getValue() ); 
			         String strfinal = String.format("| %-27s | %12s |\n",strS,strO);
			         bw.write(strfinal);	      
			      }
			      bw.write( "+-----------------------------+--------------+" );				
				// close buffererd and writer - otherwise infinite loop
			      bw.close();
			      writer.close();
					
				// treatment of the exception if the file does not exist
				} catch(IOException e) {
					e.printStackTrace();
				}
				 
			
		}
	}