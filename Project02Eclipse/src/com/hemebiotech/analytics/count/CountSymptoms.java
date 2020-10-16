package com.hemebiotech.analytics.count;

import java.util.Collections;
import java.util.Set;
import java.util.TreeMap;
/**
 *  Receipt of a list to return the list of words with their number of occurrences
 * @author Laurent Y.
 *
 */
public class CountSymptoms implements ISymptomsCount {
	/**
	 *   Receipt of a list to return the list of words with their number of occurrences
	 * @param symptomsOrdered : the list accessed in alphabetical order
	 * @return we return a Treemap :  the symptoms with their number of occurrences
	 */
	public  TreeMap<String, Integer> count(Set<String> symptomsOrdered)
	{
	
		TreeMap<String, Integer> symptomsOccurrences = new TreeMap<>();
			
		for(String st: symptomsOrdered)
			{
				int frequence = Collections.frequency(symptomsOrdered, st);	
				symptomsOccurrences.put(st, frequence);			
			} 		
		return symptomsOccurrences;	
	} 
}
		
	