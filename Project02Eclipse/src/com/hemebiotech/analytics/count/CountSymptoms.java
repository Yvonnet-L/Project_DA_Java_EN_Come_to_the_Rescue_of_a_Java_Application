package com.hemebiotech.analytics.count;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
/**
 *  Receipt of a list to return the list of words with their number of occurrences
 * @author Laurent Y.
 *	
 */
public class CountSymptoms implements ISymptomsCount {
	/**
	 *   
	 * @param symptomsOrdered : the list accessed in alphabetical order
	 * @param resultL List of symptoms with occurrence
	 * @return we return a Treemap :  the symptoms with their number of occurrences
	 */
	@Override
	public  TreeMap<String, Integer> count(Set<String> symptomsOrdered, List<String>resultL)
	{
		TreeMap<String, Integer> symptomsOccurrences = new TreeMap<>();
		for(String st: symptomsOrdered)
			{
				int frequence = Collections.frequency(resultL, st);	
				symptomsOccurrences.put(st, frequence);	
			} 		
		return symptomsOccurrences;	
	} 
}
		
	