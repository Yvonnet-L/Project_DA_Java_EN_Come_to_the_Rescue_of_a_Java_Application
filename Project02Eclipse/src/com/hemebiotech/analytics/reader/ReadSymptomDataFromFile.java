package com.hemebiotech.analytics.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *@author Caroline H�dot
 */
public class ReadSymptomDataFromFile implements ISymptomReader { 

	private String filepath;
	/**
	 * 
	 * @param filepath a full or partial path to file with symptomgit branch strings in it, one per line
	 *           		 finally use of a dialog box to select the file 
	 */
	public ReadSymptomDataFromFile (String filepath){
		this.filepath = filepath;
	}
	@Override
	public List<String> getSymptoms(){
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
					}
			reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
			}
		}	
		return result;
	}
}
