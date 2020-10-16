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
public abstract class CountSymptoms implements ISymptomsCount {
	/**
	 *   Receipt of a list to return the list of words with their number of occurrences
	 * @param symptomsOrdered : the list accessed in alphabetical order
	 * @param symptomsList : List original list of symptoms not classified
	 * @return we return a Treemap :  the symptoms with their number of occurrences
	 */
	public static TreeMap<String, Integer> Count(Set<String> symptomsOrdered, List<String> symptomsList)
	{
	
		TreeMap<String, Integer> symptomsOccurrences = new TreeMap<>();
			
		for(String st: symptomsOrdered)
			{
				int frequence = Collections.frequency(symptomsList, st);	
				symptomsOccurrences.put(st, frequence);			
			} 		
		return symptomsOccurrences;	
	} 
}
		
	