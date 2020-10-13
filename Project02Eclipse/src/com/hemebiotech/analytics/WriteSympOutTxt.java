package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
/**
 *  Process a HashMap for saving in a text file: results.out.txt
 * @author ptiqu
 *
 */
public class WriteSympOutTxt {
	/**
	 * @param outMlst   Hashlist that we want to use
	 */
	// Creation of the backup file of the results of the occurrences with Sort	
	public static void outMlst(Map<String, Integer> outMlst) {
	
			File fileT = new File("c://Users/ptiqu/git/sourceP2/correction/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/resultsOut.txt");
			
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
					
						for(Map.Entry entry: outMlst.entrySet())
						{
						String cle= ("" +  entry.getKey() );
						String valeur= (""+ entry.getValue() ); 
						String strfinal = String.format("| %-27s | %12s |\n",cle,valeur);
						bw.write(strfinal);
						} 
				      bw.write( "+-----------------------------+--------------+" );				
					// close buffererd and writer - otherwise infinite loop
				      bw.close();
				      writer.close();
				      System.out.println("--->  OutTxt.txt file created   <---");
					// treatment of the exception if the file does not exist
					} catch(IOException e) {
						e.printStackTrace();
					}				
	}
}
