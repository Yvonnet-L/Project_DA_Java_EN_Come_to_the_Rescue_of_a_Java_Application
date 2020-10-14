package com.hemebiotech.analytics.count;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/**
 *  Receipt of a list to return the list of words with their number of occurrences
 * @author ptiqu
 *
 */
public abstract class CountSymptoms implements ISymptomsCount {
	

	public static Map<String, Integer> mlst = new HashMap<>();
	public List<String> resultL = new ArrayList<>();

	public CountSymptoms(List<String> resultL) {
		super();
		this.resultL = resultL;
	}
	/**
	 *   Receipt of a list to return the list of words with their number of occurrences
	 * @param resultL : the list accessed in alphabetical order
	 * @return we return a Treemap :  the symptoms with their number of occurrences
	 */
	public static Map<String, Integer> Count(List<String> resultL) {
	
		Map<String, Integer> occurrences = new TreeMap<>();
		for(String st : resultL)
		{
			if( occurrences.containsKey(st))
			{
			// If it exists, we increment the cumulation which represents the number of occurrences //
				int cumul = occurrences.get(st);
				cumul +=1;
				occurrences.put(st, cumul);
			//  Otherwise we create the symptom line //
			} else { 
				occurrences.put(st, 1);
				}
		}
		//System.out.println(occurrences.toString());
		return occurrences;	
	}
}
