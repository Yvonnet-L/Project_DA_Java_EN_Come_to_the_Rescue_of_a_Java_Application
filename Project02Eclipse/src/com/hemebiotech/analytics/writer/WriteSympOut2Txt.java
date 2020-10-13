package com.hemebiotech.analytics.writer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
/**
 *  Process a HashMap for saving in a text file: results.out.txt
 * @author ptiqu
 */
public class WriteSympOut2Txt {
	/**
	 * @param outMlst   Hashlist that we want to use
	 */
	// Creation of the backup file of the results of the occurrences with Sort
	// Création avec LileOutpuStream
	public void outMlst(Map<String, Integer> outMlst) {
			FileOutputStream fos = null;			
					try {						
						fos = new FileOutputStream("resultsOut2.txt");
						
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
						fos.write(("+-----------------------------+--------------+"+" \n").getBytes() );   
				     
					// treatment of the exception if the file does not exist
					} catch(IOException e) {
						e.printStackTrace();
					}finally {
						try {
							if ( fos != null ) {
									fos.close();				
									System.out.println("--->  OutTxt2.txt file created  2 <---");
							}
							} catch (IOException e) {
							e.printStackTrace();
							}
					}	
	}
}
