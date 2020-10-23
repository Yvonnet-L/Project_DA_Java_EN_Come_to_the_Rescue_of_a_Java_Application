package com.hemebiotech.analytics.write;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
/**
 *  Process a Map for saving in a text file: results.out.txt
 * @author Laurent Y.
 */
public class WriteSympOutTxt implements ISympWriter{
	/**
	 * @param outMlst: Map that lists the symptoms with their occurrences
	 *
	 * Création with FileOutputStream
	 */ 
	@Override
	public void writerResults(Map<String, Integer> outMlst) {
			FileOutputStream fos = null;			 
					try {						
						fos = new FileOutputStream("resultsOut.txt");
						
						fos.write(("+--------------------------------------------+"+" \n").getBytes() );
						fos.write(("|        File processing symptoms.txt        |"+" \n").getBytes() );
						fos.write(("+-----------------------------+--------------+"+" \n").getBytes() );
						fos.write(("|             Symptom         |Nb.Occurrences|"+" \n").getBytes() );
						fos.write(("+-----------------------------+--------------+"+" \n").getBytes() );
		
						for(Map.Entry <String, Integer>entry: outMlst.entrySet())
						{
						String cle= ("" +  entry.getKey() );
						String valeur= (""+ entry.getValue() ); 
						String strfinal = String.format("| %-27s | %12s |\n",cle,valeur);
						fos.write((strfinal).getBytes() );
						} 
						fos.write(("+-----------------------------+--------------+").getBytes() );   
				     
					// treatment of the exception if the file does not exist
					} catch(IOException e) {
						e.printStackTrace();
					}finally {
						try {
							if ( fos != null ) {
									fos.close();				
									System.out.println("--->  OutTxt.txt file created  <---");
								}
							} catch (IOException e) {
							e.printStackTrace();
							}
					}	
	}
}
