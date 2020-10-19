package com.hemebiotech.analytics.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
/**
 *  Process a HashMap for saving in a text file: results.out.txt
 * @author Laurent Y.
 *
 */
public class WriteSympOutTxt implements ISympWriter {
	/**
	 * @param outMlst   Map that we want to use
	 * @throws IOException 
	 */
	// Creation of the backup file of the results of the occurrences with Sort	
	@Override
	public void writerResults(Map<String, Integer> outMlst) throws IOException {	
		
			File fileT = new File("resultsOut.txt");				
					if(!fileT.exists())
				{
					try {
						fileT.createNewFile();			
					} catch ( IOException e) {
						e.printStackTrace();
					}
				}
				  // try/catch necessary to manage a possible writing problem
					FileWriter writer = new FileWriter(fileT);
					BufferedWriter bw = new BufferedWriter(writer);
					try {	
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
					
						for ( Map.Entry<String, Integer> entry: outMlst.entrySet() )
						{
							String cle= ("" +  entry.getKey() );
							String valeur= (""+ entry.getValue() ); 
							String strfinal = String.format("| %-27s | %12s |\n",cle,valeur);
							bw.write(strfinal);
						} 							
				      bw.write( "+-----------------------------+--------------+" );				
	
					} catch(IOException e) {
						e.printStackTrace();	
					}finally {
						// close buffererd and writer - otherwise infinite loop					   
							bw.close();
							writer.close(); 
						  System.out.println("--->  OutTxt.txt file created  1 <---");
					}	
	}
}
